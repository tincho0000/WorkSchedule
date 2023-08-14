package com.workschedule.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.workschedule.app.models.entity.EstimacionRequerimientoFase;
import com.workschedule.app.models.entity.RequerimientoFaseId;

public interface IEstimacionRequerimientoFaseDao extends CrudRepository<EstimacionRequerimientoFase, RequerimientoFaseId> {
	
	/*@Modifying
	@Query(value="delete from requerimiento_fase r  where r.requerimiento_id = ?1 and r.fase_id = ?2", nativeQuery=true)
	public void deleteRequerimientoFase(Long requerimientoId, Long faseId);
	
	public EstimacionRequerimientoFase findByRequerimientoFaseId(RequerimientoFaseId requerimientoFaseId);
	
	public List<EstimacionRequerimientoFase> findByRequerimientoId(Long id);
	*/

}
