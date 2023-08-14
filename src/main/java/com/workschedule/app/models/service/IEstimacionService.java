package com.workschedule.app.models.service;

import java.util.List;

import com.workschedule.app.models.entity.Estimacion;

public interface IEstimacionService {

	public List<Estimacion> findAll();
	public Estimacion findOne(Long id);
	public void save(Estimacion estimacion);
	public void delete(Long id);
	
}
