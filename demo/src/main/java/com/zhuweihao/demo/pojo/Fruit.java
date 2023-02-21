package com.zhuweihao.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author zhuweihao
 * @Date 2023/2/21 11:37
 * @Description com.zhuweihao.demo.pojo
 */
@Data
@TableName("Fruit")
public class Fruit {

    @TableId
    private Integer fid;
    private String fname;
    private Integer price;
    private Integer fcount;
    private String remark;
}
