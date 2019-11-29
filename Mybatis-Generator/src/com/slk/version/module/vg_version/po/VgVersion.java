package com.slk.version.module.vg_version.po;

import lombok.Data;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
@Data
public class VgVersion{
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /* 项目id */
    private Integer project_id;

    /* 标题 */
    private String title;

    /* 版本号 */
    private String versioncode;

    /* 版本类型 */
    private Integer projecttype_id;

    /* 描述 */
    private String bewrite;

    /* 附件路径 */
    private String fileurl;

    /* 是否上架(0:上架，1：下架) */
    private Integer isuse;

    /* 创建时间 */
    private Date createtime;

    /* 创建人 */
    private Integer createuser_id;

}