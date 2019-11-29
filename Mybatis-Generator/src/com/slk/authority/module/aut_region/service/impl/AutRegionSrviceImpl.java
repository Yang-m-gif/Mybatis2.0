package com.slk.authority.module.aut_region.service.impl;
import com.slk.authority.module.aut_region.mapper.AutRegionMapper;
import com.slk.authority.module.aut_region.service.AutRegionSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AutRegionSrviceImpl implements AutRegionSrvice {

	@Autowired
	private AutRegionMapper autregionmapper;

}