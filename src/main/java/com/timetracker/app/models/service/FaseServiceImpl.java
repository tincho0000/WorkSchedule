package com.timetracker.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.timetracker.app.models.dao.IFaseDao;
import com.timetracker.app.models.dao.IFaseSimpleDao;
import com.timetracker.app.models.entity.Fase;
import com.timetracker.app.models.entity.FaseSimple;

@Service
public class FaseServiceImpl implements IFaseService {

	@Autowired
	public IFaseDao faseDao;
	@Autowired
	public IFaseSimpleDao faseSimpleDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Fase> findAll() {
		return (List<Fase>) faseDao.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Fase findOne(Long id) {
		return faseDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void save(Fase fase) {
		faseDao.save(fase); 

	}

	@Transactional
	@Override
	public void delete(Long id) {
		faseDao.deleteById(id);

	}

	@Transactional(readOnly = true)
	@Override
	public List<FaseSimple> findByDescripcion(String termino) {
		return faseSimpleDao.findByDescripcion(termino);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<FaseSimple> findFaseAll() {
		return (List<FaseSimple>) faseSimpleDao.findFaseAll();
	}

}
