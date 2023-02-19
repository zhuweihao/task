package com.zhuweihao.dao;

import com.zhuweihao.pojo.AlertCount;
import com.zhuweihao.pojo.DoAlert;

import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author zhuweihao
 * @Date 2023/2/19 18:55
 * @Description com.zhuweihao.dao.base
 */
public interface DoAlertDAO {
    //查询数据表中的全部数据
    List<DoAlert> getAll(Connection connection);
    //根据id修改告警状态
    void updateStatusById(Connection connection,Integer id,Integer status);
    //获取指定id的记录
    DoAlert getAlertById(Connection connection,Integer id);
    //插入记录
    void insert(Connection connection,DoAlert doAlert);
    //按天统计报警次数
    List<AlertCount> getAlertCountByDay(Connection connection);
    //按周统计报警次数
    List<AlertCount> getAlertCountByWeek(Connection connection);
    //按月统计报警次数
    List<AlertCount> getAlertCountByMonth(Connection connection);
    //按天统计指定月份报警次数
    List<AlertCount> getAlertCountByDayWithMonth(Connection connection,String month);
}
