package com.workschedule.app.mapper;

import com.workschedule.app.dto.EstimationDTO;
import com.workschedule.app.enums.Fase;
import com.workschedule.app.models.entity.Estimacion;
import com.workschedule.app.models.entity.Requerimiento;
import java.util.Date;

public class EstimacionMapper {
    public Estimacion convert(EstimationDTO source, Requerimiento req) {

        Estimacion estimacion = new Estimacion();

        estimacion.setActivo(source.getActivo());
        estimacion.setFase(Fase.fromString(source.getFase()));
        estimacion.setCantidadHoras(source.getCantidadHoras());
        estimacion.setUsuarioAlta(source.getUsuarioAlta());
        estimacion.setFechaAlta(new Date());
        estimacion.setFechaUpdate(source.getFechaUpdate());
        estimacion.setVersion(source.getVersion());
        estimacion.setRequerimiento(req);
        return estimacion;
    }

    public Estimacion convertUpdate(EstimationDTO source, Requerimiento req, String usuarioUpdate, Requerimiento requerimientoOriginal) {

        Estimacion estimacion = new Estimacion();
        requerimientoOriginal.getEstimacion().stream().forEach(estimation -> {
        if(estimation.getVersion() == source.getVersion() && estimation.getFase().name().equals(source.getFase())  ){
            estimacion.setId(estimation.getId());
        }
        });
        estimacion.setActivo(source.getActivo());
        estimacion.setFase(Fase.fromString(source.getFase()));
        estimacion.setCantidadHoras(source.getCantidadHoras());
        estimacion.setUsuarioAlta(source.getUsuarioAlta());
        estimacion.setFechaUpdate(new Date());
        estimacion.setUsuarioUpdate(usuarioUpdate);
        estimacion.setVersion(source.getVersion());
        estimacion.setRequerimiento(req);
        return estimacion;
    }
}

