package com.zhuweihao.customerspringbootstarterconfigure.service;

import com.zhuweihao.customerspringbootstarterconfigure.bean.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author zhuweihao
 * @Date 2023/2/23 15:29
 * @Description com.zhuweihao.customerspringbootstarterconfigure.service
 */
public class HelloService {

    @Autowired
    HelloProperties helloProperties;

    public String sayHello(String userName) {
        return helloProperties.getPrefix() + userName + helloProperties.getSuffix();
    }
}
