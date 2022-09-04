package com.workschedule.app.models.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.workschedule.app.models.entity.Planificacion;

public interface IPlanificacionDao extends CrudRepository<Planificacion, Long>{

	
	public List<Planificacion> findByUsuarioIdAndFechaBetween(Long usuario, LocalDate desde, LocalDate hasta );
	
}
