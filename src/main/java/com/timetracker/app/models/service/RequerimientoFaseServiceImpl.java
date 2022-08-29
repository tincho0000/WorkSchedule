package com.timetracker.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.timetracker.app.models.dao.IRequerimientoFaseDao;
import com.timetracker.app.models.entity.RequerimientoFase;
import com.timetracker.app.models.entity.RequerimientoFaseId;

@Service
public class RequerimientoFaseServiceImpl implements IRequerimientoFaseService {

	@Autowired
	IRequerimientoFaseDao requerimientoFaseDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<RequerimientoFase> findAll() {
		return (List<RequerimientoFase>) requerimientoFaseDao.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public RequerimientoFase findOne(RequerimientoFaseId id) {
		return requerimientoFaseDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void save(RequerimientoFase requerimientoFase) {
		requerimientoFaseDao.save(requerimientoFase);
	}

	@Transactional
	@Override
	public void delete(RequerimientoFase id) {
		requerimientoFaseDao.delete(id);
	}

	@Transactional
	@Override
	public void deleteRequerimientoFase(Long r_id, Long f_id) {
		requerimientoFaseDao.deleteRequerimientoFase(r_id, f_id);
		
	}

	@Transactional(readOnly = true)
	@Override
	public List<RequerimientoFase> findByRequerimientoId(Long id) {
		return requerimientoFaseDao.findByRequerimientoId(id);
	}

}
