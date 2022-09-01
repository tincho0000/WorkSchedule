package com.workschedule.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workschedule.app.models.dao.IPlanificacionDao;
import com.workschedule.app.models.entity.Planificacion;

@Service
public class PlanificacionServiceImpl implements IPlanificacionService{

	@Autowired
	IPlanificacionDao planificacionDao;
	
	@Override
	public List<Planificacion> findAll() {
		return (List<Planificacion>) planificacionDao.findAll();
	}

	@Override
	public Planificacion findOne(Long id) {
		return planificacionDao.findById(id).orElse(null);
	}

	@Override
	public void save(Planificacion planificacion) {
		planificacionDao.save(planificacion);
	}

	@Override
	public void delete(Long id) {
		planificacionDao.deleteById(id);
	}

}
