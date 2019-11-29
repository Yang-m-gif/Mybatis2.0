package com.slk.version.module.vg_developer.po;

import lombok.Data;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
@Data
public class VgDeveloper{
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /* 开发人员名称 */
    private String name;

    /* 开发人员状态，0-测试，1-开发 */
    private Integer state;

    /* 创建人员ID */
    private Integer createuser_id;

    /* 创建时间 */
    private Date createtime;

}