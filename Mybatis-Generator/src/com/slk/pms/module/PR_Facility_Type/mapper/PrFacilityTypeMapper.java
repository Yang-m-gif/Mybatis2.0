package com.slk.pms.module.PR_Facility_Type.mapper;

import com.slk.pms.module.PR_Facility_Type.po.PrFacilityType;
import com.slk.pms.framework.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PrFacilityTypeMapper extends MyMapper<PrFacilityType> {

    /**
     * 添加PrFacilityType信息
     * create by 杨明 2019-08-08 09:55:46
     */
    public int insertPrFacilityTypeInfo(PrFacilityType type);

    /**
     * 根据主键删除PrFacilityType信息
     * create by 杨明 2019-08-08 09:55:46
     */
    public int deletePrFacilityTypeByKey(@Param("fid") Integer fid);

    /**
     * 修改PrFacilityType信息
     * create by 杨明 2019-08-08 09:55:46
     */
    public int updatePrFacilityTypeByKey(PrFacilityType type);

    /**
     * 获取所有的或者条件获取PrFacilityType信息
     * create by 杨明 2019-08-08 09:55:46
     */
    public List<PrFacilityType> selectPrFacilityTypeByPrimary(PrFacilityType type);

    /**
     * 批量添加PrFacilityType信息
     * create by 杨明 2019-08-08 09:55:46
     */
    public int insertPrFacilityTypeBatch(List<PrFacilityType> list);

}