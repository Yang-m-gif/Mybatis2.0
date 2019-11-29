package com.slk.equipment.module.eq_repair.po;

import lombok.Data;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
@Data
public class EqRepair{
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer fid;

    /* 保修单号 */
    private String repair_code;

    /* 报修时间(自动生成规则：wxd年月日时分秒，共17位)
 */
    private Date repair_data;

    /* 报修设备fid */
    private Integer equipment_id;

    /* 报修设备位置 */
    private String position;

    /* 报修人姓名 */
    private String applicant;

    /* 联系电话 */
    private Integer phone;

    /* 紧急程度（查数据字段） */
    private Integer urgentstate;

    /* 紧急时间 （一天内、两天内和三天内） */
    private Date urgenttime;

    /* 0-文字输入 1-语音输入
 */
    private String contentstate;

    /* 报修内容1 */
    private String content_one;

    /* 报修内容2 */
    private String content_two;

    /* 报修图片 */
    private String picture;

    /* 拒绝原因 */
    private String refuse;

    /* 报修状态 1-待接单 2-已接单 3-已拒绝 4-待确定(已维修) 4-已完成(必须评价才可以确认完成) 6-已取消  */
    private Integer state;

    /* 等级评分 */
    private Integer grades;

    /* 评价内容 */
    private String evaluation;

    /* 接单人姓名 */
    private String ordername;

    /* 接单时间 */
    private Date order_date;

    /* 维修状态(换件 维修 送修 无法修复) 查看数据字典 */
    private Integer repairtype;

    /* 费用 */
    private Double cost;

    /* 其他费用 */
    private Double othercost;

    /* 维修说明 */
    private String explain;

    /* 维修故障说明 */
    private String problem;

    /* 维修图片 */
    private String printimg;

    /* 完成时间 */
    private Date finish_date;

    /* 操作人 */
    private Integer modify_userid;

    /* 创建时间 */
    private Date modify_date;

    /* 修改时间 */
    private Date update_date;

}