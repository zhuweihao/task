package com.zhuweihao.pojo;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author zhuweihao
 * @Date 2023/2/19 18:31
 * @Description com.zhuweihao.pojo
 */
@Data
public class DoAlert {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
