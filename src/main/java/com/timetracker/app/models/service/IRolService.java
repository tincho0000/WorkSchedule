package com.timetracker.app.models.service;

import java.util.List;

import com.timetracker.app.models.entity.Rol;

public interface IRolService {

	public List<Rol> findAll();
	public Rol findOne(Long id);
	
}
