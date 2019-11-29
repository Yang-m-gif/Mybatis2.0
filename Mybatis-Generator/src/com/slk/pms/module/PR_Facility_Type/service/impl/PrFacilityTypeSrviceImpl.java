package com.slk.pms.module.PR_Facility_Type.service.impl;
import com.slk.pms.module.PR_Facility_Type.mapper.PrFacilityTypeMapper;
import com.slk.pms.module.PR_Facility_Type.service.PrFacilityTypeSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PrFacilityTypeSrviceImpl implements PrFacilityTypeSrvice {

	@Autowired
	private PrFacilityTypeMapper prfacilitytypemapper;


}