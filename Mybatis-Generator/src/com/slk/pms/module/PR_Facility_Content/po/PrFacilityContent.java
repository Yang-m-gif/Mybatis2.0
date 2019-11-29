package com.slk.pms.module.PR_Facility_Content.po;

import lombok.Data;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
public class PrFacilityContent{
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer fid;

    /* 巡检类型表fid */
    private Integer facility_type_fid;

    /* 巡检内容名称 */
    private String name;

    /* 所属项目/区域（与user里的区域相同） */
    private Integer slk_area_fid;

    /* 备注 */
    private String remark;

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