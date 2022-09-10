package com.workschedule.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.workschedule.app.models.entity.Requerimiento;
import com.workschedule.app.models.entity.RequerimientoSimple;

public interface IRequerimientoService {

	public List<Requerimiento> findAll();
	
	public Page<Requerimiento> findAll(Pageable pageable);
	
	public Page<Requerimiento> findByRequerimientoAndAplicacion(Pageable pageable, String requerimiento, Long aplicacion);
	
	public Page<Requerimiento> findByRequerimientoLikeIgnoreCase(Pageable pageable, String requerimiento);
	
	public Page<Requerimiento> findByFiltros(int page, String requerimiento, Long aplicacion);

	public Requerimiento findOne(Long id);

	public void save(Requerimiento requerimiento);

	public void delete(Long id);
	
	public Requerimiento findByRequerimiento(String requerimiento);
	
	public List<RequerimientoSimple> findByRequerimientoContaining(String requerimiento);
	public List<RequerimientoSimple> findByRequerimientos();
	
}
