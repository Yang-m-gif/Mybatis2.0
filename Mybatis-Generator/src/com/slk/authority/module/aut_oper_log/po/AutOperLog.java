package com.slk.authority.module.aut_oper_log.po;

import lombok.Data;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
public class AutOperLog{
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer oper_id;

    /* 模块标题 */
    private String title;

    /* 功能请求 */
    private String action;

    /* 方法名称 */
    private String method;

    /* 来源渠道（manage后台用户 mobile手机端用户 other其它） */
    private String channel;

    /* 操作人员 */
    private String oper_name;

    /* 部门名称 */
    private String dept_name;

    /* 请求URL */
    private String oper_url;

    /* 主机地址 */
    private String oper_ip;

    /* 操作地点 */
    private String oper_location;

    /* 请求参数 */
    private String oper_param;

    /* 操作状态（0正常 1异常） */
    private String status;

    /* 错误消息 */
    private String error_msg;

    /* 操作时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date oper_time;

}