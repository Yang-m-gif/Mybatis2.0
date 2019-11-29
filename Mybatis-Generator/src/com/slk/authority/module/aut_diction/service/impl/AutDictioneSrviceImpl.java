package com.slk.authority.module.aut_diction.service.impl;
import com.slk.authority.module.aut_diction.mapper.AutDictionMapper;
import com.slk.authority.module.aut_diction.service.AutDictioneSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AutDictioneSrviceImpl implements AutDictioneSrvice {

	@Autowired
	private AutDictionMapper autdictionmapper;

}