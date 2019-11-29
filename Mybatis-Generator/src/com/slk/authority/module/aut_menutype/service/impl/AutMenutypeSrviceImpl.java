package com.slk.authority.module.aut_menutype.service.impl;
import com.slk.authority.module.aut_menutype.mapper.AutMenutypeMapper;
import com.slk.authority.module.aut_menutype.service.AutMenutypeSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AutMenutypeSrviceImpl implements AutMenutypeSrvice {

	@Autowired
	private AutMenutypeMapper autmenutypemapper;

}