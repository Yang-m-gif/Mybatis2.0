package com.slk.authority.module.aut_oper_log.service.impl;
import com.slk.authority.module.aut_oper_log.mapper.AutOperLogMapper;
import com.slk.authority.module.aut_oper_log.service.AutOperLogSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AutOperLogSrviceImpl implements AutOperLogSrvice {

	@Autowired
	private AutOperLogMapper autoperlogmapper;

}