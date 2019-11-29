package com.slk.version.module.vg_function.po;

import lombok.Data;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
@Data
public class VgFunction{
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /* 开发人员id */
    private Integer developer_id;

    /* 功能描述 */
    private String bewrite;

    /* 版本id */
    private Integer version_id;

    /* 文件 路径 */
    private String fileurls;

    /* 创建时间 */
    private Date createtime;

    /* 创建人id */
    private Integer createuser_id;

}