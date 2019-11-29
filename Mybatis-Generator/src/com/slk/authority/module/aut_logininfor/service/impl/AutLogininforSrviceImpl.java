package com.slk.authority.module.aut_logininfor.service.impl;
import com.slk.authority.module.aut_logininfor.mapper.AutLogininforMapper;
import com.slk.authority.module.aut_logininfor.service.AutLogininforSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AutLogininforSrviceImpl implements AutLogininforSrvice {

	@Autowired
	private AutLogininforMapper autlogininformapper;

}