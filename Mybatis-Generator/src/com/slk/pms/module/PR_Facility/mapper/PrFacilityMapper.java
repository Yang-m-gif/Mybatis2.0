package com.slk.pms.module.PR_Facility.mapper;

import com.slk.pms.module.PR_Facility.po.PrFacility;
import com.slk.pms.framework.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PrFacilityMapper extends MyMapper<PrFacility> {

    /**
     * 添加PrFacility信息
     * create by 杨明 2019-08-08 16:13:26
     */
    public int insertPrFacilityInfo(PrFacility facility);

    /**
     * 根据主键删除PrFacility信息
     * create by 杨明 2019-08-08 16:13:26
     */
    public int deletePrFacilityByKey(@Param("fid") Integer fid);

    /**
     * 修改PrFacility信息
     * create by 杨明 2019-08-08 16:13:26
     */
    public int updatePrFacilityByKey(PrFacility facility);

    /**
     * 获取所有的或者条件获取PrFacility信息
     * create by 杨明 2019-08-08 16:13:26
     */
    public List<PrFacility> selectPrFacilityByPrimary(PrFacility facility);

    /**
     * 批量添加PrFacility信息
     * create by 杨明 2019-08-08 16:13:26
     */
    public int insertPrFacilityBatch(List<PrFacility> list);

}