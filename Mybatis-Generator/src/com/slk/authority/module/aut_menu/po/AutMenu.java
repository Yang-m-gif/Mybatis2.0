package com.slk.authority.module.aut_menu.po;

import lombok.Data;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
@Data
public class AutMenu{
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /* 菜单名称 */
    private String name;

    /* 菜单Url */
    private String url;

    /* 菜单描述 */
    private String depict;

    /* 上一级Fid */
    private Integer parentid;

    /* 菜单级别 */
    private Integer levels;

    /* 显示顺序 */
    private Integer orders;

    /* 区域类型ID */
    private Integer region_id;

    /* 菜单类型ID */
    private Integer menutype_id;

    /* 创建者（创建，修改） */
    private Integer modify_userid;

    /* 更新时间（创建，修改） */
    private Date modify_date;

    /* 图标地址 */
    private String imgurl;

}