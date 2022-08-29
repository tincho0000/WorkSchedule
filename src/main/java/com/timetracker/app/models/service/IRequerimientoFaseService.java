package com.timetracker.app.models.service;

import java.util.List;

import com.timetracker.app.models.entity.RequerimientoFase;
import com.timetracker.app.models.entity.RequerimientoFaseId;

public interface IRequerimientoFaseService {
	
	public List<RequerimientoFase> findAll();
	public RequerimientoFase findOne(RequerimientoFaseId id);
	public void save (RequerimientoFase requerimientoFase);
	public void delete (RequerimientoFase id);
	public void deleteRequerimientoFase (Long r_id, Long f_id);
	public List <RequerimientoFase> findByRequerimientoId (Long id);

}
