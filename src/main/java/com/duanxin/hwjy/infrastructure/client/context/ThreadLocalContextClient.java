package com.duanxin.hwjy.infrastructure.client.context;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author duanxin
 * @version 1.0
 * @className ThreadLocalContextClient
 * @date 2021/01/30 11:01
 */
@Service
public class ThreadLocalContextClient implements ContextClient{

    private static final ThreadLocal<Map<String, Object>> CONTEXT =
            ThreadLocal.withInitial(() -> new HashMap<>(4));

    @Override
    public Map<String, Object> getContext() {
        return CONTEXT.get();
    }

    @Override
    public <T> T get(String key) {
        Map<String, Object> map = CONTEXT.get();
        return (T) map.get(key);
    }

    @Override
    public <T> T get(String key, T defaultVal) {
        return Optional.ofNullable((T) CONTEXT.get().get(key)).orElse(defaultVal);
    }

    @Override
    public void set(String key, Object value) {
        CONTEXT.get().put(key, value);
    }

    @Override
    public void set(Map<String, Object> keyValueMap) {
        CONTEXT.get().putAll(keyValueMap);
    }

    @Override
    public <T> T remove(String key) {
        return (T) CONTEXT.get().remove(key);
    }

    @Override
    public void clear() {
        CONTEXT.remove();
    }
}
