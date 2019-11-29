package com.slk.authority.module.aut_dict_data.po;

import lombok.Data;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
public class AutDictData{
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer dict_id;

    /* 字典排序 */
    private Integer dict_sort;

    /* 字典标签 */
    private String dict_label;

    /* 字典键值 */
    private String dict_value;

    /* 字典类型（字典类型表id） */
    private Integer dict_type_id;

    /* 样式属性 */
    private String css_class;

    /* 是否默认（Y是 N否） */
    private String is_default;

    /* 状态（0正常 1停用） */
    private String status;

    /* 创建者 */
    private String modify_userid;

    /* 创建时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date modify_date;

    /* 更新者 */
    private String update_userid;

    /* 更新时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date update_date;

    /* 备注 */
    private String remark;

}