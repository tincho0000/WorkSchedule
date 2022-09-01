package com.workschedule.app.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.workschedule.app.models.entity.Planificacion;
import com.workschedule.app.models.entity.RequerimientoFase;
import com.workschedule.app.models.entity.RequerimientoFaseId;
import com.workschedule.app.models.entity.Usuario;
import com.workschedule.app.models.service.IPlanificacionService;
import com.workschedule.app.models.service.IRequerimientoFaseService;
import com.workschedule.app.models.service.IUsuarioService;

@RequestMapping("/planificacion")
@Controller
public class PlanificacionController {
	
	@Autowired
	IPlanificacionService planificacionService; 
	@Autowired
	IRequerimientoFaseService requerimientoFaseService; 
	@Autowired
	IUsuarioService usuarioService; 

	@Secured({"ROLE_GESTION", "ROLE_ADMIN"})
	@GetMapping("/listar")
	public String listar () {
		
		List<Planificacion> planificaciones = planificacionService.findAll();
		
		for (Planificacion planificacion : planificaciones) {
			System.out.println("Planif: " + planificacion.getId());
		}
		
//		Planificacion planificacion = planificacionService.findOne((long) 1);
//		planificacion.setHorasIncurridas(100);
//		planificacionService.save(planificacion);
//		planificacionService.delete((long) 2);
		
		Planificacion planificacion = new Planificacion();
		RequerimientoFaseId rFId = new RequerimientoFaseId();
		rFId.setFaseId((long) 1);
		rFId.setRequerimientoId((long) 1);
		RequerimientoFase rF = requerimientoFaseService.findOne(rFId);
		Usuario u = usuarioService.findByUsuario("martin");
		planificacion.setFecha(new Date());
		planificacion.setHorasIncurridas(5);
		planificacion.setHorasPlanificadas(5);
		planificacion.setObservacion("dshfnkahn");
		planificacion.setRequerimientoFases(rF);
		planificacion.setUsuario(u);
		planificacionService.save(planificacion);
		
		return "planificacion/alta-planificacion";
	}
}
