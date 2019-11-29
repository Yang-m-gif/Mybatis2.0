package com.slk.version.module.vg_processIng.po;

import lombok.Data;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
@Data
public class VgProcessing{
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /* 测试流程ID */
    private Integer process_id;

    /* 工作状态(操作动作),0-保存（未提交），1-已提交，2-处理完毕，3-开发退回，4-测试退回，5-完成 */
    private Integer workstate;

    /* 批准内容 */
    private String depict;

    /* 当前操作人ID */
    private Integer current_user_id;

    /* 当前操作人名称 */
    private String currentusername;

    /* 下一个操作人ID */
    private Integer next_user_id;

    /* 下一个操作人名称 */
    private String nestusername;

    /* 更新时间 */
    private Date modifydate;

}