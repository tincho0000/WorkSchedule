package com.workschedule.app.models.dao;

import com.workschedule.app.models.entity.PlanificacionTarea;
import org.springframework.data.repository.CrudRepository;

public interface IPlanificacionTareaDao extends CrudRepository<PlanificacionTarea, Long> {
}
