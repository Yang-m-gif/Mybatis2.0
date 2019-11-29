package com.slk.gtrans.module.PMS_Cardinfo.po;

import lombok.Data;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
public class PmsCardinfo{
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer fid;

    /* 用户区域fid */
    private Integer slk_area_fid;

    /* 所属项目fid */
    private Integer slk_project_fid;

    /* 所属楼宇fid */
    private Integer pms_building_fid;

    /* 所属楼层fid */
    private Integer pms_floor_fid;

    /* 所属片区fid */
    private Integer pms_area_fid;

    /* 所属科室fid */
    private Integer pms_dpinfo_fid;

    /* 卡片名称 */
    private String name;

    /* 坐标范围 */
    private String coordinate;

    /* 二维码范围 */
    private String qrcode;

    /* 描述 */
    private String depict;

    /* 操作人FID */
    private Integer modify_userfid;

    /* 操作人姓名 */
    private String modifyname;

    /* 操作时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date modifydate;

}