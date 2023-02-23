package com.zhuweihao.customerspringbootstarterconfigure.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhuweihao
 * @Date 2023/2/23 15:30
 * @Description com.zhuweihao.customerspringbootstarterconfigure.bean
 */
@ConfigurationProperties("zhuweihao.customerspringbootstarterconfigure")
public class HelloProperties {
    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
