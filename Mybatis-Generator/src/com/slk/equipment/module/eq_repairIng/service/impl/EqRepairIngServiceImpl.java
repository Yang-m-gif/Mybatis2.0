package com.slk.equipment.module.eq_repairIng.service.impl;
import com.slk.equipment.module.eq_repairIng.mapper.EqRepairingMapper;
import com.slk.equipment.module.eq_repairIng.service.EqRepairIngService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EqRepairIngServiceImpl implements EqRepairIngService {

	@Autowired
	private EqRepairingMapper eqrepairingmapper;

}