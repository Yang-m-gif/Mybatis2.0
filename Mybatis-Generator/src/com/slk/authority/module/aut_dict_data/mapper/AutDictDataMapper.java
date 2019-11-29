package com.slk.authority.module.aut_dict_data.mapper;

import com.slk.authority.module.aut_dict_data.po.AutDictData;
import com.slk.authority.framework.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AutDictDataMapper extends MyMapper<AutDictData> {

    /**
     * 添加AutDictData信息
     * create by 杨明 2019-07-23 11:01:36
     */
    public int insertAutDictDataInfo(AutDictData data);

    /**
     * 根据主键删除AutDictData信息
     * create by 杨明 2019-07-23 11:01:36
     */
    public int deleteAutDictDataByKey(@Param("dict_id") Integer dict_id);

    /**
     * 修改AutDictData信息
     * create by 杨明 2019-07-23 11:01:36
     */
    public int updateAutDictDataByKey(AutDictData data);

    /**
     * 获取所有的或者条件获取AutDictData信息
     * create by 杨明 2019-07-23 11:01:36
     */
    public List<AutDictData> selectAutDictDataByPrimary(AutDictData data);

    /**
     * 批量添加AutDictData信息
     * create by 杨明 2019-07-23 11:01:36
     */
    public int insertAutDictDataBatch(List<AutDictData> list);

    /**
     * 批量删除AutDictData信息
     * create by 杨明 2019-07-23 11:01:36
     */
    public int deleteAutDictDataBatch(List<AutDictData> list);

    /**
     * 批量修改AutDictData信息
     * create by 杨明 2019-07-23 11:01:36
     */
    public int updateAutDictDataBatch(List<AutDictData> list);

    /**
     * 批量修改AutDictData信息
     * create by 杨明 2019-07-23 11:01:36
     */
    public int updateAutDictDataBatchPrimary(List<AutDictData> list);

    /**
     * 批量list查询AutDictData信息
     * create by 杨明 2019-07-23 11:01:36
     */
    public int selectAutDictDataBatchList(List<AutDictData> list);

    /**
     * 批量arr查询AutDictData信息
     * create by 杨明 2019-07-23 11:01:36
     */
    public int selectAutDictDataBatchArr(List<AutDictData> list);

}