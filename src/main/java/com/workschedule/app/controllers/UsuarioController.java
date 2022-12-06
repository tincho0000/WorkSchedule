package com.workschedule.app.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.workschedule.app.models.entity.Rol;
import com.workschedule.app.models.entity.Usuario;
import com.workschedule.app.models.service.IRolService;
import com.workschedule.app.models.service.IUploadFileService;
import com.workschedule.app.models.service.IUsuarioService;
import com.workschedule.app.models.view.Password;
import com.workschedule.app.util.paginator.PageRender;

@Controller
@SessionAttributes({"usuario", "password"})
@RequestMapping({"/app", "/"})
public class UsuarioController {

	protected final Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private IUsuarioService usuarioService;
	@Autowired
	private IUploadFileService uploadService;
	@Autowired
	private IRolService rolService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	//Se puede agregar una lista de roles
//	@Secured({"ROLE_GESTION", "ROLE_ADMIN"})
//	@GetMapping(value = "/ver/{id}")
//	public String ver(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {
//
//		Usuario usuario = usuarioService.findOne(id);
//		if (usuario == null) {
//			flash.addAttribute("error", "El cliente no existe en la BD");
//			return "redirect:/listar";
//		}
//
//		model.addAttribute("usuario", usuario);
//		model.addAttribute("titulo", "Detalle usuario: " + usuario.getUsuario());
//
//		return "usuario/ver";
//
//	}
	
	//Se puede agregar una lista de roles
		@Secured({"ROLE_USER", "ROLE_GESTION", "ROLE_ADMIN"})
		@GetMapping(value = "/ver/{username}")
		public String verPorUsuario(@PathVariable(value = "username") String username, Model model, RedirectAttributes flash) {

			Usuario usuario = usuarioService.findByUsuario(username);
			if (usuario == null) {
				flash.addFlashAttribute("error", "El usuario no existe en la BD");
//				flash.addAttribute("username", usuario.getUsuario());
				return "redirect:/app/listar/{username}";
			}
			
			model.addAttribute("usuario", usuario);
			model.addAttribute("titulo", "Detalle usuario: " + usuario.getUsuario());

			return "usuario/ver";

		}

//	@Secured("ROLE_GESTION")
	@GetMapping(value = "/uploads/{filename:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String filename) {

		Resource recurso = null;
		try {
			recurso = uploadService.load(filename);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"")
				.body(recurso);

	}
	
	
	@GetMapping({"/listar", "/"})
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model, Authentication authentication, HttpServletRequest request) {

//		System.out.println("-----------------");
//		Requerimiento req1 = requerimientoService.findOne((long) 1);
//		List<Requerimiento> req = requerimientoService.findAll();
//		List<RequerimientoFase> reqFase = null;
////		Fase fase = null;
//
//		for (Requerimiento requerimiento : req) {
//
//			System.out.println("---------------Inicio Objeto requerimiento------------ ");
//			System.out.println("getId " + requerimiento.getId());
//			System.out.println("getRequerimiento " + requerimiento.getRequerimiento());
//			System.out.println("getNombre " + requerimiento.getNombre());
//			System.out.println("getCantidadHoras " + requerimiento.getCantidadHoras());
//			System.out.println("getObservacion " + requerimiento.getObservacion());
//			System.out.println("getAplicacion " + requerimiento.getAplicacion().getNombre());
//
//			reqFase = requerimiento.getRequerimientoFases();
//
//			for (RequerimientoFase requerimientoFase : reqFase) {
//				System.out.println("-------Inicio fase----- ");
//				System.out
//						.println("	getRequerimientoFaseId: " + requerimientoFase.getRequerimientoFaseId().toString());
//				System.out.println("	Fase " + requerimientoFase.getFase().getDescripcion() + " horas: "
//						+ requerimientoFase.getCantidadHoras());
//				System.out.println("-------Fin fase----- "); 
//				
////				fase=requerimientoFase.getFase();
//				
//				requerimientoFase.setCantidadHoras(10);
//				
//			}
//
//			System.out.println("-----------------Fin Objeto requerimiento------------- ");
//			requerimiento.setObservacion("nada");
//			requerimientoService.save(requerimiento);
//
//		}
//		System.out.println("-----------------");
//		requerimientoService.delete((long) 7);
		
		
		/* altaaaaaaaaaaaaaaaaaaa de un requerimiento*/
//		Aplicacion aplicacion = new Aplicacion();
//		aplicacion.setId((long) 1);
//		aplicacion.setNombre("DEIMOS");
//		
//		Requerimiento nuevoReq = new Requerimiento();
//		nuevoReq.setCantidadHoras(1000);
//		nuevoReq.setNombre("DDDDDD");
//		nuevoReq.setObservacion("nada");
//		nuevoReq.setRequerimiento("MOR-999");
//		nuevoReq.setAplicacion(aplicacion);
//		Fase fase = faseService.findOne((long) 1);
//		System.out.println(fase.toString());
//		Fase fase2 = faseService.findOne((long) 2);
//		System.out.println(fase.toString());
//		Fase fase3 = faseService.findOne((long) 3);
//		System.out.println(fase.toString());
//		nuevoReq.addFase(fase, 19);
//		nuevoReq.addFase(fase2, 1);
//		nuevoReq.addFase(fase3, 9);
//		
//		requerimientoService.save(nuevoReq);
		
//		
//		RequerimientoFase reqFaseAlta = new RequerimientoFase();
//		reqFaseAlta.setCantidadHoras(15);
//		reqFaseAlta.setFase(fase);
//		
//		
//		Requerimiento nuevoReq = new Requerimiento();
//		nuevoReq.setCantidadHoras(1000);
//		nuevoReq.setNombre("DDDDDD");
//		nuevoReq.setObservacion("nose");
//		nuevoReq.setRequerimiento("MOR-999");
//		nuevoReq.setAplicacion(aplicacion);
//		nuevoReq.addRequerimientoFase(fase);
//		
//		requerimientoService.save(nuevoReq);
		
		
		//-----------------------------------------------------//
//		Aplicacion aplicacion = aplicacionService.findOne((long) 1);
//		
//		Requerimiento nuevoReq = new Requerimiento();
//		nuevoReq.setCantidadHoras(1000);
//		nuevoReq.setNombre("DDDDDD");
//		nuevoReq.setObservacion("nada");
//		nuevoReq.setRequerimiento("MOR-999");
//		nuevoReq.setAplicacion(aplicacion);
//		
////		Requerimiento nuevoReq = requerimientoService.findOne((long) 9);
//		Fase fase = faseService.findOne((long) 4);
//		
//		RequerimientoFase nuevoReqFase = new RequerimientoFase();
//		nuevoReqFase.setRequerimiento(nuevoReq);
//		nuevoReqFase.setFase(fase);
//		nuevoReqFase.setCantidadHoras(11);
//		nuevoReqFase.setRequerimientoFaseId(new RequerimientoFaseId());
//		
//		requerimientoFaseService.save(nuevoReqFase);
		
		////////Alta de relacion Usuario-Rol
//		Usuario u = usuarioService.findOne((long) 1);
//		Rol r =  rolService.findOne((long)1);
//		u.addrRol(r);
//		usuarioService.save(u);
		/////////remover usuario
//		System.err.println("------------------ini----------------------");
//		Usuario u = usuarioService.findOne((long) 3);
//		Rol r =  rolService.findOne((long)1);
//		u.removeRol(r);
//		usuarioService.delete(u.getId());
//		System.err.println("------------------fin----------------------");
		
		//--------------------------------------
		// Validando roles con Spring Security
		
		if (authentication != null) {
			logger.info("Hola... usuario autenticado, tu username es : ".concat(authentication.getName()));
		}
		
		//Otra forma de acceder al Authentication de forma estatica que nos permite poder usarla en cualquier lado de la app
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (auth != null) {
			logger.info("Hola (utilizando forma estatica)... usuario autenticado, tu username es : ".concat(auth.getName()));
		}
		
		if (hasRole("ROLE_ADMIN")) {
			logger.info("hola ".concat(auth.getName()).concat(" tienes acceso!!!") );
		} else {
			logger.info("hola ".concat(auth.getName()).concat(" NO tienes acceso!!!") );
		}
		
		// usando HttpServletRequest con SecurityContextHolderAwareRequestWrapper para obtener el rol. Lo q hace internamente es el codigo que tenemos antes de esto
		SecurityContextHolderAwareRequestWrapper securityContext = new SecurityContextHolderAwareRequestWrapper(request, "");
		if (securityContext.isUserInRole("ROLE_ADMIN")) {
			logger.info("Forma usando SecurityContextHolderAwareRequestWrapper. hola ".concat(auth.getName()).concat(" tienes acceso!!!") );
		} else {
			logger.info("Forma usando SecurityContextHolderAwareRequestWrapper. hola ".concat(auth.getName()).concat(" NO tienes acceso!!!") );
		}
		
		// otra forma
		if (request.isUserInRole("ROLE_ADMIN")) {
			logger.info("Forma usando request. hola ".concat(auth.getName()).concat(" tienes acceso!!!") );
		} else {
			logger.info("Forma usando request. hola ".concat(auth.getName()).concat(" NO tienes acceso!!!") );
		}
		
		// En definitiva tenemos 3 formas de validar el rol, la primera tenemos mas control y tenes mas ventajas para hacer ciertas cosas como logueo, ver todos los roles que tiene, etc.
		// la forma 2 o 3 es muy parecida
		

		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Usuario> usuarios = usuarioService.findAll(pageRequest);
		PageRender<Usuario> pageRender = new PageRender<>("/app/listar", usuarios);

		model.addAttribute("titulo", "Lista de Usuarios");
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("page", pageRender);
		return "usuario/listar";
	}

	@Secured("ROLE_ADMIN")
	@GetMapping(value = "/form")
	public String crear(Map<String, Object> model) {

		Usuario usuario = new Usuario();
		List<Rol> roles = rolService.findAll();
		model.put("usuario", usuario);
		model.put("roles", roles);
		model.put("titulo", "Alta de usuario");
		return "usuario/form";
	}

	@Secured("ROLE_ADMIN")
	@GetMapping(value = "/form/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Usuario usuario = null;
		if (id > 0) {

			usuario = usuarioService.findOne(id);
			if (usuario == null) {

				flash.addFlashAttribute("error", "El id del Usuario no puede ser cero!");
				return "redirect:listar";
			}

		} else {
			flash.addFlashAttribute("error", "El id del Usuario no existe en la BD!");
			return "redirect:listar";
		}
		
		List<Rol> roles = rolService.findAll();
		List<String> listaRoles = new ArrayList<>();
		List<Long> listaIdRoles = new ArrayList<>();
		List<String> listaRolesUsuario = new ArrayList<>();
		for (int i = 0; i < roles.size(); i++) {
			listaRoles.add(roles.get(i).getRol());
			listaIdRoles.add(roles.get(i).getId());
			System.out.println(roles.get(i).getId()+": " + roles.get(i).getRol() );
		}
		
		for (Rol rolesUsuario : usuario.getRoles()) {
			listaRolesUsuario.add(rolesUsuario.getRol());
			System.out.println("Roles usuario: " + rolesUsuario.getRol() );
		}
		

		model.put("roles", roles);
		model.put("usuario", usuario);
		model.put("titulo", "Editar usuario");
		model.put("listaRoles", listaRoles);
		model.put("listaRolesUsuario", listaRolesUsuario);
		model.put("listaIdRoles", listaIdRoles);
		return "usuario/form";
	}
	
	
	
	
	/******************************
	 * 			GUARDAR
	 * 
	 * @param usuario
	 * @param result
	 * @param model
	 * @param foto
	 * @param flash
	 * @param status
	 * @return
	 */
	

	@Secured("ROLE_ADMIN")
	@PostMapping(value = "/form")
	public String guardar(@Valid @ModelAttribute Usuario usuario, BindingResult result, Model model,
			@RequestParam(name = "file") MultipartFile foto, 
			@RequestParam(value = "rol", required = false ) Long[] roles ,
			RedirectAttributes flash, SessionStatus status) {

		boolean altaUsuario = false;
		boolean existe;
		Rol rol = null;
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de usuario");
			model.addAttribute("usuario", usuario);
			return "usuario/form";
		}

		if (!foto.isEmpty()) {

			if (usuario.getId() != null && usuario.getId() > 0 && usuario.getFoto() != null
					&& usuario.getFoto().length() > 0) {

				uploadService.delete(usuario.getFoto());

			}

			String uniqueFilename = null;
			try {
				uniqueFilename = uploadService.copy(foto);
			} catch (IOException e) {
				e.printStackTrace();
			}

			flash.addFlashAttribute("info", "Has subido correctamente '" + uniqueFilename + "'");

			usuario.setFoto(uniqueFilename);
		}
		
		if (usuario.getId() == null ) 
			altaUsuario = true;
		
		
		if (altaUsuario) {
			
			//Verifico si el usuario ya fue dado de alta
			Usuario usuarioUnico = usuarioService.findByUsuario(usuario.getUsuario());
			
			if (usuarioUnico != null) {
				
				Map<String,String> errores = new HashMap<>();
				errores.put("descripcion", "El usuario ya existe!!!");
				model.addAttribute("titulo", "Alta de usuario");
				model.addAttribute("usuario", usuario);
				model.addAttribute("errores", errores);
//				flash.addFlashAttribute("error", "El usuario '" + usuario.getUsuario() + "' ya existe!!!");
//				return "redirect:/app/form";
				return "usuario/form";
			}
			
		
			//encripto la password y lo marco como activo
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			usuario.setActivo(true);
			usuario.getDatoPersonal().setUsuario(usuario);
			
		} 
		
		
		//Si es alta y tiene roles los agrego
		if (altaUsuario && roles != null) {
			for (int i = 0; i < roles.length; i++) {
//				System.err.println("Rol:" + roles[i]);
				rol =  rolService.findOne(roles[i]);
				usuario.addrRol(rol);
			}
		}
		
		//Si estamos editando, verifico si hay que agregar o eliminar roles
		if (!altaUsuario) {
			
			//Agregamos los roles al usuario
			if (roles != null ) {
				
				for (int i = 0; i < roles.length; i++) {
					System.out.println("Roles: " + roles[i] );
					existe = false;
					
					for (Rol r : usuario.getRoles()) {
						if(r.getId().equals(roles[i])) {
							System.err.println("ENCONTREEEEEEEE");
							existe = true;
						}
					}
					
					if (!existe) {
						rol =  rolService.findOne(roles[i]);
						usuario.addrRol(rol);
					}
				}
			}
			
			
			// Eliminamos los roles
			List<Rol> rolesDelete = new ArrayList<>();
			if (roles == null ) {
				for (Rol r : usuario.getRoles()) {
					rolesDelete.add(r);
				}
			} else {
				for (Rol r : usuario.getRoles()) {
					existe = false;
					for (int i = 0; i < roles.length; i++) {
					
						if(r.getId().equals(roles[i])) {
							System.err.println("ENCONTREEEEEEEE");
							existe = true;
						}
					}
					if (!existe) {
						rolesDelete.add(r);
					}
				}
			}
		
			for (Rol rolDelete : rolesDelete) {
				usuario.removeRol(rolDelete);
			}
			
		}
		
		
		
//		Guardo usuario
		try {
			usuarioService.save(usuario);
			
		} catch (javax.persistence.RollbackException e) {
			System.err.println("Error de ConstraintViolationException: " + e.toString());
		} catch (Exception e) {
			System.err.println("Error generico: " + e.getMessage());
			System.err.println("Error generico: " + e.toString());
			System.err.println("Error generico: " + e.getLocalizedMessage());
			System.err.println("Error generico: " + e.getCause());
			System.err.println("Error getClass: " + e.getClass());
			System.err.println("Error getStackTrace: " + e.getStackTrace());
			System.err.println("Error getSuppressed: " + e.getSuppressed());
			e.printStackTrace();
			
			if (altaUsuario) {
				model.addAttribute("titulo", "Formulario de usuario");
				model.addAttribute("usuario", usuario);
				flash.addFlashAttribute("error", "Error en fecha de ingreso, no puede ser futura!");
				return "redirect:/app/form";
			} else {
				flash.addAttribute("id",usuario.getId());
				flash.addFlashAttribute("error", "Error en fecha de ingreso, no puede ser futura!");
				return "redirect:/app/form/{id}";
			} 
				
		}
		
		String mensaje = (altaUsuario) ? "Usuario creado con exito" : "Usuario editado con exito";
		status.setComplete();
		flash.addFlashAttribute("success", mensaje);
		return "redirect:listar";
	}

	//Otra forma de autorizar
//	@PreAuthorize("hasAnyRole('ROLE_GESTION', 'ROLE_ADMIN')")      PAra una lista de roles
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

		if (id > 0) {
			Usuario usuario = usuarioService.findOne(id);

			usuarioService.delete(id);
			flash.addFlashAttribute("success", "Usuario eliminado con exito");

			if (usuario.getFoto() != null) {
				
				if (uploadService.delete(usuario.getFoto())) {
					flash.addFlashAttribute("info", "Foto " + usuario.getFoto() + "eliminada con exito!");
				}
			}

		}

		return "redirect:/app/listar";
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping(value="/restablecer-contraseña/{username}")
	public String restablecerContraseña (@PathVariable(value="username") String username, Model model){
		
		Password password = new Password();
		password.setUsuario(username);
		model.addAttribute("titulo", "Restablecer Password");
		model.addAttribute("password", password);
		
		return "usuario/restablecer-contraseña";
	}
	
	@Secured("ROLE_ADMIN")
	@PostMapping(value="/restablecer-contraseña")
	public String guardarContraseña (@Valid @ModelAttribute Password password, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status){
		
		if (result.hasErrors()) {
			
			if (password.getPassword() != password.getConfirmPassword()) {
				model.addAttribute("errorPersonalizado", "Ambas password deben coincidir!!!");
			}
			model.addAttribute("titulo", "Restablecer Password");
			
			return "usuario/restablecer-contraseña";
		}
		
		Usuario usuario = usuarioService.findByUsuario(password.getUsuario());
		
		//Encripto la password
		usuario.setPassword(passwordEncoder.encode(password.getPassword()));
		
		usuarioService.save(usuario);
		status.setComplete();
		flash.addFlashAttribute("info", "Password restablecida con exito!");
		return "redirect:/app/ver/"+ password.getUsuario();
	}
	
	/*
	 * 
	 * 
	 * Utilidades
	 * 
	 * 
	 * 
	 */
	
	private boolean hasRole(String role) {
		SecurityContext context = SecurityContextHolder.getContext();
		if (context == null) {
			return false;
		}
		
		Authentication auth = context.getAuthentication();
		if (auth == null) {
			return false;
		}
		
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		
		/* Forma mas compleja pero sirve para recorrer y loguear si quisieramos sino usar la forma compact que esta a continuacion
		for(GrantedAuthority authority : authorities) {
			if (role.equals(authority.getAuthority())) {
				logger.info("hola usuario ".concat(auth.getName()).concat(" tu rol es: ").concat(authority.getAuthority()) );
				return true;
			}
		}
		
		return false;
		*/
		
		return authorities.contains(new SimpleGrantedAuthority(role));
		
	}
}
