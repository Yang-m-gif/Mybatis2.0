package com.slk.pms.module.PR_Facility_Type.po;

import lombok.Data;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
public class PrFacilityType{
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer fid;

    /* 所属项目/区域(与user里的区域相同) */
    private Integer slk_area_fid;

    /* 巡检类型名称 */
    private String name;

    /* 备注 */
    private String remark;

    /* 异常负责人（多选，根据角色及项目列出候选人） */
    private String manager_ids;

    /* 异常巡检人（多选，根据角色及项目列出候选人） */
    private String patrol_ids;

    /* 状态（0-启用 1-停用） */
    private Integer status;

    /* 操作人fid */
    private Integer modify_userfid;

    /* 操作人姓名 */
    private String modifyname;

    /* 操作人角色 */
    private String modifyrole;

    /* 操作时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date modifydate;

}