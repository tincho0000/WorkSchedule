package com.timetracker.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.timetracker.app.models.entity.Usuario;

//Modifico la herencia para poder utilizar el paginado:
//public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
public interface IUsuarioDao extends PagingAndSortingRepository<Usuario, Long> {

//	public List<Usuario> findAll();
//	public void save(Usuario usuario);
//	public Usuario findOne(Long id);
//	public void delete(Long id);
	
	public Usuario findByUsuario(String usuario);

}
