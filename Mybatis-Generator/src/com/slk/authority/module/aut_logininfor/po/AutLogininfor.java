package com.slk.authority.module.aut_logininfor.po;

import lombok.Data;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
public class AutLogininfor{
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer info_id;

    /* 登录账号 */
    private String login_name;

    /* 登录IP地址 */
    private String ipaddr;

    /* 登录地点 */
    private String login_location;

    /* 浏览器类型 */
    private String browser;

    /* 操作系统 */
    private String os;

    /* 登录状态（0成功 1失败） */
    private String status;

    /* 提示消息 */
    private String msg;

    /* 访问时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date login_time;

}