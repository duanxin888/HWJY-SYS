package com.duanxin.hwjy.infrastructure.repository.po;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductPO
 * @date 2021/03/29 10:50
 */
@Setter
@Getter
public class ProductPO {

    private int id;

    private String name;

    private int cid;

    private String picUrl;

    private String productSn;

    private String details;

    private int sorted;

    private String transactionRule;

    private String brief;

    private int onSale;

    private int deleted;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;
}
