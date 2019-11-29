package com.slk.authority.module.aut_user_role.service.impl;
import com.slk.authority.module.aut_user_role.mapper.AutUserRoleMapper;
import com.slk.authority.module.aut_user_role.service.AutUserRoleSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AutUserRoleSrviceImpl implements AutUserRoleSrvice {

	@Autowired
	private AutUserRoleMapper autuserrolemapper;

}