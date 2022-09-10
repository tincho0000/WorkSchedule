package com.workschedule.app.models.service;

import java.time.LocalDate;
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

	@Override
	public List<Planificacion> findByUsuarioIdAndFechaBetween(Long usuario, LocalDate desde, LocalDate hasta) {
		return planificacionDao.findByUsuarioIdAndFechaBetween(usuario, desde, hasta);
	}

//	@Override
//	public DetallePlanificacion obtenerPlanificacion(String usuario, LocalDate fecha, String aplicacion,
//			String requerimiento) {
//		
//		DetallePlanificacion detallePlanificacion = new DetallePlanificacion();
//		List<RequerimientoFase> requerimientoFase = new ArrayList<>();
//		Map<RequerimientoFase, Integer> map = new HashMap<RequerimientoFase, Integer>();
//		Integer horasInsumidas = null;
//		
//		for (RequerimientoFase reqFase : requerimientoFase) {
//			map.put(reqFase, horasInsumidas);
//		}
//		
//		return detallePlanificacion;
//	}

}
