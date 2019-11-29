package com.slk.authority.module.aut_user.service.impl;
import com.slk.authority.module.aut_user.mapper.AutUserMapper;
import com.slk.authority.module.aut_user.service.AutUserSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AutUserSrviceImpl implements AutUserSrvice {

	@Autowired
	private AutUserMapper autusermapper;

}