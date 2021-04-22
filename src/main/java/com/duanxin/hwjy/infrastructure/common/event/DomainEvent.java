package com.duanxin.hwjy.infrastructure.common.event;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className DomainEvent
 * @date 2021/01/08 19:01
 */
@Getter
@Setter
public class DomainEvent {
    String id;
    LocalDateTime timestamp = LocalDateTime.now();
    String source;
    String data;
}
