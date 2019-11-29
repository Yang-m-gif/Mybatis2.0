package com.slk.authority.module.aut_user_role.po;

import lombok.Data;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
@Data
public class AutUserRole{
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /* 用户ID */
    private Integer user_id;

    /* 角色ID */
    private Integer role_id;

    /* 角色类型Id(如果多个用户表会造成Id重复，用来区分用户) */
    private Integer region_id;

    /* 创建者ID */
    private Integer modify_userid;

    /* 创建时间 */
    private Date modify_date;

}