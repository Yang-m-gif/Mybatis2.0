package com.slk.authority.module.aut_role_menu.po;

import lombok.Data;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
@Data
public class AutRoleMenu{
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /* 区域id */
    private Integer region_id;

    /* 区域名称 */
    private String regionname;

    /* 权限使用类型的值,若是Role则是Role_FID若是User则是User_FID */
    private Integer role_id;

    /* 角色名称 */
    private String rolename;

    /* 权限类型值 Menu的Fid或Button的Fid */
    private Integer menu_id;

    /* 权限值名称（菜单） */
    private String menuname;

    /* 权限值（菜单）url */
    private String menu_url;

    /* 创建者（创建，修改） */
    private Integer modify_userid;

    /* 更新时间（创建，修改） */
    private Date modify_date;

}