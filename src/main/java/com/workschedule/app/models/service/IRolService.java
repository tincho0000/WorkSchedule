package com.workschedule.app.models.service;

import java.util.List;

import com.workschedule.app.models.entity.Rol;

public interface IRolService {

	public List<Rol> findAll();
	public Rol findOne(Long id);
	
}
