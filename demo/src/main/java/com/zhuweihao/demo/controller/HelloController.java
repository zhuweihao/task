package com.zhuweihao.demo.controller;

import com.zhuweihao.customerspringbootstarterconfigure.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhuweihao
 * @Date 2023/2/23 15:49
 * @Description com.zhuweihao.demo.controller
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @GetMapping("/testSpringbootStarter")
    public String sayHello(){
        return helloService.sayHello("张三");
    }
}
