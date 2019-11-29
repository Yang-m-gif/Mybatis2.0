package com.slk.version.module.vg_processIng.service.impl;
import com.slk.version.module.vg_processIng.mapper.VgProcessingMapper;
import com.slk.version.module.vg_processIng.service.ProcessIngService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProcessIngServiceImpl implements ProcessIngService {

	@Autowired
	private VgProcessingMapper vgprocessingmapper;

}