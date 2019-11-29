package com.slk.authority.module.aut_dict.mapper;

import com.slk.authority.module.aut_dict.po.AutDict;
import com.slk.authority.framework.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AutDictMapper extends MyMapper<AutDict> {

    /**
     * 添加AutDict信息
     * create by 杨明 2019-07-23 11:00:23
     */
    public int insertAutDictInfo(AutDict dict);

    /**
     * 根据主键删除AutDict信息
     * create by 杨明 2019-07-23 11:00:23
     */
    public int deleteAutDictByKey(@Param("dict_id") Integer dict_id);

    /**
     * 修改AutDict信息
     * create by 杨明 2019-07-23 11:00:23
     */
    public int updateAutDictByKey(AutDict dict);

    /**
     * 获取所有的或者条件获取AutDict信息
     * create by 杨明 2019-07-23 11:00:23
     */
    public List<AutDict> selectAutDictByPrimary(AutDict dict);

    /**
     * 批量添加AutDict信息
     * create by 杨明 2019-07-23 11:00:23
     */
    public int insertAutDictBatch(List<AutDict> list);

    /**
     * 批量删除AutDict信息
     * create by 杨明 2019-07-23 11:00:23
     */
    public int deleteAutDictBatch(List<AutDict> list);

    /**
     * 批量修改AutDict信息
     * create by 杨明 2019-07-23 11:00:23
     */
    public int updateAutDictBatch(List<AutDict> list);

    /**
     * 批量修改AutDict信息
     * create by 杨明 2019-07-23 11:00:23
     */
    public int updateAutDictBatchPrimary(List<AutDict> list);

    /**
     * 批量list查询AutDict信息
     * create by 杨明 2019-07-23 11:00:23
     */
    public int selectAutDictBatchList(List<AutDict> list);

    /**
     * 批量arr查询AutDict信息
     * create by 杨明 2019-07-23 11:00:23
     */
    public int selectAutDictBatchArr(List<AutDict> list);

}