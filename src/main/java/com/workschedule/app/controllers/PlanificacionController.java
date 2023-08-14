//package com.workschedule.app.controllers;
//
//import java.beans.PropertyEditorSupport;
//import java.time.DayOfWeek;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.workschedule.app.models.entity.Aplicacion;
//import com.workschedule.app.models.entity.Planificacion;
//import com.workschedule.app.models.entity.Requerimiento;
//import com.workschedule.app.models.entity.RequerimientoSimple;
//import com.workschedule.app.models.entity.Usuario;
//import com.workschedule.app.models.entity.UsuarioSimple;
//import com.workschedule.app.models.service.IAplicacionService;
//import com.workschedule.app.models.service.IPlanificacionService;
//import com.workschedule.app.models.service.IRequerimientoFaseService;
//import com.workschedule.app.models.service.IRequerimientoService;
//import com.workschedule.app.models.service.IUsuarioService;
//
//@RequestMapping("/planificacion")
//@Controller
//public class PlanificacionController {
//
//	@Autowired
//	IPlanificacionService planificacionService;
//	@Autowired
//	IRequerimientoFaseService requerimientoFaseService;
//	@Autowired
//	IRequerimientoService requerimientoService;
//	@Autowired
//	IUsuarioService usuarioService;
//	@Autowired
//	IUsuarioService usuarioSimpleService;
//	@Autowired
//	IAplicacionService aplicacionService;
////	@Autowired
////	IGenericDao genericDao;
//	
//
//	// Agrego al initBinder
////	@InitBinder
////	public void initBinder(WebDataBinder binder) throws Exception {
////	    final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
////	    final CustomDateEditor dateEditor = new CustomDateEditor(df, true) {
////	        @Override
////	        public void setAsText(String text) throws IllegalArgumentException {
////	            if ("today".equals(text)) {
////	                setValue(LocalDate.now());
////	            } else {
////	                super.setAsText(text);
////	            }
////	        }
////	    };
////	    binder.registerCustomEditor(LocalDate.class, dateEditor);
////	}
//
////	Agrego al initBinder para que si no informan la fecha tome la del dia
//	@InitBinder
//	protected void initBinder(WebDataBinder binder) {
//		binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
//			public void setAsText(String text) throws IllegalArgumentException {
//				if ("today".equals(text)) {
//
//					LocalDate localDate = LocalDate.now();// For reference
//					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//					String formattedString = localDate.format(formatter);
//					setValue(LocalDate.parse(formattedString, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//				
//				} else {
//					setValue(LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//				}
//
//			}
//
//			public String getAsText() throws IllegalArgumentException {
//				return DateTimeFormatter.ofPattern("yyyy-MM-dd").format((LocalDate) getValue());
//			}
//		});
//	}
//
//	/*
//	 * 
//	 * 
//	 * @GetMapping("/listar")
//	 * 
//	 * 
//	 */
//	@Secured({ "ROLE_GESTION", "ROLE_ADMIN" })
//	@GetMapping("/listar")
//	public String listar(Model model, @RequestParam(name = "usuarioFilter", defaultValue = "") String usuarioFilter,
//			@RequestParam(name = "fechaFilter", defaultValue = "today") LocalDate fechaFilter) {
//
//		// modif y delete
////		Planificacion planificacion = planificacionService.findOne((long) 1);
////		planificacion.setHorasIncurridas(100);
////		planificacionService.save(planificacion);
////		planificacionService.delete((long) 2);
//
//		// Alta
//		/*
//		  Planificacion planificacion = new Planificacion(); RequerimientoFaseId rFId =
//		  new RequerimientoFaseId(); rFId.setFaseId((long) 1);
//		  rFId.setRequerimientoId((long) 1); 
//		  RequerimientoFase rF = requerimientoFaseService.findOne(rFId); 
//		  Usuario u = usuarioService.findByUsuario("martin"); planificacion.setFecha(LocalDate.now());
//		  planificacion.setHorasIncurridas(5); planificacion.setHorasPlanificadas(5);
//		  planificacion.setObservacion("dshfnkahn");
//		  planificacion.setRequerimientoFases(rF); planificacion.setUsuario(u);
//		  planificacionService.save(planificacion);
//		 */
//
////		boolean sinFiltros = false;
//		List<Planificacion> planificaciones = new ArrayList<>();
//		
//		List<Planificacion> lunes = new ArrayList<>();
//		List<Planificacion> martes = new ArrayList<>();
//		List<Planificacion> miercoles = new ArrayList<>();
//		List<Planificacion> jueves = new ArrayList<>();
//		List<Planificacion> viernes = new ArrayList<>();
//
//		if (usuarioFilter.isEmpty() /* && fechaFilter.isEmpty() */) {
//			System.out.println("VACIO");
//			System.out.println("fechaFilter: " + fechaFilter);
////			sinFiltros = true;
//			
//			//Obtengo el nombre de usuario
//			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//			
//			if (auth != null) {
//				usuarioFilter = auth.getName();
//			}
//		} 
//		
//
//		System.out.println("usuarioFilter: " + usuarioFilter);
//		System.out.println("fechaFilter: " + fechaFilter);
//
//		LocalDate desde = fechaFilter.with(DayOfWeek.MONDAY);
//		LocalDate hasta = fechaFilter.with(DayOfWeek.FRIDAY);
//		
//		System.out.println("Primer dia de la semana ==> " + desde);
//		System.out.println("Primer dia de la semana ==> " + hasta);
//		
//		Usuario usuario = usuarioService.findByUsuario(usuarioFilter);
//		
//		//Verifico si el usuario existe y sino retorno a la vista notificandolo
//		if (usuario != null) {
//			Long usuarioBuscado = usuario.getId();
//			planificaciones = planificacionService.findByUsuarioIdAndFechaBetween(usuarioBuscado , desde, hasta);
//			
//		} else {
//			System.err.println("Usuario desconocido ");
//			
//			Map<String,String> informar = new HashMap<>();
//			informar.put("descripcion", "Usuario NO existente!");
//			
//			model.addAttribute("informar", informar);
//			model.addAttribute("titulo", "Planificación");
//			model.addAttribute("fechaFilter", fechaFilter);
//			model.addAttribute("usuarioFilter", usuarioFilter);
//			model.addAttribute("planificaciones", planificaciones);
//
//			return "planificacion/listar-planificacion";
//		}
//		
//		
//		for (Planificacion planificacion : planificaciones) {
////			System.out.println("Planif: " + planificacion.getId() + "fechaP: " + planificacion.getFecha() + "filtro: " + fechaFilter.with(DayOfWeek.MONDAY));
//			
//			if (planificacion.getFecha().equals(fechaFilter.with(DayOfWeek.MONDAY))) {
//				lunes.add(planificacion);
//			} else if (planificacion.getFecha().equals(fechaFilter.with(DayOfWeek.TUESDAY))){
//				martes.add(planificacion);
//			} else if (planificacion.getFecha().equals(fechaFilter.with(DayOfWeek.WEDNESDAY))){
//				miercoles.add(planificacion);
//			} else if (planificacion.getFecha().equals(fechaFilter.with(DayOfWeek.THURSDAY))){
//				jueves.add(planificacion);
//			} else if (planificacion.getFecha().equals(fechaFilter.with(DayOfWeek.FRIDAY))){
//				viernes.add(planificacion);
//			}
//		}
//		
//		
//		model.addAttribute("titulo", "Planificación");
//		model.addAttribute("fechaFilter", fechaFilter);
//		model.addAttribute("usuarioFilter", usuarioFilter);
//		model.addAttribute("lunes", lunes);
//		model.addAttribute("martes", martes);
//		model.addAttribute("miercoles", miercoles);
//		model.addAttribute("jueves", jueves);
//		model.addAttribute("viernes", viernes);
//
//		return "planificacion/listar-planificacion";
//	}
//	
//	
//	@GetMapping(value = "/cargar-usuarios/{termino}", produces = { "application/json" })
//	public @ResponseBody List<UsuarioSimple> cargarFases(@PathVariable String termino) {
//		if (termino.equals("*")) {
//			return usuarioSimpleService.findUsuarioAll();
//		}
//		return usuarioSimpleService.findByUsuarioFiltro(termino);
//	}
//	
//	@GetMapping(value = "/cargar-requerimientos/{termino}", produces = { "application/json" })
//	public @ResponseBody List<RequerimientoSimple> cargarRequerimientos(@PathVariable String termino) {
//		
//		if (termino.equals("*")) {
//			return requerimientoService.findByRequerimientos();
//		}
////		return requerimientoService.findByUsuarioFiltro(termino);
//		return requerimientoService.findByRequerimientoContaining(termino);
//	}
//	
//	
//	
//	@GetMapping("/planificar")
//	public String planificar(Model model, 	@RequestParam(name = "fecha") LocalDate fecha, 
//											@RequestParam(name = "usuario") String usuario,
//											@RequestParam(name = "appFilter", required = false) String appFilter,
//											@RequestParam(name = "reqFilter", required = false) String reqFilter) {
//		
//		System.err.println("fechaFilter: " + fecha);
//		System.err.println("reqFilter: " + reqFilter);
//		System.err.println("fecha: " + fecha);
//		System.err.println("usuario: " + usuario);
//		
//		boolean obtenerPlanificacion = true;
//		
//		List<Aplicacion> aplicaciones = aplicacionService.findAll();
//		Requerimiento requerimiento = new Requerimiento();
////		DetallePlanificacion detallePlanificacion = new DetallePlanificacion();
//		
//		//Valido parametro sea distinto de null o vacio
//		if (reqFilter != null && !("").equals(reqFilter)) {
//			requerimiento = requerimientoService.findByRequerimiento(reqFilter);
//		}
//		
//		//Si no trajo nada la consulta inicializo requerimiento para que no explote la vista
//		if (requerimiento == null) {
//			requerimiento = new Requerimiento();
//			obtenerPlanificacion = false;
//		}
//		
//		//Verifico si cuento con todos los parametos con valores para armar el objeto de "DetallePlanificacion" 
//		if (fecha != null && usuario != null && !("").equals(usuario) && appFilter != null && 
//				!("").equals(appFilter) && reqFilter != null && !("").equals(reqFilter)) {
//			obtenerPlanificacion = true;
//		}else {
//			obtenerPlanificacion = false;
//		}
//		
//		
////		if (obtenerPlanificacion) {
////			detallePlanificacion = planificacionService.obtenerPlanificacion(usuario, fecha, appFilter, reqFilter);
////		}
//		
////		List<DetallePlanificacionFase> lista = genericDao.findAllWithTuples();
////		
////		for (DetallePlanificacionFase detallePlanificacionFase : lista) {
////			System.err.println(detallePlanificacionFase.getFase());
////		}
//		
//		
//		model.addAttribute("titulo", "Alta de Planificación");
//		model.addAttribute("fecha", fecha);
//		model.addAttribute("usuario", usuario);
//		model.addAttribute("appFilter", appFilter);
//		model.addAttribute("reqFilter", reqFilter);
//		model.addAttribute("aplicaciones", aplicaciones);
//		model.addAttribute("requerimiento", requerimiento);
////		model.addAttribute("detallePlanificacion", detallePlanificacion);
//		return "planificacion/alta-planificacion";
//		
//	}
//}
