package com.slk.authority.module.aut_dict_type.po;

import lombok.Data;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
public class AutDictType{
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer dict_id;

    /* 字典名称 */
    private String dict_name;

    /* 字典类型 */
    private String dict_type;

    /* 状态（0-启用 1-停用） */
    private Integer status;

    /* 是否删除（0-否 1-是） */
    private Integer havdel;

    /* 操作人（创建） */
    private Integer modify_userid;

    /* 操作时间（创建） */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date modify_date;

    /* 操作人（更新） */
    private Integer update_userid;

    /* 操作时间（更新） */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date update_date;

    /* 备注 */
    private String remark;

}