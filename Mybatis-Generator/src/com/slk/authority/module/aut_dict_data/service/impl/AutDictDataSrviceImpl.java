package com.slk.authority.module.aut_dict_data.service.impl;
import com.slk.authority.module.aut_dict_data.mapper.AutDictDataMapper;
import com.slk.authority.module.aut_dict_data.service.AutDictDataSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AutDictDataSrviceImpl implements AutDictDataSrvice {

	@Autowired
	private AutDictDataMapper autdictdatamapper;

}