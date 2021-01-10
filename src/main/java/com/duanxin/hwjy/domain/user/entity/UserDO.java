package com.duanxin.hwjy.domain.user.entity;

import com.duanxin.hwjy.domain.user.entity.valueobject.UserStatus;
import com.duanxin.hwjy.infrastructure.common.enums.Constants;
import com.duanxin.hwjy.infrastructure.common.enums.Deleted;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className UserDO
 * @date 2021/01/10 09:10
 */
@Setter
@Getter
public class UserDO {

    private int id;

    private String phone;

    private String userImgUrl;

    private IntegralAccountDO integralAccount;

    private String nickname;

    private String wxOpenid;

    private String wxSessionKey;

    private UserStatus status = UserStatus.AVAILABLE;

    private Deleted deleted = Deleted.VALID;

    private LocalDateTime cdate = LocalDateTime.now();

    private String creator = Constants.CREATOR.getDesc();

    private LocalDateTime edate = LocalDateTime.now();

    private String editor = Constants.EDITOR.getDesc();

    private List<UserAddressDO> userAddressDOS;
}
