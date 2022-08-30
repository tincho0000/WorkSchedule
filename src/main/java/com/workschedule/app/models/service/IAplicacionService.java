package com.workschedule.app.models.service;

import java.util.List;

import com.workschedule.app.models.entity.Aplicacion;

public interface IAplicacionService {

	public List<Aplicacion> findAll();
	public Aplicacion findOne(Long id);
	
}
