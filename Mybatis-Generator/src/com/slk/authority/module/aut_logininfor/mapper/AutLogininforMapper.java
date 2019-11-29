package com.slk.authority.module.aut_logininfor.mapper;

import com.slk.authority.module.aut_logininfor.po.AutLogininfor;
import com.slk.authority.framework.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AutLogininforMapper extends MyMapper<AutLogininfor> {

    /**
     * 添加AutLogininfor信息
     * create by 杨明 2019-07-23 11:02:42
     */
    public int insertAutLogininforInfo(AutLogininfor logininfor);

    /**
     * 根据主键删除AutLogininfor信息
     * create by 杨明 2019-07-23 11:02:42
     */
    public int deleteAutLogininforByKey(@Param("info_id") Integer info_id);

    /**
     * 修改AutLogininfor信息
     * create by 杨明 2019-07-23 11:02:42
     */
    public int updateAutLogininforByKey(AutLogininfor logininfor);

    /**
     * 获取所有的或者条件获取AutLogininfor信息
     * create by 杨明 2019-07-23 11:02:42
     */
    public List<AutLogininfor> selectAutLogininforByPrimary(AutLogininfor logininfor);

    /**
     * 批量添加AutLogininfor信息
     * create by 杨明 2019-07-23 11:02:42
     */
    public int insertAutLogininforBatch(List<AutLogininfor> list);

    /**
     * 批量删除AutLogininfor信息
     * create by 杨明 2019-07-23 11:02:42
     */
    public int deleteAutLogininforBatch(List<AutLogininfor> list);

    /**
     * 批量修改AutLogininfor信息
     * create by 杨明 2019-07-23 11:02:42
     */
    public int updateAutLogininforBatch(List<AutLogininfor> list);

    /**
     * 批量修改AutLogininfor信息
     * create by 杨明 2019-07-23 11:02:42
     */
    public int updateAutLogininforBatchPrimary(List<AutLogininfor> list);

    /**
     * 批量list查询AutLogininfor信息
     * create by 杨明 2019-07-23 11:02:42
     */
    public int selectAutLogininforBatchList(List<AutLogininfor> list);

    /**
     * 批量arr查询AutLogininfor信息
     * create by 杨明 2019-07-23 11:02:42
     */
    public int selectAutLogininforBatchArr(List<AutLogininfor> list);

}