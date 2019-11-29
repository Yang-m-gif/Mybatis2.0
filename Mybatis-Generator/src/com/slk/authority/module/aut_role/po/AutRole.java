package com.slk.authority.module.aut_role.po;

import lombok.Data;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
@Data
public class AutRole{
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /* 角色名称 */
    private String name;

    /* 角色描述 */
    private String depict;

    /* 区域类型Id */
    private Integer region_id;

    /* 创建者（创建，修改） */
    private Integer modify_userid;

    /* 更新时间（创建，修改） */
    private Date modify_date;

}