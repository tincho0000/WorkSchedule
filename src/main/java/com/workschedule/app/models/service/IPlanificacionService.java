package com.workschedule.app.models.service;

import java.util.List;

import com.workschedule.app.models.entity.Planificacion;

public interface IPlanificacionService {

	public List<Planificacion> findAll();
	public Planificacion findOne(Long id);
	public void save(Planificacion planificacion);
	public void delete(Long id);
}
