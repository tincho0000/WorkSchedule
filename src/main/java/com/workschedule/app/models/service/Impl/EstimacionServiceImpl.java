package com.workschedule.app.models.service.Impl;

import java.util.List;

import com.workschedule.app.models.service.IEstimacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workschedule.app.models.dao.IEstimacionDao;
import com.workschedule.app.models.entity.Estimacion;

@Service
public class EstimacionServiceImpl implements IEstimacionService {
	
	@Autowired
	IEstimacionDao estimacionDao;

	@Override
	public List<Estimacion> findAll() {
		return (List<Estimacion>) estimacionDao.findAll();
	}

	@Override
	public Estimacion findOne(Long id) {
		return estimacionDao.findById(id).orElseGet(null);
	}

	@Override
	public void save(Estimacion estimacion) {
		estimacionDao.save(estimacion);
		
	}

	@Override
	public void delete(Long id) {
		estimacionDao.deleteById(id);
		
	}

}
