package com.slk.pms.module.PR_Facility_Content.mapper;

import com.slk.pms.module.PR_Facility_Content.po.PrFacilityContent;
import com.slk.pms.framework.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PrFacilityContentMapper extends MyMapper<PrFacilityContent> {

    /**
     * 添加PrFacilityContent信息
     * create by 杨明 2019-08-09 15:57:06
     */
    public int insertPrFacilityContentInfo(PrFacilityContent content);

    /**
     * 根据主键删除PrFacilityContent信息
     * create by 杨明 2019-08-09 15:57:06
     */
    public int deletePrFacilityContentByKey(@Param("fid") Integer fid);

    /**
     * 修改PrFacilityContent信息
     * create by 杨明 2019-08-09 15:57:06
     */
    public int updatePrFacilityContentByKey(PrFacilityContent content);

    /**
     * 获取所有的或者条件获取PrFacilityContent信息
     * create by 杨明 2019-08-09 15:57:06
     */
    public List<PrFacilityContent> selectPrFacilityContentByPrimary(PrFacilityContent content);

    /**
     * 批量添加PrFacilityContent信息
     * create by 杨明 2019-08-09 15:57:06
     */
    public int insertPrFacilityContentBatch(List<PrFacilityContent> list);

    /**
     * 批量删除PrFacilityContent信息
     * create by 杨明 2019-08-09 15:57:06
     */
    public int deletePrFacilityContentBatch(List<PrFacilityContent> list);

    /**
     * 批量修改PrFacilityContent信息
     * create by 杨明 2019-08-09 15:57:06
     */
    public int updatePrFacilityContentBatch(List<PrFacilityContent> list);

    /**
     * 批量修改PrFacilityContent信息
     * create by 杨明 2019-08-09 15:57:06
     */
    public int updatePrFacilityContentBatchPrimary(List<PrFacilityContent> list);

}