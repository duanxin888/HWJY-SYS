package com.duanxin.hwjy.infrastructure.client.news;

import com.duanxin.hwjy.infrastructure.config.tx.TxGarbageNewsConfig;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
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
 * @className TxGarbageNewsRequestClient
 * @date 2021/02/09 08:56
 */
@Service
@Slf4j
@AllArgsConstructor
public class TxGarbageNewsRequestClient implements NewsRequestClient{

    @Qualifier("txRestTemplate")
    private final RestTemplate txRestTemplate;
    private final TxGarbageNewsConfig txGarbageNewsConfig;

    @Override
    public Optional<List<NewsResponseDto>> fetchNews(NewsRequestDto dto) {
        String url = txGarbageNewsConfig.getTxBaseConfig().getBaseUrl() + txGarbageNewsConfig.getResource() +
                "?key=" + txGarbageNewsConfig.getTxBaseConfig().getApiKey() +
                "&num=" + dto.getNum() + "&page=" + dto.getPage();
        String requestJson = JsonUtil.toString(dto);
        log.info("begin to request txGarbageNews [{}] by [{}]", url, requestJson);

        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders());
        try {
            ResponseEntity<String> response = txRestTemplate.exchange(url, HttpMethod.POST, entity, String.class);
            String body = response.getBody();

            if (!response.getStatusCode().is2xxSuccessful()) {
                log.warn("failed to fetch txGarbageNews [{}] by [{}], response [{}] status [{}]",
                        url, requestJson, body, response.getStatusCodeValue());
                return Optional.empty();
            }

            Optional<TxGarbageNewsResponse> result = JsonUtil.toObject(body, TxGarbageNewsResponse.class);
            if (!result.isPresent()) {
                log.warn("failed to parse txGarbageNews [{}] by [{}], response [{}] status [{}]",
                        url, requestJson, body, response.getStatusCodeValue());
                return Optional.empty();
            }

            TxGarbageNewsResponse txGarbageNewsResponse = result.get();
            if (txGarbageNewsResponse.code != HttpStatus.OK.value()) {
                log.warn("failed to fetch txGarbageNews [{}] by [{}], response [{}] status [{}]",
                        url, requestJson, body, response.getStatusCodeValue());
                return Optional.empty();
            }

            log.info("success to fetch [{}] txGarbageNews [{}] by [{}]", txGarbageNewsResponse.getNewslist().size(), url, requestJson);
            return Optional.ofNullable(txGarbageNewsResponse.getNewslist());
        } catch (Exception exception) {
            log.warn("failed to fetch txGarbageNews [{}] by [{}] exception", url, requestJson, exception);
            return Optional.empty();
        }
    }

    private HttpHeaders httpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return headers;
    }

    @Setter
    @Getter
    static class TxGarbageNewsResponse {

        private int code;

        private String msg;

        private List<NewsResponseDto> newslist;
    }
}
