package com.slk.authority.module.aut_region.po;

import lombok.Data;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
@Data
public class AutRegion{
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /* 名称 */
    private String name;

    /* 排序 */
    private Integer orders;

    /* 状态（0启用，1停用） */
    private Integer status;

    /* 操作人 */
    private Integer modify_userid;

    /* 更新时间 */
    private Date modify_date;

}