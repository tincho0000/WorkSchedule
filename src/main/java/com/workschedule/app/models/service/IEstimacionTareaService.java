package com.workschedule.app.models.service;

import com.workschedule.app.models.entity.EstimacionTarea;

import java.util.List;

public interface IEstimacionTareaService {

	public void save(EstimacionTarea estimacionTarea);

	public void delete(Long id);

	public List<EstimacionTarea> getAllTask();
	
}
