package com.slk.pms.module.PR_Facility.service.impl;
import com.slk.pms.module.PR_Facility.mapper.PrFacilityMapper;
import com.slk.pms.module.PR_Facility.service.PrFacilitySrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PrFacilitySrviceImpl implements PrFacilitySrvice {

	@Autowired
	private PrFacilityMapper prfacilitymapper;


}