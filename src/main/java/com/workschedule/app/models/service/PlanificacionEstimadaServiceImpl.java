package com.workschedule.app.models.service;

import com.workschedule.app.models.dao.IPlanificacionEstimadaDao;
import com.workschedule.app.models.entity.PlanificacionEstimada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlanificacionEstimadaServiceImpl implements IPlanificacionEstimadaService {

	@Autowired
	IPlanificacionEstimadaDao planificacionEstimadaDao;
	@Transactional
	@Override
	public void save(PlanificacionEstimada planificacion) {
		planificacionEstimadaDao.save(planificacion);
	}
	@Transactional
	@Override
	public void delete(Long id) {
		planificacionEstimadaDao.deleteById(id);
	}

}
