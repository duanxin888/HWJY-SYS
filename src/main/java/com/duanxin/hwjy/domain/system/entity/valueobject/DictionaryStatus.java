package com.duanxin.hwjy.domain.system.entity.valueobject;

/**
 * @author duanxin
 * @version 1.0
 * @className DictionaryStatus
 * @date 2021/02/27 11:14
 */
public enum DictionaryStatus {

    AVAILABLE, DISABLE;

    public static boolean isAvailable(DictionaryStatus dictionaryStatus) {
        return DictionaryStatus.AVAILABLE.equals(dictionaryStatus);
    }

    public static DictionaryStatus formatByName(String name) {
        for (DictionaryStatus value : values()) {
            if (value.name().equals(name)) {
                return value;
            }
        }
        return AVAILABLE;
    }
}
