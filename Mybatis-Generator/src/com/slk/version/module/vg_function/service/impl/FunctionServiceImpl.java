package com.slk.version.module.vg_function.service.impl;
import com.slk.version.module.vg_function.mapper.VgFunctionMapper;
import com.slk.version.module.vg_function.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FunctionServiceImpl implements FunctionService {

	@Autowired
	private VgFunctionMapper vgfunctionmapper;

}