package com.zhuweihao.demo.controller;

import com.alibaba.fastjson2.JSON;
import com.sun.org.glassfish.gmbal.ParameterNames;
import com.zhuweihao.demo.pojo.Person;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhuweihao
 * @Date 2023/2/20 20:38
 * @Description com.zhuweihao.demo.controller
 */
@RestController
public class TestController {

    @GetMapping("/{id}/{name}")
    public Map<String, Object> getPerson(@PathVariable("id") Integer id,
                                         @PathVariable("name") String name) {
        Map<String,Object> objectMap=new HashMap<>();
        objectMap.put("id",id);
        objectMap.put("name",name);
        return objectMap;
    }

    @PostMapping("/save")
    public Map postMethod(@RequestBody String str){
        Map<String,Object> objectMap=new HashMap<>();
        objectMap.put("content",str);
        System.out.println(str);
        Person person = JSON.parseObject(str, Person.class);
        System.out.println(person);
        return objectMap;
    }

    @ResponseBody
    @GetMapping("/testxml")
    public Person getPerson(){
        Person person = new Person();
        person.setId(3);
        person.setName("yang");
        return person;
    }

}
