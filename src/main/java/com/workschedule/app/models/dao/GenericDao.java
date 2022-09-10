//package com.workschedule.app.models.dao;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//import javax.persistence.Tuple;
//
//import org.springframework.stereotype.Repository;
//
//import com.workschedule.app.models.entity.DetallePlanificacionFase;
//
//@Repository
//public class GenericDao implements IGenericDao{
//
//	private final EntityManager em;
//
//    public GenericDao(EntityManager em) {
//        this.em = em;
//    }
//    
//    public List<DetallePlanificacionFase> findAllWithTuples() {
//        Query nativeQuery = em.createNativeQuery("SELECT observacion, hora_planificada, hora_incurrida FROM planificacion", Tuple.class);
//        List<Tuple> tuples = nativeQuery.getResultList();
//        return tuples.stream()
//                .map(t -> new DetallePlanificacionFase(	t.get("observacion", String.class), t.get("hora_planificada", Integer.class), 
//                										t.get("hora_incurrida", Integer.class), t.get("hora_incurrida", Integer.class)))
//                .collect(Collectors.toList());
//    }
//}
