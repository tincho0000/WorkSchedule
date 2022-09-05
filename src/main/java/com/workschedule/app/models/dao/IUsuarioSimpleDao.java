package com.workschedule.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.workschedule.app.models.entity.UsuarioSimple;

//Modifico la herencia para poder utilizar el paginado:
//public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
public interface IUsuarioSimpleDao extends CrudRepository<UsuarioSimple, Long> {

	@Query("select f from UsuarioSimple f where f.usuario like %?1%")
	public List<UsuarioSimple> findByUsuario(String usuario);
	
	@Query("select f from UsuarioSimple f")
	public List<UsuarioSimple> findUsuarioAll();

}
