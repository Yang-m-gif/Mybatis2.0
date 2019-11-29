package com.slk.authority.module.aut_role_menu.service.impl;
import com.slk.authority.module.aut_role_menu.mapper.AutRoleMenuMapper;
import com.slk.authority.module.aut_role_menu.service.AutRoleMenuSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AutRoleMenuSrviceImpl implements AutRoleMenuSrvice {

	@Autowired
	private AutRoleMenuMapper autrolemenumapper;

}