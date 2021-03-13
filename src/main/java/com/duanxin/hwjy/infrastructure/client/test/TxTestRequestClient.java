package com.duanxin.hwjy.infrastructure.client.test;

import com.duanxin.hwjy.infrastructure.config.tx.TxGarbageTestConfig;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

/**
 * @author duanxin
 * @version 1.0
 * @className TxTestRquestClient
 * @date 2021/03/05 20:28
 */
@Service
@AllArgsConstructor
@Slf4j
public class TxTestRequestClient implements TestRequestClient{

    @Qualifier("txRestTemplate")
    private final RestTemplate restTemplate;
    private final TxGarbageTestConfig testConfig;

    @Override
    public Optional<List<TestResponseDto>> fetchTest() {
        String url = testConfig.getBaseConfig().getBaseUrl() + testConfig.getResource() +
                "?key=" + testConfig.getBaseConfig().getApiKey();
        log.info("begin to request TxTestRequestClient url [{}]", url);
        HttpEntity<String> entity = new HttpEntity<>(null, headers());
        try {
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
            String body = responseEntity.getBody();
            if (!responseEntity.getStatusCode().is2xxSuccessful()) {
                log.warn("failed to request TxTestRequestClient url [{}] status [{}] response [{}]",
                        url, responseEntity.getStatusCodeValue(), body);
                return Optional.empty();
            }

            Optional<TxGarbageTestResponse> responseOptional = JsonUtil.toObject(body, TxGarbageTestResponse.class);
            if (!responseOptional.isPresent()) {
                log.warn("failed to parse TxGarbageTest [{}] url [{}] status [{}]",
                        body, url, responseEntity.getStatusCodeValue());
                return Optional.empty();
            }

            if (responseOptional.get().getCode() != HttpStatus.OK.value()) {
                log.warn("failed to request TxTestRequestClient url [{}] status [{}] response [{}]",
                        url, responseEntity.getStatusCodeValue(), body);
                return Optional.empty();
            }

            log.info("success to request TxTestRequestClient url [{}] response [{}]", url, body);
            return Optional.ofNullable(responseOptional.get().getResponseDtos());
        } catch (Exception exception) {
            log.warn("failed to request TxTestRequestClient url [{}] exception", url, exception);
            return Optional.empty();
        }
    }

    private HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return headers;
    }

    @Setter
    @Getter
    private static class TxGarbageTestResponse {

        private int code;

        private String msg;

        @JsonProperty("newslist")
        private List<TestResponseDto> responseDtos;
    }
}
