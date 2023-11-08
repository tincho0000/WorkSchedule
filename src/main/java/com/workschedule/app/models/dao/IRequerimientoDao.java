package com.workschedule.app.models.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.workschedule.app.models.entity.Requerimiento;
import org.springframework.data.repository.query.Param;

public interface IRequerimientoDao extends PagingAndSortingRepository<Requerimiento, Long> {
	
//	@Query("select r from Requerimiento r fetch r.aplicacion a  where r.requerimiento like %?1%  ")

	@Query(value = "select * from Requerimiento r where r.aplicacion like %:aplicacion% and (:requerimiento is null or r.requerimiento like %:requerimiento%) and (:estado is null or r.estado like %:estado%) ", nativeQuery = true)
	public Page<Requerimiento> findByRequerimientoAndAplicacionAndEstadoLikeIgnoreCase(Pageable pageable, @Param("requerimiento") Optional<String> requerimiento, @Param("aplicacion") String aplicacion, @Param("estado") Optional<String> estadoFiltro);

	@Query(value = "select r from Requerimiento r where r.requerimiento like %:requerimiento% and r.estado like %:estado%", nativeQuery = true)
	public Page<Requerimiento> findByRequerimientoLikeIgnoreCaseAndEstadoLikeIgnoreCase(Pageable pageable, @Param("requerimiento") String requerimiento,@Param("estado") String estadoFiltro);
	
	
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

	@Query("SELECT r FROM Requerimiento r WHERE r.requerimiento = :requerimiento")
	public Requerimiento findByRequerimiento(@Param("requerimiento") String requerimiento);
	
	
}
