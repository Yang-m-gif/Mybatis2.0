package com.slk.version.module.vg_version.service.impl;
import com.slk.version.module.vg_version.mapper.VgVersionMapper;
import com.slk.version.module.vg_version.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VersionServiceImpl implements VersionService {

	@Autowired
	private VgVersionMapper vgversionmapper;

}