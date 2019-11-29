package com.slk.version.module.vg_process.po;

import lombok.Data;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
@Data
public class VgProcess{
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /* 标题 */
    private String title;

    /* 重现步骤，阐述bug问题 */
    private String describes;

    /* 紧急程度，0-普通，1-紧急，2-非常紧急 */
    private Integer urgentstate;

    /* 最新办理状态 */
    private Integer handlestate;

    /* 项目ID */
    private Integer prject_id;

    /* 项目名称 */
    private String prjectname;

    /* 版本ID */
    private Integer version_id;

    /* 版本号 */
    private String versionname;

    /* bug类型ID */
    private Integer bugtype_id;

    /* bug名称 */
    private String bugtname;

    /* 操作工具ID */
    private Integer tools_id;

    /* 操作工具名称 */
    private String toolsname;

    /* 开发人员ID */
    private Integer developer_id;

    /* 开发人员名称 */
    private String developername;

    /* 附件地址 */
    private String fileurl;

    /* 创建人ID */
    private Integer createuser_id;

    /* 创建人姓名 */
    private String createusername;

    /* 创建日期 */
    private Date modifdate;

    /* 最后提交日期，实时更新 */
    private Date lastdate;

}