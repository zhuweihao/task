package com.zhuweihao.demo.controller;

import com.alibaba.fastjson2.JSON;
import com.zhuweihao.demo.pojo.DoAlert;
import com.zhuweihao.demo.pojo.dto.AlertCountDTO;
import com.zhuweihao.demo.service.impl.DoAlertServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author zhuweihao
 * @Date 2023/2/21 15:07
 * @Description com.zhuweihao.demo.controller
 */
@RestController
public class DoAlertController {
    private final DoAlertServiceImpl doAlertService;

    public DoAlertController(DoAlertServiceImpl doAlertService) {
        this.doAlertService = doAlertService;
    }

    @GetMapping("/doAlert/{id}")
    public DoAlert getDoAlertById(@PathVariable Integer id) {
        return doAlertService.getById(id);
    }

    @PostMapping("/doAlert/saveOrUpdate")
    public void insertDoAlert(@RequestBody String content) {
        DoAlert doAlert = JSON.parseObject(content, DoAlert.class);
        doAlertService.saveOrUpdate(doAlert);
    }

    @DeleteMapping("/doAlert/delete")
    public void deleteDoAlert(@RequestBody String content) {
        DoAlert doAlert = JSON.parseObject(content, DoAlert.class);
        doAlertService.removeById(doAlert);
    }

    @GetMapping("/doAlert/getMonthCount")
    public List<AlertCountDTO> getDayCount() {
        return doAlertService.getBaseMapper().getAlertCountByMonth();
    }
}
