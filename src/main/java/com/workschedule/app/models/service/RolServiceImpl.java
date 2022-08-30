package com.workschedule.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workschedule.app.models.dao.IRolDao;
import com.workschedule.app.models.entity.Rol;

@Service
public class RolServiceImpl implements IRolService {
	
	@Autowired
	IRolDao rolDao;

	@Override
	public List<Rol> findAll() {
		return (List<Rol>) rolDao.findAll();
	}

	@Override
	public Rol findOne(Long id) {
		return rolDao.findById(id).orElseGet(null);
	}

}
