package com.duanxin.hwjy.domain.user.entity;

import com.duanxin.hwjy.domain.user.entity.valueobject.Acquiescence;
import com.duanxin.hwjy.infrastructure.common.constants.Constants;
import com.duanxin.hwjy.infrastructure.common.enums.Deleted;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAddressDO
 * @date 2021/01/10 09:10
 */
@Getter
@Setter
public class UserAddressDO {

    private int id;

    private String name;

    private int userId;

    private String province;

    private String city;

    private String county;

    private String addressDetails;

    private String postalCode;

    private String phone;

    private Acquiescence acquiescence = Acquiescence.NOT_ACQUIESCENCE;

    private Deleted deleted = Deleted.VALID;

    private LocalDateTime cdate = LocalDateTime.now();

    private String creator = Constants.CREATOR.getDesc();

    private LocalDateTime edate = LocalDateTime.now();

    private String editor = Constants.EDITOR.getDesc();

    public void acquiesceIn() {
        this.setAcquiescence(Acquiescence.ACQUIESCENCE);
    }

    public void updateAddress() {
        this.setEdate(LocalDateTime.now());
        this.setEditor(String.valueOf(this.getUserId()));
    }

    public void updateAcquiescence() {
        this.setEdate(LocalDateTime.now());
        this.setEditor(String.valueOf(this.getUserId()));
    }
}
