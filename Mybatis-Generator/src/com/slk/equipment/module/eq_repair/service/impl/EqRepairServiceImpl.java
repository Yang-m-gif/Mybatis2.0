package com.slk.equipment.module.eq_repair.service.impl;
import com.slk.equipment.module.eq_repair.mapper.EqRepairMapper;
import com.slk.equipment.module.eq_repair.service.EqRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EqRepairServiceImpl implements EqRepairService {

	@Autowired
	private EqRepairMapper eqrepairmapper;

}