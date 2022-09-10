package com.workschedule.app.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.workschedule.app.models.entity.RequerimientoSimple;

public interface IRequerimientoSimpleDao extends CrudRepository<RequerimientoSimple, Long> {
	
//	@Query("select r from Requerimiento r fetch r.aplicacion a  where r.requerimiento like %?1%  ")
//	@Query("select r from RequerimientoSimple where f.requerimiento like %?1%")
	public List<RequerimientoSimple> findByRequerimientoContainingIgnoreCase(String requerimiento);
	
//	@Query("select r from Requerimiento r where r.requerimiento like %?1%")
//	public List<RequerimientoSimple> findByRequerimientoLikeIgnoreCase(String requerimiento);
}
