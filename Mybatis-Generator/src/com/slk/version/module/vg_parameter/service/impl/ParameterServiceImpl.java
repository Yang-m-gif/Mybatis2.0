package com.slk.version.module.vg_parameter.service.impl;
import com.slk.version.module.vg_parameter.mapper.VgParameterMapper;
import com.slk.version.module.vg_parameter.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ParameterServiceImpl implements ParameterService {

	@Autowired
	private VgParameterMapper vgparametermapper;

}