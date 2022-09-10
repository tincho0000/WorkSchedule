package com.workschedule.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workschedule.app.models.dao.IRequerimientoDao;
import com.workschedule.app.models.dao.IRequerimientoSimpleDao;
import com.workschedule.app.models.entity.Requerimiento;
import com.workschedule.app.models.entity.RequerimientoSimple;

@Service
public class RequemientoServiceImpl implements IRequerimientoService {

	@Autowired
	private IRequerimientoDao requerimientoDao;
	@Autowired
	private IRequerimientoSimpleDao requerimientoSimpleDao;

	@Transactional(readOnly = true)
	@Override
	public List<Requerimiento> findAll() {
		return (List<Requerimiento>) requerimientoDao.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Page<Requerimiento> findAll(Pageable pageable) {
		return requerimientoDao.findAll(pageable);
	}

	@Transactional(readOnly = true)
	@Override
	public Requerimiento findOne(Long id) {
		return requerimientoDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void save(Requerimiento requerimiento) {
		requerimientoDao.save(requerimiento);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		requerimientoDao.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Page<Requerimiento> findByRequerimientoAndAplicacion(Pageable pageable, String requerimiento, Long aplicacion) {
		return requerimientoDao.findByRequerimientoAndAplicacion(pageable, requerimiento, aplicacion);
	}

	@Transactional(readOnly = true)
	@Override
	public Page<Requerimiento> findByRequerimientoLikeIgnoreCase(Pageable pageable, String requerimiento) {
		return requerimientoDao.findByRequerimientoLikeIgnoreCase(pageable, requerimiento);
	}

	@Transactional(readOnly = true)
	@Override
	public Page<Requerimiento> findByFiltros(int page, String requerimiento, Long aplicacion) {
		
		Pageable pageRequest = PageRequest.of(page, 10);
		Page<Requerimiento> requerimientos = null;
		
		//Depende de los filtros es la busqueda que hacemos
		if ( ("").equals(requerimiento) && aplicacion == null ) {
			requerimientos = requerimientoDao.findAll(pageRequest);
		} else if (!requerimiento.equals("") && aplicacion == null) {
			requerimientos = requerimientoDao.findByRequerimientoLikeIgnoreCase(pageRequest, requerimiento);
		} else {
			requerimientos = requerimientoDao.findByRequerimientoAndAplicacion(pageRequest, requerimiento, aplicacion);
		}
		
		return requerimientos;
	}
	
	@Override
	public Requerimiento findByRequerimiento(String requerimiento) {
		return requerimientoDao.findByRequerimiento(requerimiento);
	}

	@Override
	public List<RequerimientoSimple> findByRequerimientoContaining(String requerimiento) {
		return requerimientoSimpleDao.findByRequerimientoContainingIgnoreCase(requerimiento);
	}

	@Override
	public List<RequerimientoSimple> findByRequerimientos() {
		return (List<RequerimientoSimple>) requerimientoSimpleDao.findAll();
	}


}
