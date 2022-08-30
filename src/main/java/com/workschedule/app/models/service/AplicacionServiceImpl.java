package com.workschedule.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workschedule.app.models.dao.IAplicacionDao;
import com.workschedule.app.models.entity.Aplicacion;

@Service
public class AplicacionServiceImpl implements IAplicacionService {
	
	@Autowired
	IAplicacionDao aplicacionDao;

	@Override
	public List<Aplicacion> findAll() {
		return (List<Aplicacion>) aplicacionDao.findAll();
	}

	@Override
	public Aplicacion findOne(Long id) {
		return aplicacionDao.findById(id).orElseGet(null);
	}

}
