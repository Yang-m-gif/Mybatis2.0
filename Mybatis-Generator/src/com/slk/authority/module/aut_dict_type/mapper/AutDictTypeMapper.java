package com.slk.authority.module.aut_dict_type.mapper;

import com.slk.authority.module.aut_dict_type.po.AutDictType;
import com.slk.authority.framework.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AutDictTypeMapper extends MyMapper<AutDictType> {

    /**
     * 添加AutDictType信息
     * create by 杨明 2019-07-23 11:00:53
     */
    public int insertAutDictTypeInfo(AutDictType type);

    /**
     * 根据主键删除AutDictType信息
     * create by 杨明 2019-07-23 11:00:53
     */
    public int deleteAutDictTypeByKey(@Param("dict_id") Integer dict_id);

    /**
     * 修改AutDictType信息
     * create by 杨明 2019-07-23 11:00:53
     */
    public int updateAutDictTypeByKey(AutDictType type);

    /**
     * 获取所有的或者条件获取AutDictType信息
     * create by 杨明 2019-07-23 11:00:53
     */
    public List<AutDictType> selectAutDictTypeByPrimary(AutDictType type);

    /**
     * 批量添加AutDictType信息
     * create by 杨明 2019-07-23 11:00:53
     */
    public int insertAutDictTypeBatch(List<AutDictType> list);

    /**
     * 批量删除AutDictType信息
     * create by 杨明 2019-07-23 11:00:53
     */
    public int deleteAutDictTypeBatch(List<AutDictType> list);

    /**
     * 批量修改AutDictType信息
     * create by 杨明 2019-07-23 11:00:53
     */
    public int updateAutDictTypeBatch(List<AutDictType> list);

    /**
     * 批量修改AutDictType信息
     * create by 杨明 2019-07-23 11:00:53
     */
    public int updateAutDictTypeBatchPrimary(List<AutDictType> list);

    /**
     * 批量list查询AutDictType信息
     * create by 杨明 2019-07-23 11:00:53
     */
    public int selectAutDictTypeBatchList(List<AutDictType> list);

    /**
     * 批量arr查询AutDictType信息
     * create by 杨明 2019-07-23 11:00:53
     */
    public int selectAutDictTypeBatchArr(List<AutDictType> list);

}