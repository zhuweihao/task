package com.zhuweihao.demo.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author zhuweihao
 * @Date 2023/2/21 16:58
 * @Description com.zhuweihao.demo.mapper.dto
 */
@Setter
@Getter
@ToString
public class AlertCountDTO {
    private String createDate;
    private Long count;
}
