package com.duanxin.hwjy.infrastructure.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author duanxin
 * @version 1.0
 * @className JsonUtil
 * @date 2020/09/30 14:05
 */
@Slf4j
public class JsonUtil {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    static {
        // 配置序列化等级
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 配置时间转换格式
        OBJECT_MAPPER.setDateFormat(new SimpleDateFormat(DATE_FORMAT));
        // 配置json缩进支持
        OBJECT_MAPPER.configure(SerializationFeature.INDENT_OUTPUT, false);
        // 允许单个数值当数组
        OBJECT_MAPPER.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        // 禁止重复建，抛出异常
        OBJECT_MAPPER.enable(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY);
        // 禁止数字当成枚举，抛出异常
        OBJECT_MAPPER.enable(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS);
        // 有属性不能映射时不报错
        OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // 对象为空时不抛异常
        OBJECT_MAPPER.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        // 不允许的时间格式
        OBJECT_MAPPER.disable(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS);
        // 允许未知字段
        OBJECT_MAPPER.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
        // 序列化BigDecimal时之间输出原始数字还是科学计数, 默认false, 即是否以toPlainString()科学计数方式来输出
        OBJECT_MAPPER.enable(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN);
        // 识别Java8时间
        OBJECT_MAPPER.registerModule(new ParameterNamesModule());
        OBJECT_MAPPER.registerModule(new Jdk8Module());
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATE_FORMAT)))
                .addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DATE_FORMAT)));
        // 识别Guava包
        OBJECT_MAPPER.registerModule(javaTimeModule);
    }

    public static <T> Optional<T> toObject(String json, Class<T> cls) {
        if (StringUtils.isBlank(json)) {
            return Optional.empty();
        }
        try {
            JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructType((Type) cls);
            return Optional.of(OBJECT_MAPPER.readValue(json, javaType));
        } catch (IOException ex) {
            log.warn("fail to parse json [{}] to object", json, ex);
            return Optional.empty();
        }
    }

    public static <T> Optional<List<T>> toObjectList(String json, Class<T> cls) {
        if (StringUtils.isBlank(json)) {
            return Optional.empty();
        }
        try {
            CollectionType type = OBJECT_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, cls);
            return Optional.of(OBJECT_MAPPER.readValue(json, type));
        } catch (IOException ex) {
            log.warn("fail to parse json [{}] to list", json, ex);
            return Optional.empty();
        }
    }

    public static Optional<?> toObjectMap(String json) {
        if (StringUtils.isBlank(json)) {
            return Optional.empty();
        }
        try {
            MapType type = OBJECT_MAPPER.getTypeFactory().constructMapType(HashMap.class, Object.class, Object.class);
            return Optional.of(OBJECT_MAPPER.readValue(json, type));
        } catch (IOException ex) {
            log.warn("fail to parse json [{}] to map", json, ex);
            return Optional.empty();
        }
    }

    public static String toString(Object obj) {
        if (Objects.isNull(obj)) {
            return StringUtils.EMPTY;
        }
        try {
            return OBJECT_MAPPER.writeValueAsString(obj);
        } catch (IOException ex) {
            log.warn("fail to parse object to string", ex);
            return StringUtils.EMPTY;
        }
    }
}
