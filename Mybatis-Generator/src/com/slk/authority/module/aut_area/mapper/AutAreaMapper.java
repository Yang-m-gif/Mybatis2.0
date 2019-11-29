package com.slk.authority.module.aut_area.mapper;

import com.slk.authority.module.aut_area.po.AutArea;
import com.slk.authority.framework.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AutAreaMapper extends MyMapper<AutArea> {

    /**
     * 添加AutArea信息
     * create by 杨明 2019-07-23 10:03:12
     */
    public int insertAutAreaInfo(AutArea area);

    /**
     * 根据主键删除AutArea信息
     * create by 杨明 2019-07-23 10:03:12
     */
    public int deleteAutAreaByKey(@Param("fid") Integer fid);

    /**
     * 修改AutArea信息
     * create by 杨明 2019-07-23 10:03:12
     */
    public int updateAutAreaByKey(AutArea area);

    /**
     * 获取所有的或者条件获取AutArea信息
     * create by 杨明 2019-07-23 10:03:12
     */
    public List<AutArea> selectAutAreaByPrimary(AutArea area);

    /**
     * 批量添加AutArea信息
     * create by 杨明 2019-07-23 10:03:12
     */
    public int insertAutAreaBatch(List<AutArea> list);

    /**
     * 批量删除AutArea信息
     * create by 杨明 2019-07-23 10:03:12
     */
    public int deleteAutAreaBatch(List<AutArea> list);

    /**
     * 批量修改AutArea信息
     * create by 杨明 2019-07-23 10:03:12
     */
    public int updateAutAreaBatch(List<AutArea> list);

    /**
     * 批量修改AutArea信息
     * create by 杨明 2019-07-23 10:03:12
     */
    public int updateAutAreaBatchPrimary(List<AutArea> list);

    /**
     * 批量list查询AutArea信息
     * create by 杨明 2019-07-23 10:03:12
     */
    public int selectAutAreaBatchList(List<AutArea> list);

    /**
     * 批量arr查询AutArea信息
     * create by 杨明 2019-07-23 10:03:12
     */
    public int selectAutAreaBatchArr(List<AutArea> list);

}