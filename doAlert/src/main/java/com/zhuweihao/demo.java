package com.zhuweihao;

import com.zhuweihao.dao.DoAlertDAO;
import com.zhuweihao.dao.impl.DoAlertDAOImpl;
import com.zhuweihao.pojo.AlertCount;
import com.zhuweihao.pojo.DoAlert;
import com.zhuweihao.utils.JDBCUtils;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * @Author zhuweihao
 * @Date 2023/2/19 19:02
 * @Description com.zhuweihao
 */
public class demo {
    public static void main(String[] args) throws ParseException {
        Connection connection = JDBCUtils.getConnection();
        DoAlertDAO doAlertDAO = new DoAlertDAOImpl();

        //测试统计报警次数
        List<AlertCount> alertCountByDay = doAlertDAO.getAlertCountByDay(connection);
        for (AlertCount alertCount :
                alertCountByDay) {
            System.out.println(alertCount.toString());
        }
        List<AlertCount> alertCountByDayWithMonth = doAlertDAO.getAlertCountByDayWithMonth(connection, "2022-10");
        for (AlertCount alertCount : alertCountByDayWithMonth) {
            System.out.println(alertCount.toString());
        }

//        //测试根据指定id查询记录
//        DoAlert alertById = doAlertDAO.getAlertById(connection, 65);
//        Long firstTriggerTime = alertById.getFirstTriggerTime();
//        System.out.println("firstTriggerTime = " + firstTriggerTime);
//        Date date = new Date(firstTriggerTime);
//        System.out.println("date = " + date);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String formatDate = simpleDateFormat.format(date);
//        System.out.println("formatDate = " + formatDate);
//        Date createTime = alertById.getCreateTime();
//        System.out.println("createTime = " + createTime);
//        LocalDateTime updateTime = alertById.getUpdateTime();
//        System.out.println("updateTime = " + updateTime);
//
//        //设置createTime
//        long currentTimeMillis = System.currentTimeMillis();
//        Date currentDate = new Date(currentTimeMillis);
//        System.out.println("currentDate = " + currentDate);
//        String currentDateFormat = simpleDateFormat.format(currentDate);
//        System.out.println("currentDateFormat = " + currentDateFormat);
//        alertById.setCreateTime(simpleDateFormat.parse(currentDateFormat));
//        //设置updateTime
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime now = LocalDateTime.now();
//        now.format(dtf);
//        System.out.println("now = " + now);
//        alertById.setUpdateTime(now);
//        //测试插入功能
//        doAlertDAO.insert(connection,alertById);

//        doAlertDAO.updateStatusById(connection,64,2);

//        List<DoAlert> doAlertDAOAll = doAlertDAO.getAll(connection);
//        for (DoAlert doAlert :
//                doAlertDAOAll) {
//            System.out.println(doAlert.toString());
//        }
    }
}
