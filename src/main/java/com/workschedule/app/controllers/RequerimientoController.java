package com.workschedule.app.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.workschedule.app.enums.Aplicacion;
import com.workschedule.app.enums.EstadoRequerimiento;
import com.workschedule.app.enums.Fase;
import com.workschedule.app.enums.TipoRequerimiento;
import com.workschedule.app.models.entity.Estimacion;
import com.workschedule.app.models.entity.Requerimiento;
import com.workschedule.app.models.entity.Usuario;
import com.workschedule.app.models.service.IEstimacionService;
import com.workschedule.app.models.service.IPlanificacionService;
import com.workschedule.app.models.service.IRequerimientoService;
import com.workschedule.app.models.service.IUsuarioService;
import com.workschedule.app.util.paginator.PageRender;

@Secured("ROLE_GESTION")
@Controller
@RequestMapping("/requerimientos")
@SessionAttributes("requerimiento")
public class RequerimientoController {
	
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	IRequerimientoService requerimientoService;
//	@Autowired
//	IRequerimientoFaseDao requerimientoFaseDao;
	@Autowired
	IUsuarioService usuarioService;
	@Autowired
	IPlanificacionService planificacionService;
	@Autowired
	IEstimacionService estimacionService;
	
	public RequerimientoController() {
	}
	
	@GetMapping("/listar-requerimientos")
	public String listarRequerimientos(	Model model,
										@RequestParam(name = "page", defaultValue = "0") int page,
										@RequestParam(name = "reqFilter", defaultValue = "") String requerimientoFiltro,
										@RequestParam(name = "appFilter", defaultValue = "") String aplicacionFiltro,
										@RequestParam(name = "estadoFilter", defaultValue = "") String estadoFiltro
			) {
		
		
		/******************** Alta Req + estimacion************************/
		
//		Requerimiento req = new Requerimiento();
//		req.setAplicacion(Aplicacion.SHV);
//		req.setDescripcion("descripcion");
//		req.setEstado(EstadoRequerimiento.ESTIMACION);
//		req.setFechaPlanifImplementacion(null);
//		req.setFechaPlanifTesting(null);
//		req.setFechaRealImplementacion(null);
//		req.setFechaRealTesting(null);
//		req.setMotivoReplanifImplementacion(null);
//		req.setMotivoReplanifTesting(null);
//		req.setObservacion("observacion");
//		req.setRequerimiento("SHV-100");
//		req.setTipoRequerimiento(TipoRequerimiento.EVOLUTIVO);
//		
//		//Armo estimacion
//		List<Fase> fases2 = Fase.obtenerFases();
//		for (Fase fase : fases2) {
//			
//			Estimacion estimacion = new Estimacion();
//			estimacion.setActivo(1);
//			estimacion.setCantidadHoras(20);
//			estimacion.setFechaAlta(new Date());
//			estimacion.setFechaUpdate(new Date());
//			estimacion.setRequerimiento(req);
//			estimacion.setUsuarioAlta("martin.bertomeu");
//			estimacion.setVersion(1);
//			estimacion.setFase(fase);
//			req.addEstimacion(estimacion);
//			
//		}
//		
//		requerimientoService.save(req);
		
		
		/******************** buscar ************************/
		Requerimiento requerimiento = requerimientoService.findByRequerimiento("SHV-100");
		
		/******************** Alta Estimacion ************************/
		
		List<Fase> fases2 = Fase.obtenerFases(); 
		
		//Agrego fases al req
		for (Fase fase : fases2) {
			
			Estimacion estimacion = new Estimacion();
			estimacion.setActivo(0);
			estimacion.setCantidadHoras(10);
			estimacion.setFechaAlta(new Date());
			estimacion.setFechaUpdate(new Date());
			estimacion.setRequerimiento(requerimiento);
			estimacion.setUsuarioAlta("martin.bertomeu");
			estimacion.setVersion(2);
			estimacion.setFase(fase);
			requerimiento.addEstimacion(estimacion);
			
		}
		
		requerimientoService.save(requerimiento);
		
		/********************Eliminar Estimacion***********************/
//		estimacionService.delete((long)11);

		//********************Eliminar req ******************************
		
//		Requerimiento requerimiento = requerimientoService.findByRequerimiento("SHV-100");
//		requerimientoService.delete(requerimiento);
		
		//********************Eliminar estimacion ******************************
		
//		Requerimiento requerimiento = requerimientoService.findByRequerimiento("SHV-100");
//				
//		for (int i = 0; i < requerimiento.getEstimacion().size(); i++) {
//			
//			requerimiento.deleteEstimacion(i);
//			
//		}
//		requerimientoService.save(requerimiento);
//		
		
		/*********************************************************/
		//Buscar por ID de Req y fase
//		RequerimientoFaseId requerimientoFaseId = new RequerimientoFaseId((long)1, (long)1);
//		requerimientoFaseDao.findByRequerimientoFaseId(requerimientoFaseId);
//		System.out.println( ( requerimientoFaseDao.findByRequerimientoFaseId(requerimientoFaseId) ).toString() );
		
		//Buscar por ID de Req solamente
//		List<RequerimientoFase> rf = requerimientoFaseDao.findByRequerimientoId((long)2);
//		for (RequerimientoFase r : rf ) {
//			System.out.println( r.getRequerimientoFaseId().toString());
//		}
		
		
		/*********************************************************/
		// Select a la tabla de planificacion
//		List<Planificacion> planificacion = planificacionService.findAll();
//		
//		for (Planificacion planif : planificacion) {
//			System.out.println("Id planif: " + planif.getId());
//			System.out.println("Id estimacion: " + planif.getEstimacionRequerimientoFases().getEstimacion().getId());
//			System.out.println("Id req: " + planif.getEstimacionRequerimientoFases().getRequerimiento().getId());
//			System.out.println("Id fase: " + planif.getEstimacionRequerimientoFases().getFase().getId());
//		}
		/*---------------------------------------------------*/
		// alta de planificacion
//		Planificacion planificacion = new Planificacion();
		
		
		/*---------------------------------------------------*/
		
		
		
		String url = "";
		if ( aplicacionFiltro == null) {
			url = "/requerimientos/listar-requerimientos?reqFilter"+requerimientoFiltro+"&estadoFilter="+estadoFiltro;
		} else {
			url = "/requerimientos/listar-requerimientos?reqFilter="+requerimientoFiltro+"&appFilter="+aplicacionFiltro+"&estadoFilter="+estadoFiltro;
		}
		System.err.println("requerimientoFiltro: " + requerimientoFiltro);
		System.err.println("aplicacionFiltro: " + aplicacionFiltro);
		System.err.println("estadoFiltro: " + estadoFiltro);
		
		Page<Requerimiento> requerimientos = requerimientoService.findByFiltros(page, requerimientoFiltro, aplicacionFiltro, estadoFiltro);
		PageRender<Requerimiento> pageRender = new PageRender<>(url, requerimientos);
		
		List<String> aplicaciones = Aplicacion.obtenerAplicaciones();
		List<Fase> fases = Fase.obtenerFases();
		
		model.addAttribute("titulo", "Lista de Requerimientos");
		model.addAttribute("requerimientos", requerimientos);
		model.addAttribute("aplicaciones", aplicaciones);
		model.addAttribute("fases", fases);
		model.addAttribute("reqFilter", requerimientoFiltro);
		model.addAttribute("appFilter", aplicacionFiltro);
		model.addAttribute("estadoFilter", estadoFiltro);
		model.addAttribute("page", pageRender);
		return "requerimiento/listar-requerimientos";
	}
	
//	@GetMapping("/eliminar/{id}")
//	public String eliminarRequerimiento(@PathVariable(value="id") Long id, RedirectAttributes flash) {
//		Requerimiento requerimiento = requerimientoService.findOne(id);
//		if (requerimiento != null) {
//			requerimientoService.delete(id);
//			flash.addFlashAttribute("success", "Rquerimiento eliminado con exito! El ID es: " + requerimiento.getRequerimiento());
//			return "redirect:/requerimientos/listar-requerimientos";
//		}
//		
//		flash.addFlashAttribute("error", "El rquerimiento no existe en la BD!");
//		return "redirect:/requerimientos/listar-requerimientos";
//	}

	@GetMapping("/form")
	public String crear(Model model) {
		Requerimiento requerimiento = new Requerimiento();
		requerimiento.setEstimacion(new ArrayList<>());
		//model.addAttribute("fases", listaFases);
		model.addAttribute("requerimiento", requerimiento);
		return "requerimiento/form";
	}

//	@GetMapping(value = "/cargar-fases/{termino}", produces = { "application/json" })
//	public @ResponseBody List<FaseSimple> cargarFases(@PathVariable String termino) {
//		if (termino.equals("*")) {
//			return faseService.findFaseAll();
//		}
//		return faseService.findByDescripcion(termino);
//	}

	
	/************************************/
	/******  @PostMapping("/form") ******/
	/************************************/
//	@PostMapping("/form")
//	public String guardar(@Valid @ModelAttribute Requerimiento requerimiento, BindingResult result, Model model,
//			@RequestParam(name = "fase_id[]", required = false) Long[] fases,
//			@RequestParam(name = "cantidad[]", required = false) Integer[] horasFase, RedirectAttributes flash, SessionStatus status) {
//		
//		boolean existe;
//		boolean modificacion = false;
//		List<EstimacionRequerimientoFase> requerimientoFase = null;
//		List<Aplicacion> aplicaciones = aplicacionService.findAll();
//		List<Fase> fasesBD = faseService.findAll();
//		List<String> listaFases = new ArrayList<>();
//		List<Long> listaFasesId = new ArrayList<>();
//		
//		for (Fase fase : fasesBD) {
//			listaFases.add(fase.getFase());
//			listaFasesId.add(fase.getId());
//		}
//		
//		
//		// Distinto de null es porque estamos haciendo una modificacion
//		if (requerimiento.getId() != null) {
//			modificacion = true;
//		}
//		
//		
//		if(result.hasErrors()) {
//			if (modificacion) {
//				model.addAttribute("titulo", "Editar Requerimiento");
//			} else {
//				model.addAttribute("titulo", "Alta Requerimiento");
//			}
//			model.addAttribute("aplicaciones", aplicaciones);
//			model.addAttribute("fases", fasesBD);
//			model.addAttribute("listaFases", listaFases);
//			model.addAttribute("listaFasesId", listaFasesId);
//			return "requerimiento/form";
//		}
//		
//		//Valido que el requerimiento tenga al menos una fase
//		if (fases == null || fases.length == 0) {
//			if (modificacion) {
//				model.addAttribute("titulo", "Editar Requerimiento");
//			} else {
//				model.addAttribute("titulo", "Alta Requerimiento");
//			}
//			model.addAttribute("error", "Error: El requerimiento debe tener al menos una fase!");
//			model.addAttribute("aplicaciones", aplicaciones);
//			model.addAttribute("fases", fasesBD);
//			model.addAttribute("listaFases", listaFases);
//			model.addAttribute("listaFasesId", listaFasesId);
//			return "requerimiento/form";
//		}
//		
////		System.out.println("Requerimiento" + requerimiento.toString());
//		/*
//		if (modificacion) {
//			System.out.println("Estoy ante una modificacion");
//			requerimientoFase = requerimientoFaseService.findByRequerimientoId(requerimiento.getId());
//		}
//		
//		
//		//Agregamos las fases al requerimiento si no estan
//		for (int i = 0; i < fases.length; i++) {
//			log.info("ID: " + fases[i] + " Cantidad de Horas: " + horasFase[i]);
//			
//			//Si estamos editando
//			if (modificacion) {
//				existe = false;
//				for (int j = 0; j < requerimientoFase.size(); j++) {
//					//Si existe
//					if (requerimientoFase.get(j).getRequerimientoFaseId().getFaseId() == (long)fases[i] ) {
//						requerimiento.getRequerimientoFases().get(j).setCantidadHoras(horasFase[i]);
//						existe = true;
//					} 
//				}
//				if (!existe) {
//					Fase fase = recuperarFase(fasesBD, fases[i]);
//					requerimiento.addFase(fase, horasFase[i]);
//				}
//				
//				
//			} else {
//				Fase fase = recuperarFase(fasesBD, fases[i]);
//				requerimiento.addFase(fase, horasFase[i]);
//			}
//		}
//		
//		
//		//Buscamos posibles fases eliminadas desde la vista
//		//Si estamos editando
//		
//		if (modificacion) {
//			for (int i = 0; i < requerimientoFase.size(); i++) {
//				existe=false;
//				for (int j = 0; j < fases.length; j++) {
//					if (requerimientoFase.get(i).getRequerimientoFaseId().getFaseId() == (long)fases[j] ) {
//						existe=true;
//					}
//				}
//				if (!existe) {
//					Fase fase = recuperarFase(fasesBD, fases[i]);
//					requerimiento.removeFase(fase);
//				}
//			}
//				
//		}
//		*/
//		
//		//Si no es modificacion incluimos el usuario que da de alta el requerimiento
//		if (!modificacion) {
//			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//			Usuario usuario = usuarioService.findByUsuario(auth.getName());
//			System.err.println(usuario);
//			requerimiento.setUsuario(usuario);
//		}
//		
//		System.out.println("Requerimiento" + requerimiento.toString());
//		
//		try {
//			requerimientoService.save(requerimiento);
//		} catch (DataIntegrityViolationException e) {
//			System.err.println("ERROR: " + e.toString());
//			if (modificacion) {
//				model.addAttribute("titulo", "Editar Requerimiento");
//			} else {
//				model.addAttribute("titulo", "Alta Requerimiento");
//			}
//			model.addAttribute("error", "Error: La combinación del Requerimiento mas la Descripción mas la aplicación ya existe!!!");
//			model.addAttribute("aplicaciones", aplicaciones);
//			model.addAttribute("fases", fasesBD);
//			model.addAttribute("listaFases", listaFases);
//			model.addAttribute("listaFasesId", listaFasesId);
//			return "requerimiento/form";
//		}
//		
//		status.setComplete();
//		
//		if (modificacion) {
//			flash.addFlashAttribute("success","Requerimiento modificado con exito");
//		}else {
//			flash.addFlashAttribute("success","Requerimiento creado con exito");
//		}
//
//		return "redirect:listar-requerimientos";
//	}
//	
//	@GetMapping("/editar/{id}")
//	public String editarRequerimiento( @PathVariable(value="id") Long id, RedirectAttributes flash, Model model) {
//		
//		Requerimiento requerimiento = requerimientoService.findOne(id);
//		List<Aplicacion> aplicaciones = aplicacionService.findAll();
//		List<Fase> fases = faseService.findAll();
//		
//		model.addAttribute("titulo", "Editar Requerimiento");
//		model.addAttribute("requerimiento", requerimiento);
//		model.addAttribute("aplicaciones", aplicaciones);
//		model.addAttribute("fases", fases);
//		return "/requerimiento/editar";
//	}
//	
//	
//	/****************************************/
//	/************* Utilidades ***************/
//	/****************************************/
//	public Fase recuperarFase(List<Fase> fases, Long id) {
//		
//		for (int i = 0; i < fases.size(); i++) {
//			if (fases.get(i).getId() == id) {
//				return fases.get(i);
//			}
//		}
//		
//		return null;
//		
//	}

}
