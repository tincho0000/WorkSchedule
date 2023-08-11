package com.workschedule.app.models.service;

import com.workschedule.app.models.dao.IPlanificacionEstimadaDao;
import com.workschedule.app.models.dao.IPlanificacionTareaDao;
import com.workschedule.app.models.entity.PlanificacionEstimada;
import com.workschedule.app.models.entity.PlanificacionTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlanificacionTareaServiceImpl implements IPlanificacionTareaService {

	@Autowired
	IPlanificacionTareaDao planificacionTareaDao;
	@Transactional
	@Override
	public void save(PlanificacionTarea planificacionTarea) {
		planificacionTareaDao.save(planificacionTarea);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		planificacionTareaDao.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<PlanificacionTarea> getAllTask() {
		return (List<PlanificacionTarea>) planificacionTareaDao.findAll();
	}

}
