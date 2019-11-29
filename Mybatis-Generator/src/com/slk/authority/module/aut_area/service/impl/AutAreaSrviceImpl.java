package com.slk.authority.module.aut_area.service.impl;
import com.slk.authority.module.aut_area.mapper.AutAreaMapper;
import com.slk.authority.module.aut_area.service.AutAreaSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AutAreaSrviceImpl implements AutAreaSrvice {

	@Autowired
	private AutAreaMapper autareamapper;

}