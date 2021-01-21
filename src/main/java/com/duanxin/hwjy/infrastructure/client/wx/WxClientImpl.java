package com.duanxin.hwjy.infrastructure.client.wx;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.duanxin.hwjy.infrastructure.common.exception.HWJYCheckException;
import com.duanxin.hwjy.infrastructure.common.exception.ResultEnum;
import com.duanxin.hwjy.infrastructure.configuration.WxMaConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author duanxin
 * @version 1.0
 * @className WxClientImpl
 * @date 2021/01/13 08:59
 */
@Service
@Slf4j
public class WxClientImpl implements WxClient {

    @Override
    public WxMaJscode2SessionResult getSession(String appid, String code) {
        log.info("begin to get session info by appid [{}] code [{}]", appid, code);
        WxMaJscode2SessionResult result = null;

        try {
            result = getWxMaService(appid).getUserService().getSessionInfo(code);
        } catch (Exception ex) {
            log.warn("fail to get session by appid [{}] code [{}] exception",
                    appid, code, ex);
            throw new HWJYCheckException(ResultEnum.REQUEST_WX_CODE2SESSION_API_FAIL);
        }

        if (StringUtils.isBlank(result.getOpenid()) || StringUtils.isBlank(result.getSessionKey())) {
            log.warn("get session by appid [{}] code [{}] with openid or sessionKey is empty", appid, code);
            throw new HWJYCheckException(ResultEnum.REQUEST_WX_CODE2SESSION_API_FAIL);
        }
        log.info("success to get session by appid [{}] code [{}]", appid, code);
        return result;
    }

    private WxMaService getWxMaService(String appid) {
        return WxMaConfiguration.getMaService(appid);
    }
}
