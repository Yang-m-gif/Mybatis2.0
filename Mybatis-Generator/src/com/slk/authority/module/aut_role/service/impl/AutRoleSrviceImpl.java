package com.slk.authority.module.aut_role.service.impl;
import com.slk.authority.module.aut_role.mapper.AutRoleMapper;
import com.slk.authority.module.aut_role.service.AutRoleSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AutRoleSrviceImpl implements AutRoleSrvice {

	@Autowired
	private AutRoleMapper autrolemapper;

}