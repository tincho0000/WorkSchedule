package com.workschedule.app.models.service;

import com.workschedule.app.models.entity.PlanificacionEstimada;
import com.workschedule.app.models.entity.Requerimiento;
import com.workschedule.app.models.entity.RequerimientoSimple;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPlanificacionEstimadaService {
	public void save(PlanificacionEstimada planificacionEstimada);

	public void delete(Long id);
	
}
