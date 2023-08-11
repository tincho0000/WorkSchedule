package com.workschedule.app.controllers;

import com.workschedule.app.DTO.PlanningTaskDTO;
import com.workschedule.app.models.entity.*;
import com.workschedule.app.models.service.IPlanificacionEstimadaService;
import com.workschedule.app.models.service.IPlanificacionTareaService;
import com.workschedule.app.models.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
@Controller
@RequestMapping("/planning")
public class PlanningController {

	@Autowired
	IPlanificacionEstimadaService planificacionEstimadaService;

	@Autowired
	IPlanificacionTareaService planificacionTareaService;

	@Autowired
	IUsuarioService usuarioService;
	@PostMapping(value="")
	public String savePlanning(@ModelAttribute PlanificacionEstimada planning, BindingResult errors, Model model) {
		PlanningTaskDTO planningDTO = new PlanningTaskDTO();
		PlanificacionEstimada planificacion = buildNewEstimatePlanning();
		PlanificacionTarea tareaEstimacion = new PlanificacionTarea();
		PlanificacionTarea disenoDetalladoEstimacion = new PlanificacionTarea();
		tareaEstimacion.setPlanificacionOriginal(planificacion);
		planificacionEstimadaService.save(planificacion);
		planificacionTareaService.save(tareaEstimacion);
		planificacionTareaService.save(disenoDetalladoEstimacion);
		model.addAttribute("planning", planning);
		model.addAttribute("planningDTO", planningDTO);
		model.addAttribute("taskEstimacion", tareaEstimacion);
		model.addAttribute("disenoDetalladoEstimacion", disenoDetalladoEstimacion);
		return "planning/new-planning";
	}
	@GetMapping("/planning/listar-planning")
	public String showPlanningList(Model model) {
		model.addAttribute("tareas", planificacionTareaService.getAllTask());
		return "listar-planning";
	}

	private PlanificacionEstimada buildNewEstimatePlanning() {
		PlanificacionEstimada planificacion = new PlanificacionEstimada();
		LocalDate currentDate = LocalDate.now();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Usuario usuario = usuarioService.findByUsuario(auth.getName());
		planificacion.setFechaCreacion(currentDate);
		planificacion.setUltimaFechaModificacion(currentDate);
		planificacion.setUser_owner_id(usuario.getId().intValue());
		return planificacion;
	}

		// logic to process input data
}
