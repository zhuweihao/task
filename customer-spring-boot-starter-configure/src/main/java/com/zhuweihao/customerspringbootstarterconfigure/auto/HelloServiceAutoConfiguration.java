package com.zhuweihao.customerspringbootstarterconfigure.auto;

import com.zhuweihao.customerspringbootstarterconfigure.bean.HelloProperties;
import com.zhuweihao.customerspringbootstarterconfigure.service.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhuweihao
 * @Date 2023/2/23 15:35
 * @Description com.zhuweihao.customerspringbootstarterconfigure.auto
 */
@Configuration
@EnableConfigurationProperties(HelloProperties.class)
public class HelloServiceAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(HelloService.class)//如果需要再放入容器
    public HelloService helloService(){
        HelloService helloService = new HelloService();
        return helloService;
    }
}
