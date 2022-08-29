package com.timetracker.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.timetracker.app.models.entity.Fase;

public interface IFaseDao extends CrudRepository<Fase, Long>{

}
