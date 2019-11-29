package com.slk.authority.module.aut_dict_type.service.impl;
import com.slk.authority.module.aut_dict_type.mapper.AutDictTypeMapper;
import com.slk.authority.module.aut_dict_type.service.AutDictTypeSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AutDictTypeSrviceImpl implements AutDictTypeSrvice {

	@Autowired
	private AutDictTypeMapper autdicttypemapper;

}