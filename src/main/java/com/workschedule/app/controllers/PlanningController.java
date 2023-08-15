package com.workschedule.app.controllers;

import com.workschedule.app.DTO.PlanningTaskDTO;
import com.workschedule.app.models.entity.*;
import com.workschedule.app.models.service.IPlanificacionEstimadaService;
import com.workschedule.app.models.service.IEstimacionTareaService;
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
	IEstimacionTareaService estimacionTareaService;

	@Autowired
	IUsuarioService usuarioService;
	@PostMapping(value="")
	public String savePlanning(@ModelAttribute PlanificacionEstimada planning, BindingResult errors, Model model) {
		PlanningTaskDTO planningDTO = new PlanningTaskDTO();
		EstimacionTarea tareaEstimacion = new EstimacionTarea();
		Requerimiento requerimiento = new Requerimiento();
		tareaEstimacion.setRequerimiento(requerimiento);
		estimacionTareaService.save(tareaEstimacion);
		model.addAttribute("planning", planning);
		model.addAttribute("planningDTO", planningDTO);
		model.addAttribute("taskEstimacion", tareaEstimacion);
		return "planning/new-planning";
	}
	@GetMapping("/planning/listar-planning")
	public String showPlanningList(Model model) {
		model.addAttribute("tareas", estimacionTareaService.getAllTask());
		return "listar-planning";
	}

	private Requerimiento buildNewRequirement() {
		Requerimiento requerimiento = new Requerimiento();
		LocalDate currentDate = LocalDate.now();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Usuario usuario = usuarioService.findByUsuario(auth.getName());
		return requerimiento;
	}

		// logic to process input data
}
