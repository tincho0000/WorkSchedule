package com.workschedule.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.workschedule.app.models.entity.Aplicacion;

public interface IAplicacionDao extends PagingAndSortingRepository<Aplicacion, Long>{

}
