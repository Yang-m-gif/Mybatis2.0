package com.slk.version.module.vg_interface.service.impl;
import com.slk.version.module.vg_interface.mapper.VgInterfaceMapper;
import com.slk.version.module.vg_interface.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InterfaceServiceImpl implements InterfaceService {

	@Autowired
	private VgInterfaceMapper vginterfacemapper;

}