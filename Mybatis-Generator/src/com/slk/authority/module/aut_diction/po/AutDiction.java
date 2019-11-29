package com.slk.authority.module.aut_diction.po;

import lombok.Data;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
@Data
public class AutDiction{
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /* 标签（字段值） */
    private String lable;

    /* 说明 */
    private String explians;

    /* 状态（0-启用 1-停用） */
    private Integer state;

    /* 排序 */
    private String sort;

    /* 是否删除（0-否 1-是） */
    private Integer havdel;

    /* 操作人（创建、更新） */
    private Integer modify_userid;

    /* 操作时间（创建、更新） */
    private Date modify_date;

}