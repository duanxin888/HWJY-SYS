package com.duanxin.hwjy.infrastructure.client.context;

import java.util.Map;

/**
 * @author duanxin
 * @version 1.0
 * @className ContextClient
 * @date 2021/01/30 10:50
 */
public interface ContextClient {

    /**
     * get userThread context of {@link Map}
     * @date 2021/1/30 10:51
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    Map<String, Object> getContext();

    /**
     * get value of key
     * @param key context key
     * @date 2021/1/30 10:52
     * @return T
     */
    <T> T get(String key);

    /**
     * use the defaultVal when the obtained value is null
     * @param key context key
     * @param defaultVal default value
     * @date 2021/1/30 10:53
     * @return T
     */
    <T> T get(String key, T defaultVal);

    /**
     * set value of key
     * @param key context key
     * @param value value
     * @date 2021/1/30 10:56
     * @return void
     */
    void set(String key, Object value);

    /**
     * batch setting of context key-value pairs
     * @param keyValueMap
     * @date 2021/1/30 10:56
     * @return void
     */
    void set(Map<String, Object> keyValueMap);

    /**
     * remove key-value pairs from the context
     * @param key context key
     * @date 2021/1/30 11:00
     * @return T
     */
    <T> T remove(String key);

    /**
     * clear context
     * @date 2021/1/30 11:01
     * @return void
     */
    void clear();
}
