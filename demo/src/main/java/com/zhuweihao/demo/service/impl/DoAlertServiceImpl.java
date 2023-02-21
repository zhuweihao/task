package com.zhuweihao.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuweihao.demo.mapper.DoAlertMapper;
import com.zhuweihao.demo.pojo.DoAlert;
import com.zhuweihao.demo.service.DoAlertService;
import org.springframework.stereotype.Service;

/**
 * @Author zhuweihao
 * @Date 2023/2/21 15:32
 * @Description com.zhuweihao.demo.service.impl
 */
@Service
public class DoAlertServiceImpl extends ServiceImpl<DoAlertMapper, DoAlert> implements DoAlertService {
}
