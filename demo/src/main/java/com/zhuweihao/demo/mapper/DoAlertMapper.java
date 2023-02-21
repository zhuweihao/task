package com.zhuweihao.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhuweihao.demo.pojo.DoAlert;
import com.zhuweihao.demo.pojo.dto.AlertCountDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhuweihao
 * @Date 2023/2/21 15:07
 * @Description com.zhuweihao.demo.mapper
 */
@Repository
public interface DoAlertMapper extends BaseMapper<DoAlert> {

    List<AlertCountDTO> getAlertCountByMonth();

    Page<DoAlert> getAlertByDay(Page page,Integer monitorType);
}
