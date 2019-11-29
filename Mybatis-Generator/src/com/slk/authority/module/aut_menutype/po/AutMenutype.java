package com.slk.authority.module.aut_menutype.po;

import lombok.Data;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
@Data
public class AutMenutype{
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /* 菜单类型 */
    private String name;

    /* 启用状态 0启用-1停用 */
    private Integer status;

    /* 顺序 */
    private Integer orders;

    /* 创建者（创建，修改） */
    private Integer modify_userid;

    /* 更新时间（创建，修改） */
    private Date modify_date;

}