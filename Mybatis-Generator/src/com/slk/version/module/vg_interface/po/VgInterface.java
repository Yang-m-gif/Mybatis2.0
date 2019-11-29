package com.slk.version.module.vg_interface.po;

import lombok.Data;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
@Data
public class VgInterface{
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /* 项目id */
    private Integer project_id;

    /* 模块id */
    private Integer model_id;

    /* 接口名称 */
    private String name;

    /* 接口地址 */
    private String address;

    /* 接口描述 */
    private String description;

    /* 创建者（创建，修改） */
    private Integer modify_userid;

    /* 更新时间（创建，修改） */
    private Date modify_date;

    /* 状态 0-使用 1-删除 */
    private Integer state;

}