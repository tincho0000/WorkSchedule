package com.timetracker.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.timetracker.app.models.entity.Aplicacion;

public interface IAplicacionDao extends PagingAndSortingRepository<Aplicacion, Long>{

}
