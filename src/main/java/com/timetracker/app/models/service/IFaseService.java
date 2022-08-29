package com.timetracker.app.models.service;

import java.util.List;

import com.timetracker.app.models.entity.Fase;
import com.timetracker.app.models.entity.FaseSimple;

public interface IFaseService {
	
	public List<Fase> findAll();
	public Fase findOne(Long id);
	public void save (Fase fase);
	public void delete (Long id);
	
	public List<FaseSimple> findByDescripcion (String termino);
	public List<FaseSimple> findFaseAll();

}
