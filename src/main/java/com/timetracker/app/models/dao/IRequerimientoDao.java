package com.timetracker.app.models.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.timetracker.app.models.entity.Requerimiento;

public interface IRequerimientoDao extends PagingAndSortingRepository<Requerimiento, Long> {
	
//	@Query("select r from Requerimiento r fetch r.aplicacion a  where r.requerimiento like %?1%  ")
	@Query(value="select * from requerimiento where requerimiento like %?1% and aplicacion_id = ?2", nativeQuery=true)
	public Page<Requerimiento> findByRequerimientoAndAplicacion(Pageable pageable, String requerimiento, Long aplicacion);

	@Query("select r from Requerimiento r where r.requerimiento like %?1%")
	public Page<Requerimiento> findByRequerimientoLikeIgnoreCase(Pageable pageable, String requerimiento);
}
