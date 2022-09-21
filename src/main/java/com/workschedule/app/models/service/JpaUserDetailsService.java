package com.workschedule.app.models.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workschedule.app.models.dao.IUsuarioDao;
import com.workschedule.app.models.entity.Rol;
import com.workschedule.app.models.entity.Usuario;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService{

	@Autowired
	private IUsuarioDao usuarioDao;
	
	private Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class); 
	
	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioDao.findByUsuario(username);
		
		if (usuario == null) {
			logger.error("Error login: No existe el usuario '" + username + "'");
			throw new UsernameNotFoundException("Username " + username + " no existe enel sistema!");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(Rol rol : usuario.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(rol.getRol()));
		}
		
		if (authorities.isEmpty()) {
			logger.error("Error login: El usuario '" + username + "' no tiene roles asignados");
			throw new UsernameNotFoundException("Error login: El usuario '" + username + "' no tiene roles asignados");
		}
		
		return new User(usuario.getUsuario(), usuario.getPassword(), usuario.getActivo(), true, true, true, authorities);
	}
	
}
