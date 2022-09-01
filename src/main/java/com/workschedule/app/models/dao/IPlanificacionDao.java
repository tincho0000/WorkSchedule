package com.workschedule.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.workschedule.app.models.entity.Planificacion;

public interface IPlanificacionDao extends CrudRepository<Planificacion, Long>{

}
