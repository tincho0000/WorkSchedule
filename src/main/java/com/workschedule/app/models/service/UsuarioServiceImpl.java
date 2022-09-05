package com.workschedule.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workschedule.app.models.dao.IUsuarioDao;
import com.workschedule.app.models.dao.IUsuarioSimpleDao;
import com.workschedule.app.models.entity.Usuario;
import com.workschedule.app.models.entity.UsuarioSimple;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDao usuarioDao;
	@Autowired
	private IUsuarioSimpleDao usuarioSimpleDao;

	@Transactional(readOnly = true)
	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Page<Usuario> findAll(Pageable pageable) {
		return usuarioDao.findAll(pageable);
	}

	@Transactional(readOnly = true)
	@Override
	public Usuario findOne(Long id) {
//		return usuarioDao.findOne(id);
		return usuarioDao.findById(id).orElseGet(null);
	}
	
	@Transactional(readOnly = true)
	@Override
	public Usuario findByUsuario(String username) {
//		return usuarioDao.findOne(id);
		return usuarioDao.findByUsuario(username);
	}

	@Transactional
	@Override
	public void save(Usuario usuario) {
		usuarioDao.save(usuario);
	}

	@Transactional
	@Override
	public void delete(Long id) {
//		usuarioDao.delete(id);
		usuarioDao.deleteById(id);

	}

	@Override
	public List<UsuarioSimple> findByUsuarioFiltro(String termino) {
		return usuarioSimpleDao.findByUsuario(termino);
	}

	@Override
	public List<UsuarioSimple> findUsuarioAll() {
		return usuarioSimpleDao.findUsuarioAll();
	}

}
