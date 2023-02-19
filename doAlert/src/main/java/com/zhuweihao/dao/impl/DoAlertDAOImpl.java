package com.zhuweihao.dao.impl;

import com.zhuweihao.dao.DoAlertDAO;
import com.zhuweihao.dao.base.BaseDAO;
import com.zhuweihao.pojo.AlertCount;
import com.zhuweihao.pojo.DoAlert;

import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author zhuweihao
 * @Date 2023/2/19 18:56
 * @Description com.zhuweihao.dao.impl
 */
public class DoAlertDAOImpl extends BaseDAO implements DoAlertDAO {
    @Override
    public List<DoAlert> getAll(Connection connection) {
        String sql = "select id," +
                "monitor_type as monitorType," +
                "process_def_id as processDefId," +
                "task_instance_id as taskInstanceId," +
                "table_id as tableId," +
                "target," +
                "alert_define_id as alertDefineId," +
                "priority," +
                "content," +
                "status," +
                "times," +
                "first_trigger_time as firstTriggerTime," +
                "last_trigger_time as lastTriggerTime," +
                "created_by as createdBy," +
                "update_by as updateBy," +
                "create_time as createTime," +
                "update_time as updateTime," +
                "workspace_id as workspaceId" +
                " from do_alert";
        return super.getForList(connection, DoAlert.class, sql);
    }

    @Override
    public void updateStatusById(Connection connection, Integer id, Integer status) {
        String sql="update do_alert set status = ? where id = ?";
        super.update(connection,sql,status,id);
    }

    @Override
    public DoAlert getAlertById(Connection connection, Integer id) {
        String sql= "select id," +
                "monitor_type as monitorType," +
                "process_def_id as processDefId," +
                "task_instance_id as taskInstanceId," +
                "table_id as tableId," +
                "target," +
                "alert_define_id as alertDefineId," +
                "priority," +
                "content," +
                "status," +
                "times," +
                "first_trigger_time as firstTriggerTime," +
                "last_trigger_time as lastTriggerTime," +
                "created_by as createdBy," +
                "update_by as updateBy," +
                "create_time as createTime," +
                "update_time as updateTime," +
                "workspace_id as workspaceId" +
                " from do_alert where id = ?";
        return super.getInstance(connection,DoAlert.class,sql,id);
    }

    @Override
    public void insert(Connection connection, DoAlert doAlert) {
        String sql="insert into do_alert value(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        super.update(connection,sql,doAlert.getMonitorType(),doAlert.getProcessDefId(),doAlert.getTaskInstanceId(),doAlert.getTableId(),doAlert.getTarget(),doAlert.getAlertDefineId(),doAlert.getPriority(),doAlert.getContent(),doAlert.getStatus(),doAlert.getTimes(),doAlert.getFirstTriggerTime(),doAlert.getLastTriggerTime(),doAlert.getCreatedBy(),doAlert.getUpdateBy(),doAlert.getCreateTime(),doAlert.getUpdateTime(),doAlert.getWorkspaceId());
    }

    @Override
    public List<AlertCount> getAlertCountByDay(Connection connection) {
        String sql="select date_format(create_time, '%Y-%m-%d') createDate, count(*) as count from do_alert group by createDate;";
        return super.getForList(connection, AlertCount.class,sql);
    }

    @Override
    public List<AlertCount> getAlertCountByWeek(Connection connection) {
        String sql="select date_format(create_time, '%Y-%u') createDate, count(*) as count from do_alert group by createDate;";
        return super.getForList(connection,AlertCount.class,sql);
    }

    @Override
    public List<AlertCount> getAlertCountByMonth(Connection connection) {
        String sql="select date_format(create_time, '%Y-%m') createDate, count(*) as count from do_alert group by createDate;";
        return super.getForList(connection,AlertCount.class,sql);
    }

    @Override
    public List<AlertCount> getAlertCountByDayWithMonth(Connection connection, String month) {
        String sql="select date_format(create_time, '%Y-%m-%d') createDate, count(*) as count from do_alert where date_format(create_time, '%Y-%m')=? group by createDate;";

        return super.getForList(connection,AlertCount.class,sql,month);
    }
}
