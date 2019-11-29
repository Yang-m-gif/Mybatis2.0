package com.slk.version.module.vg_developer.service.impl;
import com.slk.version.module.vg_developer.mapper.VgDeveloperMapper;
import com.slk.version.module.vg_developer.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DeveloperServiceImpl implements DeveloperService {

	@Autowired
	private VgDeveloperMapper vgdevelopermapper;

}