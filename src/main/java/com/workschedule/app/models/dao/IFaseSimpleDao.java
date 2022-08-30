package com.workschedule.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.workschedule.app.models.entity.FaseSimple;

public interface IFaseSimpleDao extends CrudRepository<FaseSimple, Long>{

	@Query("select f from FaseSimple f where f.descripcion like %?1%")
	public List<FaseSimple> findByDescripcion(String faseSimple);
	
	@Query("select f from FaseSimple f")
	public List<FaseSimple> findFaseAll();
	
}
