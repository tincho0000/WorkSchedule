package com.workschedule.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.workschedule.app.models.entity.EstimacionRequerimientoFase;
import com.workschedule.app.models.entity.Requerimiento;
import com.workschedule.app.models.entity.RequerimientoSimple;

public interface IRequerimientoService {

	public List<Requerimiento> findAll();
	
	public Page<Requerimiento> findAll(Pageable pageable);
	
	public Page<Requerimiento> findByRequerimientoAndAplicacionAndEstadoLikeIgnoreCase(Pageable pageable, String requerimiento, Long aplicacion, String estado);
	
	public Page<Requerimiento> findByRequerimientoLikeIgnoreCaseAndEstadoLikeIgnoreCase(Pageable pageable, String requerimiento, String estado);
	
	public Page<Requerimiento> findByFiltros(int page, String requerimiento, String aplicacion, String estadoFiltro);

	public Requerimiento findOne(Long id);

	public void save(Requerimiento requerimiento);

	public void delete(Long id);
	
	public List<EstimacionRequerimientoFase> findByRequerimiento(String requerimiento);
	
	public List<RequerimientoSimple> findByRequerimientoContaining(String requerimiento);
	public List<RequerimientoSimple> findByRequerimientos();
	public Requerimiento findByRequerimiento(Long id);
	public RequerimientoSimple findByRequerimientoSimple(Long id);
	
}
