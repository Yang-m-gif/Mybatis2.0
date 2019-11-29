package com.slk.authority.module.aut_oper_log.mapper;

import com.slk.authority.module.aut_oper_log.po.AutOperLog;
import com.slk.authority.framework.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AutOperLogMapper extends MyMapper<AutOperLog> {

    /**
     * 添加AutOperLog信息
     * create by 杨明 2019-07-24 11:17:26
     */
    public int insertAutOperLogInfo(AutOperLog log);

    /**
     * 根据主键删除AutOperLog信息
     * create by 杨明 2019-07-24 11:17:26
     */
    public int deleteAutOperLogByKey(@Param("oper_id") Integer oper_id);

    /**
     * 修改AutOperLog信息
     * create by 杨明 2019-07-24 11:17:26
     */
    public int updateAutOperLogByKey(AutOperLog log);

    /**
     * 获取所有的或者条件获取AutOperLog信息
     * create by 杨明 2019-07-24 11:17:26
     */
    public List<AutOperLog> selectAutOperLogByPrimary(AutOperLog log);

    /**
     * 批量添加AutOperLog信息
     * create by 杨明 2019-07-24 11:17:26
     */
    public int insertAutOperLogBatch(List<AutOperLog> list);

    /**
     * 批量删除AutOperLog信息
     * create by 杨明 2019-07-24 11:17:26
     */
    public int deleteAutOperLogBatch(List<AutOperLog> list);

    /**
     * 批量修改AutOperLog信息
     * create by 杨明 2019-07-24 11:17:26
     */
    public int updateAutOperLogBatch(List<AutOperLog> list);

    /**
     * 批量修改AutOperLog信息
     * create by 杨明 2019-07-24 11:17:26
     */
    public int updateAutOperLogBatchPrimary(List<AutOperLog> list);

    /**
     * 批量list查询AutOperLog信息
     * create by 杨明 2019-07-24 11:17:26
     */
    public int selectAutOperLogBatchList(List<AutOperLog> list);

    /**
     * 批量arr查询AutOperLog信息
     * create by 杨明 2019-07-24 11:17:26
     */
    public int selectAutOperLogBatchArr(List<AutOperLog> list);

}