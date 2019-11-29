package com.slk.gtrans.module.PMS_Cardinfo.service.impl;
import com.slk.gtrans.module.PMS_Cardinfo.mapper.PmsCardinfoMapper;
import com.slk.gtrans.module.PMS_Cardinfo.service.PmsCardinfoSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PmsCardinfoSrviceImpl implements PmsCardinfoSrvice {

	@Autowired
	private PmsCardinfoMapper pmscardinfomapper;

}