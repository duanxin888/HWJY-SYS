package com.duanxin.hwjy.infrastructure.client.wx;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;

/**
 * @author duanxin
 * @version 1.0
 * @className WxClient
 * @date 2021/01/13 08:59
 */
public interface WxClient {

    WxMaJscode2SessionResult getSession(String appid, String code);
}
