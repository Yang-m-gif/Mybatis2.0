package com.slk.version.module.vg_parameter.po;

import lombok.Data;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
@Data
public class VgParameter{
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /* 接口id */
    private Integer interface_id;

    /* 项目id */
    private Integer project_id;

    /* 参数类型id */
    private Integer parameter_type_id;

    /* 参数名称 */
    private String name;

    /* 参数类型 */
    private String type;

    /* 参数描述 */
    private String description;

    /* 创建者（创建，修改） */
    private Integer modify_userid;

    /* 更新时间（创建，修改） */
    private Date modify_date;

    /* 状态 0-使用 1-删除 */
    private Integer state;

    /* 传递方式 */
    private String transfer_model;

}