package com.zhuweihao.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author zhuweihao
 * @Date 2023/2/19 18:31
 * @Description com.zhuweihao.pojo
 */
@Getter
@Setter
@ToString
public class DoAlert {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Integer monitorType;
    private Integer processDefId;
    private Integer taskInstanceId;
    private String tableId;
    private String target;
    private Long alertDefineId;
    private Integer priority;
    private String content;
    private Integer status;
    private Integer times;
    private Long firstTriggerTime;
    private Long lastTriggerTime;
    private Long createdBy;
    private Long updateBy;
    private Date createTime;
    private LocalDateTime updateTime;
    private Integer workspaceId;
}
