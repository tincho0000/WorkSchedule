package com.workschedule.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.workschedule.app.models.entity.Usuario;
import com.workschedule.app.models.entity.UsuarioSimple;

public interface IUsuarioService {

	public List<Usuario> findAll();

	public Page<Usuario> findAll(Pageable pageable);

	public void save(Usuario usuario);

	public Usuario findOne(Long id);

	public void delete(Long id);

	public Usuario findByUsuario(String username);
	
	public List<UsuarioSimple> findByUsuarioFiltro(String termino);
	public List<UsuarioSimple> findUsuarioAll();
}
