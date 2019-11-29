package com.slk.pms.module.PR_Facility_Content.service.impl;
import com.slk.pms.module.PR_Facility_Content.mapper.PrFacilityContentMapper;
import com.slk.pms.module.PR_Facility_Content.service.PrFacilityContentSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PrFacilityContentSrviceImpl implements PrFacilityContentSrvice {

	@Autowired
	private PrFacilityContentMapper prfacilitycontentmapper;


}