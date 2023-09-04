package com.workschedule.app.models.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.workschedule.app.models.entity.Requerimiento;

public interface IRequerimientoDao extends PagingAndSortingRepository<Requerimiento, Long> {
	
//	@Query("select r from Requerimiento r fetch r.aplicacion a  where r.requerimiento like %?1%  ")
	@Query(value="select * from requerimiento where requerimiento like %?1% and aplicacion_id = ?2 and estado like %?3%", nativeQuery=true)
	public Page<Requerimiento> findByRequerimientoAndAplicacionAndEstadoLikeIgnoreCase(Pageable pageable, String requerimiento, Long aplicacion, String estadoFiltro);

	@Query("select r from Requerimiento r where r.requerimiento like %?1% and r.estado like %?2%")
	public Page<Requerimiento> findByRequerimientoLikeIgnoreCaseAndEstadoLikeIgnoreCase(Pageable pageable, String requerimiento, String estadoFiltro);
	
//	public Requerimiento findByRequerimiento(String requerimiento);
//	@Query(value="select * from requerimiento r,estimacion_requerimiento_fase erf, estimacion e "
//			+ "where r.requerimiento like %?1% "
//			+ "and r.id = erf.requerimiento_id "
//			+ "and erf.estimacion_id = e.id "
//			+ "and e.activo = 1" , nativeQuery=true)
	
	
//	@Query("select erf from Requerimiento r, EstimacionRequerimientoFase erf, Estimacion e "
//			+ "where r.requerimiento like %?1% "
//			+ "and r.id = erf.requerimiento "
//			+ "and erf.estimacion = e.id "
//			+ "and e.activo = 1")
//	public List<EstimacionRequerimientoFase> findByEstimacionRequerimientoFase(String requerimiento);
	
//	@Query("select r from Requerimiento r, EstimacionRequerimientoFase erf, Estimacion e "
//			+ "where r.id = ?1 "
//			+ "and r.id = erf.requerimiento "
//			+ "and erf.estimacion = e.id "
//			+ "and e.activo = 1")
//	public Optional<Requerimiento> findById(Long id);
	
	public Requerimiento findByRequerimiento(String requerimiento);
	
	
}
