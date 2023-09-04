package com.workschedule.app.controllers;

import java.util.*;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.workschedule.app.models.entity.*;
import com.workschedule.app.models.service.*;
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

import com.workschedule.app.util.paginator.PageRender;

@Secured("ROLE_GESTION")
@Controller
@RequestMapping("/requerimientos")
@SessionAttributes("requerimiento")
public class RequerimientoController {
	
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	IRequerimientoService requerimientoService;
	@Autowired
	IFaseService faseService;
	@Autowired
	IAplicacionService aplicacionService;
	@Autowired
	IRequerimientoFaseService requerimientoFaseService;
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
		
		/******************** buscar ************************/
		List<EstimacionRequerimientoFase> estimacionRequerimientoFase = requerimientoService.findByRequerimiento("MOR-100");
		for (EstimacionRequerimientoFase erf : estimacionRequerimientoFase){
			System.err.println("Fase: " + erf.getFase().getFase()+ " horas: " + erf.getCantidadHoras());
		}
//		System.err.println(r.getEstimacionRequerimientoFases().get(0).getEstimacion().getCantidadHoras());
		
		/******************** Alta Req Estimacion ************************/
//		Requerimiento req = new Requerimiento();
//		Estimacion est = new Estimacion();
//		List<Fase> fases1 = faseService.findAll(); 
//		
//		
//		//agrego req
//		req.setAplicacion(aplicacionService.findOne((long)1));
//		req.setDescripcion("Se agregan filtros");
//		req.setEstado("Prueba");
//		req.setFecha(new Date());
//		req.setObservacion("Ninguna");
//		req.setRequerimiento("MOR-200");
//		req.setUsuario(usuarioService.findOne((long)1));
//		//Agrego fases al req
//		for (Fase fase : fases1) {
//			req.addEstimacionFase(fase, 10, est);
//		}
//		
//		//configuro estimacion
//		est.setActivo(1);
//		est.setCantidadHoras(100);
//		est.setDescripcion("Estimacion 1");
//		est.setFecha(new Date());
//		est.setRequerimiento(req);
//
//		
//		requerimientoService.save(req);
		
		/******************** Alta Estimacion ************************/
//		Requerimiento reqbuscado = requerimientoService.findByRequerimiento((long)13);
//		List<Fase> fases1 = faseService.findAll(); 
//		Estimacion est = new Estimacion();
//		for (Fase fase : fases1) {
//			reqbuscado.addEstimacionFase(fase, 20, est);
//		}
//		
//		//configuro estimacion
//		est.setActivo(0);
//		est.setCantidadHoras(110);
//		est.setDescripcion("Estimacion 4");
//		est.setFecha(new Date());
//		est.setRequerimiento(reqbuscado);
//		
//		estimacionService.save(est);
		
		/********************Eliminar Estimacion***********************/
//		estimacionService.delete((long)6);




		/********************Eliminar req (no se si funciona)******************************
		Requerimiento r = requerimientoService.findOne((long) 3);
		Fase f = faseService.findOne((long) 5);
		System.out.println(r.toString());
		
		for (RequerimientoFase rFase : r.getRequerimientoFases()) {
			System.err.println("Relaciones: [Req:" + rFase.getRequerimientoFaseId().getRequerimientoId() + " Fase: " + rFase.getRequerimientoFaseId().getFaseId() + "]");
			System.err.println("Fases: " + rFase.getFase().toString());
			
		}
		
		
		requerimientoFaseService.deleteRequerimientoFase(3L, 5L);
		
		r.removeFase(f);
		requerimientoService.save(r);
		
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
		
		List<Aplicacion> aplicaciones = aplicacionService.findAll();
		List<FaseSimple> fases = faseService.findFaseAll();
		
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
	
	@GetMapping("/eliminar/{id}")
	public String eliminarRequerimiento(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		Requerimiento requerimiento = requerimientoService.findOne(id);
		if (requerimiento != null) {
			requerimientoService.delete(id);
			flash.addFlashAttribute("success", "Rquerimiento eliminado con exito! El ID es: " + requerimiento.getRequerimiento());
			return "redirect:/requerimientos/listar-requerimientos";
		}
		
		flash.addFlashAttribute("error", "El rquerimiento no existe en la BD!");
		return "redirect:/requerimientos/listar-requerimientos";
	}

	@GetMapping("/form")
	public String crear(Model model) {

		List<FaseSimple> fases = faseService.findFaseAll();
//		List<FaseSimple> fasesSimple = faseService.findFaseAll();
		Requerimiento requerimiento = new Requerimiento();
		List<Aplicacion> aplicaciones = aplicacionService.findAll();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		List<FaseSimple> listaAnalisis = new ArrayList<>();
		List<FaseSimple> listaEvolutiva = new ArrayList<>();
		List<FaseSimple> listaCorrectivoRework = new ArrayList<>();
		List<String> listaEvolutivaAux = new ArrayList<>(Arrays.asList( "Análisis","Estimación", "Desarrollo", "PU", "PI", "PAU", "Implementación", "Homologacion"));
		List<String> listaCorrectivoReworkAux = new ArrayList<>(Arrays.asList("Análisis","Estimación", "Desarrollo", "PU", "Implementación", "Homologacion"));
		List<EstimacionRequerimientoFase> estimacionFasesRequerimientoList = new ArrayList<>();

		listaAnalisis = fases.stream().filter( fase -> "Análisis".equalsIgnoreCase(fase.getFase())).collect(Collectors.toList());
		listaCorrectivoRework = fases.stream().filter(fase -> listaCorrectivoReworkAux.contains(fase.getFase())).collect(Collectors.toList());
		listaEvolutiva = fases.stream().filter(fase -> listaEvolutivaAux.contains(fase.getFase())).collect(Collectors.toList());

		requerimiento.addAllEstimacionFases(estimacionFasesRequerimientoList);


		model.addAttribute("titulo", "Alta Requerimiento");
		model.addAttribute("fases", fases);
		model.addAttribute("listaEvolutiva", listaEvolutiva);
		model.addAttribute("listaCorrectivoRework", listaCorrectivoRework);
		model.addAttribute("listaAnalisis", listaAnalisis);
		model.addAttribute("estimacionesFases", estimacionFasesRequerimientoList);
		model.addAttribute("requerimiento", requerimiento);
		model.addAttribute("aplicaciones", aplicaciones);
		model.addAttribute("username",  auth.getName());
		return "requerimiento/form";
	}

	@GetMapping(value = "/cargar-fases/{termino}", produces = { "application/json" })
	public @ResponseBody List<FaseSimple> cargarFases(@PathVariable String termino) {
		if (termino.equals("*")) {
			return faseService.findFaseAll();
		}
		return faseService.findByDescripcion(termino);
	}

	//@PostMapping("/addEstimation")
	//public String agregarEstimacion(@ModelAttribute @RequestBody Requerimiento requerimiento) {
	//		requerimiento.getEstimacionRequerimientoFases().add(new EstimacionRequerimientoFase());
	//		return "requerimiento/form";
	//}

	/************************************/
	/******  @PostMapping("/form") ******/
	/************************************/
	@PostMapping("/form")
	public String guardar(@Valid @ModelAttribute Requerimiento requerimiento, BindingResult result, Model model,
						  @RequestParam(name = "fase_id[]", required = false) Long[] fases,
						  @RequestParam(name = "cantidad[]", required = false) Integer[] horasFase,
						  @RequestParam(name= "tipoRequerimiento") String tipoRequerimiento,
						  @RequestParam(name="namesEstimation[]") String[] nombresEstimaciones,
						  RedirectAttributes flash, SessionStatus status) {
		
		boolean existe;
		boolean modificacion = false;
		List<EstimacionRequerimientoFase> requerimientoFase = null;
		List<Aplicacion> aplicaciones = aplicacionService.findAll();
		List<Fase> fasesBD = faseService.findAll();
		List<String> listaFases = new ArrayList<>();
		List<Long> listaFasesId = new ArrayList<>();
		System.out.println("tipoRequerimiento: " + tipoRequerimiento);
		//for(Long fase : fases)
		//{
		//	System.out.println("FASES: " + listaFases.get(fase.intValue()));
		//}
		
		
		// Distinto de null es porque estamos haciendo una modificacion
		if (requerimiento.getId() != null) {
			modificacion = true;
		}
		
		
		if(result.hasErrors()) {
			if (modificacion) {
				model.addAttribute("titulo", "Editar Requerimiento");
			} else {
				model.addAttribute("titulo", "Alta Requerimiento");
			}
			model.addAttribute("aplicaciones", aplicaciones);
			model.addAttribute("fases", fasesBD);
			model.addAttribute("listaFases", listaFases);
			model.addAttribute("listaFasesId", listaFasesId);
			return "requerimiento/form";
		}
		
		//Valido que el requerimiento tenga al menos una fase
		if (fases == null || fases.length == 0) {
			if (modificacion) {
				model.addAttribute("titulo", "Editar Requerimiento");
			} else {
				model.addAttribute("titulo", "Alta Requerimiento");
			}
			model.addAttribute("error", "Error: El requerimiento debe tener al menos una fase!");
			model.addAttribute("aplicaciones", aplicaciones);
			model.addAttribute("fases", fasesBD);
			model.addAttribute("listaFases", listaFases);
			model.addAttribute("listaFasesId", listaFasesId);
			return "requerimiento/form";
		}
		
//		System.out.println("Requerimiento" + requerimiento.toString());
		/*
		if (modificacion) {
			System.out.println("Estoy ante una modificacion");
			requerimientoFase = requerimientoFaseService.findByRequerimientoId(requerimiento.getId());
		}
		
		
		//Agregamos las fases al requerimiento si no estan
		for (int i = 0; i < fases.length; i++) {
			log.info("ID: " + fases[i] + " Cantidad de Horas: " + horasFase[i]);
			
			//Si estamos editando
			if (modificacion) {
				existe = false;
				for (int j = 0; j < requerimientoFase.size(); j++) {
					//Si existe
					if (requerimientoFase.get(j).getRequerimientoFaseId().getFaseId() == (long)fases[i] ) {
						requerimiento.getRequerimientoFases().get(j).setCantidadHoras(horasFase[i]);
						existe = true;
					} 
				}
				if (!existe) {
					Fase fase = recuperarFase(fasesBD, fases[i]);
					requerimiento.addFase(fase, horasFase[i]);
				}
				
				
			} else {
				Fase fase = recuperarFase(fasesBD, fases[i]);
				requerimiento.addFase(fase, horasFase[i]);
			}
		}
		
		
		//Buscamos posibles fases eliminadas desde la vista
		//Si estamos editando
		
		if (modificacion) {
			for (int i = 0; i < requerimientoFase.size(); i++) {
				existe=false;
				for (int j = 0; j < fases.length; j++) {
					if (requerimientoFase.get(i).getRequerimientoFaseId().getFaseId() == (long)fases[j] ) {
						existe=true;
					}
				}
				if (!existe) {
					Fase fase = recuperarFase(fasesBD, fases[i]);
					requerimiento.removeFase(fase);
				}
			}
				
		}
		*/
		
		//Si no es modificacion incluimos el usuario que da de alta el requerimiento
		if (!modificacion) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			Usuario usuario = usuarioService.findByUsuario(auth.getName());
			System.err.println(usuario);
			requerimiento.setUsuario(usuario);
			//recorrer todas las fases con sus hs y las guarda en la tabla de relacion
		}
		
		System.out.println("Requerimiento" + requerimiento.toString());
		
		try {
			requerimientoService.save(requerimiento);
			if(!requerimiento.getEstimacionRequerimientoFases().isEmpty()) {

				//nombresEstimaciones
				Estimacion estimacion = new Estimacion();
				estimacion.setActivo(1);
				estimacion.setCantidadHoras(100);
				estimacion.setDescripcion((nombresEstimaciones.length == 0) ? "Estimacion" : nombresEstimaciones[0]);
				estimacion.setFecha(new Date());
				estimacion.setRequerimiento(requerimiento);
				for(int i=0; i <fases.length; i++ ) {
					Fase fase = faseService.findOne(fases[i]);
					EstimacionRequerimientoFase estimacionFase = new EstimacionRequerimientoFase();
					estimacionFase.setEstimacion(estimacion);
					estimacionFase.setRequerimiento(requerimiento);
					estimacionFase.setCantidadHoras(horasFase[i]);
					estimacionFase.setFase(fase);
					try {
						estimacionService.save(estimacion);
						requerimientoFaseService.save(estimacionFase);
					} catch (Exception e) {
						System.out.println("Exception: "+ e);
					}
				}
			}

		} catch (DataIntegrityViolationException e) {
			System.err.println("ERROR: " + e.toString());
			if (modificacion) {
				model.addAttribute("titulo", "Editar Requerimiento");
			} else {
				model.addAttribute("titulo", "Alta Requerimiento");
			}
			model.addAttribute("error", "Error: La combinación del Requerimiento mas la Descripción mas la aplicación ya existe!!!");
			model.addAttribute("aplicaciones", aplicaciones);
			model.addAttribute("fases", fasesBD);
			model.addAttribute("listaFases", listaFases);
			model.addAttribute("listaFasesId", listaFasesId);
			return "requerimiento/form";
		}
		
		status.setComplete();
		
		if (modificacion) {
			flash.addFlashAttribute("success","Requerimiento modificado con exito");
		}else {
			flash.addFlashAttribute("success","Requerimiento creado con exito");
		}

		return "redirect:listar-requerimientos";
	}
	
	@GetMapping("/editar/{id}")
	public String editarRequerimiento( @PathVariable(value="id") Long id, RedirectAttributes flash, Model model) {
		
		Requerimiento requerimiento = requerimientoService.findOne(id);
		List<Aplicacion> aplicaciones = aplicacionService.findAll();
		List<Fase> fases = faseService.findAll();
		
		model.addAttribute("titulo", "Editar Requerimiento");
		model.addAttribute("requerimiento", requerimiento);
		model.addAttribute("aplicaciones", aplicaciones);
		model.addAttribute("fases", fases);
		return "/requerimiento/editar";
	}
	
	
	/****************************************/
	/************* Utilidades ***************/
	/****************************************/
	public Fase recuperarFase(List<Fase> fases, Long id) {
		
		for (int i = 0; i < fases.size(); i++) {
			if (fases.get(i).getId() == id) {
				return fases.get(i);
			}
		}
		
		return null;
		
	}

}
