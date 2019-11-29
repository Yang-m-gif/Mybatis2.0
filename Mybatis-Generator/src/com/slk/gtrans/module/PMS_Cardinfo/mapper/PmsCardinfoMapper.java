package com.slk.gtrans.module.PMS_Cardinfo.mapper;

import com.slk.gtrans.module.PMS_Cardinfo.po.PmsCardinfo;
import com.slk.gtrans.framework.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PmsCardinfoMapper extends MyMapper<PmsCardinfo> {

    /**
     * 添加PmsCardinfo信息
     * create by 杨明 2019-07-25 12:32:31
     */
    public int insertPmsCardinfoInfo(PmsCardinfo cardinfo);

    /**
     * 根据主键删除PmsCardinfo信息
     * create by 杨明 2019-07-25 12:32:31
     */
    public int deletePmsCardinfoByKey(@Param("fid") Integer fid);

    /**
     * 修改PmsCardinfo信息
     * create by 杨明 2019-07-25 12:32:31
     */
    public int updatePmsCardinfoByKey(PmsCardinfo cardinfo);

    /**
     * 获取所有的或者条件获取PmsCardinfo信息
     * create by 杨明 2019-07-25 12:32:31
     */
    public List<PmsCardinfo> selectPmsCardinfoByPrimary(PmsCardinfo cardinfo);

    /**
     * 批量添加PmsCardinfo信息
     * create by 杨明 2019-07-25 12:32:31
     */
    public int insertPmsCardinfoBatch(List<PmsCardinfo> list);

    /**
     * 批量删除PmsCardinfo信息
     * create by 杨明 2019-07-25 12:32:31
     */
    public int deletePmsCardinfoBatch(List<PmsCardinfo> list);

    /**
     * 批量修改PmsCardinfo信息
     * create by 杨明 2019-07-25 12:32:31
     */
    public int updatePmsCardinfoBatch(List<PmsCardinfo> list);

    /**
     * 批量修改PmsCardinfo信息
     * create by 杨明 2019-07-25 12:32:31
     */
    public int updatePmsCardinfoBatchPrimary(List<PmsCardinfo> list);

    /**
     * 批量list查询PmsCardinfo信息
     * create by 杨明 2019-07-25 12:32:31
     */
    public int selectPmsCardinfoBatchList(List<PmsCardinfo> list);

    /**
     * 批量arr查询PmsCardinfo信息
     * create by 杨明 2019-07-25 12:32:31
     */
    public int selectPmsCardinfoBatchArr(List<PmsCardinfo> list);

}