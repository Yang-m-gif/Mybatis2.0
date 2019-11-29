package com.slk.version.module.vg_process.service.impl;
import com.slk.version.module.vg_process.mapper.VgProcessMapper;
import com.slk.version.module.vg_process.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProcessServiceImpl implements ProcessService {

	@Autowired
	private VgProcessMapper vgprocessmapper;

}