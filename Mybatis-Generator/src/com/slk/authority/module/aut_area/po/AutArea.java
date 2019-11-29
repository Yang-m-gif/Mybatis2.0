package com.slk.authority.module.aut_area.po;

import lombok.Data;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
public class AutArea{
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer fid;

    /* 个人(地区）区域名称 */
    private String name;

    /* 描述 */
    private String depict;

    /* 显示顺序 */
    private Integer orders;

    /* 状态（0启用，1停用） */
    private Integer status;

    /*  */
    private Integer modify_userfid;

    /*  */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date modifydate;

}