package com.workschedule.app.models.service;

import com.workschedule.app.models.entity.PlanificacionTarea;

import java.util.List;

public interface IPlanificacionTareaService {

	public void save(PlanificacionTarea planificacionTarea);

	public void delete(Long id);

	public List<PlanificacionTarea> getAllTask();
	
}
