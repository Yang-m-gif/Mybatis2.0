package com.slk.authority.module.aut_menu.service.impl;
import com.slk.authority.module.aut_menu.mapper.AutMenuMapper;
import com.slk.authority.module.aut_menu.service.AutMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AutMenuServiceImpl implements AutMenuService {

	@Autowired
	private AutMenuMapper autmenumapper;

}