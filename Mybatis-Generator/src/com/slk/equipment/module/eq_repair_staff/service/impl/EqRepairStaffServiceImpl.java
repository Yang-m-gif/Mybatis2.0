package com.slk.equipment.module.eq_repair_staff.service.impl;
import com.slk.equipment.module.eq_repair_staff.mapper.EqRepairStaffMapper;
import com.slk.equipment.module.eq_repair_staff.service.EqRepairStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EqRepairStaffServiceImpl implements EqRepairStaffService {

	@Autowired
	private EqRepairStaffMapper eqrepairstaffmapper;

}