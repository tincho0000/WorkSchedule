package com.workschedule.app.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workschedule.app.models.dao.IRequerimientoDao;
import com.workschedule.app.models.dao.IRequerimientoSimpleDao;
import com.workschedule.app.models.entity.EstimacionRequerimientoFase;
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
	public Page<Requerimiento> findByRequerimientoAndAplicacionAndEstadoLikeIgnoreCase(Pageable pageable, String requerimiento, Long aplicacion, String estado) {
		return requerimientoDao.findByRequerimientoAndAplicacionAndEstadoLikeIgnoreCase(pageable, requerimiento, aplicacion, estado);
	}

	@Transactional(readOnly = true)
	@Override
	public Page<Requerimiento> findByRequerimientoLikeIgnoreCaseAndEstadoLikeIgnoreCase(Pageable pageable, String requerimiento, String estado) {
		return requerimientoDao.findByRequerimientoLikeIgnoreCaseAndEstadoLikeIgnoreCase(pageable, requerimiento, estado);
	}

	@Transactional(readOnly = true)
	@Override
	public Page<Requerimiento> findByFiltros(int page, String requerimiento, String aplicacion, String estado) {
		
		Pageable pageRequest = PageRequest.of(page, 10);
		Page<Requerimiento> requerimientos = null;
		
		//Depende de los filtros es la busqueda que hacemos
		if ( ("").equals(requerimiento) && ("").equals(aplicacion) && ("").equals(estado)) {
			requerimientos = requerimientoDao.findAll(pageRequest);
		} else if ((!requerimiento.equals("") || !estado.equals("")) && ("").equals(aplicacion)) {
			requerimientos = requerimientoDao.findByRequerimientoLikeIgnoreCaseAndEstadoLikeIgnoreCase(pageRequest, requerimiento, estado);
		} else {
			requerimientos = requerimientoDao.findByRequerimientoAndAplicacionAndEstadoLikeIgnoreCase(pageRequest, requerimiento, Long.parseLong(aplicacion), estado);
		}
		
		return requerimientos;
	}
	
	
	@Override
	public List<EstimacionRequerimientoFase> findByRequerimiento(String requerimiento) {
		return requerimientoDao.findByEstimacionRequerimientoFase(requerimiento);
	}

	@Override
	public List<RequerimientoSimple> findByRequerimientoContaining(String requerimiento) {
		return requerimientoSimpleDao.findByRequerimientoContainingIgnoreCase(requerimiento);
	}

	@Override
	public List<RequerimientoSimple> findByRequerimientos() {
		return (List<RequerimientoSimple>) requerimientoSimpleDao.findAll();
	}

	@Override
	public Requerimiento findByRequerimiento(Long id) {
		return requerimientoDao.findById(id).orElse(null);
	}

	@Override
	public RequerimientoSimple findByRequerimientoSimple(Long id) {
		return requerimientoSimpleDao.findById(id).orElse(null);
	}


}
