package com.slk.equipment.module.eq_repair_staff.po;

import lombok.Data;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
@Data
public class EqRepairStaff{
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer fid;

    /* 维修员工姓名 */
    private String name;

    /* 维修员工手机号 */
    private Integer phone;

    /* 操作人 */
    private Integer modify_userid;

    /* 操作时间 */
    private Date modify_date;

}