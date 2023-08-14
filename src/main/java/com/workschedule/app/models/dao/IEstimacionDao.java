package com.workschedule.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.workschedule.app.models.entity.Estimacion;

public interface IEstimacionDao extends PagingAndSortingRepository<Estimacion, Long>{

}
