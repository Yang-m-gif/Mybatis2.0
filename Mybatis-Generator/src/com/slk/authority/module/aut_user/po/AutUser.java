package com.slk.authority.module.aut_user.po;

import lombok.Data;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
@Data
public class AutUser{
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /* 用户姓名 */
    private String name;

    /* 登录名 */
    private String username;

    /* 密码 */
    private String password;

    /* 性别--0男  1女 */
    private Integer sex;

    /* 电话 */
    private String phone;

    /* 区域类型Id */
    private Integer region_id;

    /* 状态（1:停用,0启用） */
    private Integer status;

    /* 设备码 */
    private String token;

    /* 创建者（创建，修改） */
    private Integer modify_userid;

    /* 更新时间（创建，修改） */
    private Date modify_date;

}