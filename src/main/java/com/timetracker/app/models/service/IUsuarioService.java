package com.timetracker.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.timetracker.app.models.entity.Usuario;

public interface IUsuarioService {

	public List<Usuario> findAll();

	public Page<Usuario> findAll(Pageable pageable);

	public void save(Usuario usuario);

	public Usuario findOne(Long id);

	public void delete(Long id);

	public Usuario findByUsuario(String username);
}
