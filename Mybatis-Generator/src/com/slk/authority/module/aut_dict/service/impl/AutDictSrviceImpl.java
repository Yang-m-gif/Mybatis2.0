package com.slk.authority.module.aut_dict.service.impl;
import com.slk.authority.module.aut_dict.mapper.AutDictMapper;
import com.slk.authority.module.aut_dict.service.AutDictSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AutDictSrviceImpl implements AutDictSrvice {

	@Autowired
	private AutDictMapper autdictmapper;

}