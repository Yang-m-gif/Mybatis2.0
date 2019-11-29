package com.slk.equipment.module.eq_repairIng.po;

import lombok.Data;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
@Data
public class EqRepairing{
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer fid;

    /* 报修工单fid */
    private Integer repair_fid;

    /* 报修单号 */
    private String repair_code;

    /* 报修状态 1-待接单 2-已接单 3-已拒绝 4-待确定(已维修) 4-已完成(必须评价才可以确认完成) 6-已取消 */
    private Integer state;

    /* 操作人 */
    private Integer modify_userid;

    /* 操作时间 */
    private Date modify_date;

    /* 原因 预留字段 */
    private String reason;

}