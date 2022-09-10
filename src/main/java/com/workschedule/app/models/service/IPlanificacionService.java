package com.workschedule.app.models.service;

import java.time.LocalDate;
import java.util.List;

import com.workschedule.app.models.entity.Planificacion;

public interface IPlanificacionService {

	public List<Planificacion> findAll();
	public List<Planificacion> findByUsuarioIdAndFechaBetween(Long usuario, LocalDate desde, LocalDate hasta);
	public Planificacion findOne(Long id);
	public void save(Planificacion planificacion);
	public void delete(Long id);
//	public DetallePlanificacion obtenerPlanificacion(String usuario, LocalDate fecha , String aplicacion, String requerimiento);
}
