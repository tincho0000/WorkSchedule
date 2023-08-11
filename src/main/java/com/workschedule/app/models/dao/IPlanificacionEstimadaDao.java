package com.workschedule.app.models.dao;

import com.workschedule.app.models.entity.PlanificacionEstimada;
import org.springframework.data.repository.CrudRepository;

public interface IPlanificacionEstimadaDao extends CrudRepository<PlanificacionEstimada, Long> {
}
