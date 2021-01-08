package com.duanxin.hwjy.infrastructure.util;

import com.duanxin.hwjy.infrastructure.config.RestClientConfig;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author duanxin
 * @version 1.0
 * @className RestClientUtil
 * @date 2020/10/05 09:39
 */
public class RestClientUtil {

    private RestClientUtil(){
    }

    public static RestTemplate restTemplate(RestClientConfig config) {
        return new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient(config)));
    }

    private static HttpClient httpClient(RestClientConfig config) {
        Registry<ConnectionSocketFactory> factoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", SSLConnectionSocketFactory.getSocketFactory())
                .build();
        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager(factoryRegistry);
        manager.setMaxTotal(config.getMaxTotal());
        manager.setDefaultMaxPerRoute(config.getDefaultMaxPerRoute());
        manager.setValidateAfterInactivity(config.getValidateAfterInactivity());
        RequestConfig requestConfig = RequestConfig.custom().
                setSocketTimeout(config.getSocketTimeout()).
                setConnectTimeout(config.getConnectTimeout()).
                setConnectionRequestTimeout(config.getConnectionRequestTimeout()).
                build();
        return HttpClientBuilder.create().
                setDefaultRequestConfig(requestConfig).
                setConnectionManager(manager).
                build();
    }
}
