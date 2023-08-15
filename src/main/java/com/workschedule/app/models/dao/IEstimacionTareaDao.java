package com.workschedule.app.models.dao;

import com.workschedule.app.models.entity.EstimacionTarea;
import org.springframework.data.repository.CrudRepository;

public interface IEstimacionTareaDao extends CrudRepository<EstimacionTarea, Long> {
}
