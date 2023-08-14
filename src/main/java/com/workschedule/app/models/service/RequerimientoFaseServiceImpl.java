package com.workschedule.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workschedule.app.models.dao.IEstimacionRequerimientoFaseDao;
import com.workschedule.app.models.entity.EstimacionRequerimientoFase;
import com.workschedule.app.models.entity.RequerimientoFaseId;

@Service
public class RequerimientoFaseServiceImpl implements IRequerimientoFaseService {

	@Autowired
	IEstimacionRequerimientoFaseDao requerimientoFaseDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<EstimacionRequerimientoFase> findAll() {
		return (List<EstimacionRequerimientoFase>) requerimientoFaseDao.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public EstimacionRequerimientoFase findOne(RequerimientoFaseId id) {
		return requerimientoFaseDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void save(EstimacionRequerimientoFase requerimientoFase) {
		requerimientoFaseDao.save(requerimientoFase);
	}

	@Transactional
	@Override
	public void delete(EstimacionRequerimientoFase id) {
		requerimientoFaseDao.delete(id);
	}

//	@Transactional
//	@Override
//	public void deleteRequerimientoFase(Long r_id, Long f_id) {
//		requerimientoFaseDao.deleteRequerimientoFase(r_id, f_id);
//		
//	}
//
//	@Transactional(readOnly = true)
//	@Override
//	public List<EstimacionRequerimientoFase> findByRequerimientoId(Long id) {
//		return requerimientoFaseDao.findByRequerimientoId(id);
//	}

}
