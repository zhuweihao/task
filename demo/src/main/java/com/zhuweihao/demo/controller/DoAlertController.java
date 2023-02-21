package com.zhuweihao.demo.controller;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhuweihao.demo.pojo.DoAlert;
import com.zhuweihao.demo.pojo.dto.AlertCountDTO;
import com.zhuweihao.demo.service.impl.DoAlertServiceImpl;
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
    public List<AlertCountDTO> getMonthCount() {
        return doAlertService.getBaseMapper().getAlertCountByMonth();
    }

    @GetMapping("/doAlert/getPage/{date}")
    public List<DoAlert> getPage(@PathVariable String date) {
        //String regex = "(2022|2023)-(0\\d|1[012])-(0[1-9]|[12]\\d|30)";
        String regex = "(2022|2023)-(0[1-9]|1[012])";
        if (date.matches(regex)) {
            Page<DoAlert> alertByMonthPage = doAlertService.getBaseMapper().getAlertByMonthPage(new Page<>(2, 4), date);
            System.out.println(alertByMonthPage);
            List<DoAlert> records = alertByMonthPage.getRecords();
            for (DoAlert record : records) {
                System.out.println(record);
            }
            return records;
        } else if (date.matches("(2022|2023)-(0\\d|1[012])-(0[1-9]|[12]\\d|30)")) {
            Page<DoAlert> alertByDayPage = doAlertService.getBaseMapper().getAlertByDayPage(new Page<>(2, 4), date);
            System.out.println(alertByDayPage);
            List<DoAlert> records = alertByDayPage.getRecords();
            for (DoAlert record : records) {
                System.out.println(record);
            }
            return records;
        } else {
            System.out.println("输入错误");
            return null;
        }
    }
}
