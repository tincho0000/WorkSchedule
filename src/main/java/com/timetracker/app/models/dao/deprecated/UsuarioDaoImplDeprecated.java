package com.timetracker.app.models.dao.deprecated;

//package com.timetracker.app.models.dao;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import org.springframework.stereotype.Repository;
//
//import com.timetracker.app.models.entity.Usuario;
//
//@Repository("usuarioDaoJpa")
//public class UsuarioDaoImpl implements IUsuarioDao {
//
//	@PersistenceContext
//	private EntityManager em;
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Usuario> findAll() {
//		// TODO Auto-generated method stub
//		return em.createQuery("from Usuario").getResultList();
//	}
//
//	@Override
//	public Usuario findOne(Long id) {
//		return em.find(Usuario.class, id);
//	}
//
//	@Override
//	public void save(Usuario usuario) {
//		if (usuario.getId() != null && usuario.getId() > 0) {
//			em.merge(usuario);
//		} else {
//			em.persist(usuario);
//		}
//	}
//
//	@Override
//	public void delete(Long id) {
//		em.remove(findOne(id));
//	}
//
//}
