package com.workschedule.app.models.service;

import com.workschedule.app.models.dao.IEstimacionTareaDao;
import com.workschedule.app.models.entity.EstimacionTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstimacionTareaServiceImpl implements IEstimacionTareaService {

	@Autowired
	IEstimacionTareaDao estimacionTareaDao;
	@Transactional
	@Override
	public void save(EstimacionTarea estimacionTarea) {
		estimacionTareaDao.save(estimacionTarea);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		estimacionTareaDao.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<EstimacionTarea> getAllTask() {
		return (List<EstimacionTarea>) estimacionTareaDao.findAll();
	}

}
