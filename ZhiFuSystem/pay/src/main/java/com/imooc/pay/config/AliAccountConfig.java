package com.imooc.pay.config;

/**
 * @ClassName AliAccountConfig
 * @Author Administrator
 * @Date 2020/3/8 21:52
 */

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 阿里账号配置。
 */

@Component
@ConfigurationProperties(prefix = "ali")
@Data
public class AliAccountConfig {
    private String appId;
    private String privateKey;
    private String aliPayPublicKey;
    private String notifyUrl;
    private String returnUrl;
}
