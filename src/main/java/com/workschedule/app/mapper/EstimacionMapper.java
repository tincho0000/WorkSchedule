package com.workschedule.app.mapper;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.workschedule.app.dto.EstimationDTO;
import com.workschedule.app.enums.Fase;
import com.workschedule.app.models.entity.Estimacion;
import com.workschedule.app.models.entity.Requerimiento;

public class EstimacionMapper {
    public Estimacion convert(EstimationDTO source, Requerimiento req) {

        Estimacion estimacion = new Estimacion();

        estimacion.setActivo(source.getActivo());
        estimacion.setFase(Fase.fromString(source.getFase()));
        estimacion.setCantidadHoras(source.getCantidadHoras());
        estimacion.setUsuarioAlta(source.getUsuarioAlta());
        estimacion.setVersion(source.getVersion());
        estimacion.setRequerimiento(req);
        return estimacion;
    }
}

