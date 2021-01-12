package com.duanxin.hwjy.infrastructure.configuration;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import cn.binarywang.wx.miniapp.message.WxMaMessageRouter;
import com.duanxin.hwjy.infrastructure.common.exception.HWJYCheckException;
import com.duanxin.hwjy.infrastructure.common.exception.HWJYServerException;
import com.duanxin.hwjy.infrastructure.common.exception.ResultEnum;
import com.duanxin.hwjy.infrastructure.config.WxMaConfig;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.util.http.apache.DefaultApacheHttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className WxMaConfiguration
 * @date 2021/01/12 08:46
 */
@Configuration
@EnableConfigurationProperties(WxMaConfig.class)
@Slf4j
public class WxMaConfiguration {

    private final WxMaConfig wxMaConfig;

    private static final Map<String, WxMaMessageRouter> ROUTERS = new HashMap<>();
    private static Map<String, WxMaService> maServices;

    @Autowired
    public WxMaConfiguration(WxMaConfig wxMaConfig) {
        this.wxMaConfig = wxMaConfig;
    }

    @PostConstruct
    public void init() {
        List<WxMaConfig.Config> configs = this.wxMaConfig.getConfigs();
        if (CollectionUtils.isEmpty(configs)) {
            throw new HWJYServerException(ResultEnum.WX_MA_NOT_CONFIG);
        }

        maServices = configs.stream().map(t -> {
            WxMaDefaultConfigImpl config = new WxMaDefaultConfigImpl();
            config.setAppid(t.getAppid());
            config.setSecret(t.getSecret());
            config.setAesKey(t.getAesKey());
            config.setToken(t.getToken());
            config.setMsgDataFormat(t.getMsgDataFormat());
            config.setApacheHttpClientBuilder(DefaultApacheHttpClientBuilder.get());

            WxMaService service = new WxMaServiceImpl();
            service.setWxMaConfig(config);
            ROUTERS.put(t.getAppid(), this.newRouter(service));
            return service;
        }).collect(Collectors.toMap(s -> s.getWxMaConfig().getAppid(), s -> s));
    }

    public WxMaService getMaService(String appid) {
        WxMaService service = maServices.get(appid);
        if (Objects.isNull(service)) {
            throw new HWJYCheckException(ResultEnum.APPID_NOT_MATCH_WX_SERVICE);
        }
        return service;
    }

    private WxMaMessageRouter newRouter(WxMaService service) {
        // todo: not use wx router, so I'll talk about it later
        return null;
    }
}
