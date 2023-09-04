package com.workschedule.app.models.repository;

import com.workschedule.app.models.entity.Aplicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AplicacionRepository extends JpaRepository<Aplicacion, Long> {
}
