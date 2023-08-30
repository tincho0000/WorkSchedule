package com.workschedule.app.models.dto;

import com.workschedule.app.models.entity.Estimacion;
import com.workschedule.app.models.entity.EstimacionRequerimientoFase;
import com.workschedule.app.models.entity.Requerimiento;

import java.util.List;

public class RequirementEstimationDTO {
    private Requerimiento requerimiento;

    private List<EstimacionRequerimientoFase> fasesProgramadas;

    public RequirementEstimationDTO() {

    }

    public Requerimiento getRequerimiento() {
        return requerimiento;
    }

    public void setRequerimiento(Requerimiento requerimiento) {
        this.requerimiento = requerimiento;
    }

    public List<EstimacionRequerimientoFase> getFasesProgramadas() {
        return fasesProgramadas;
    }

    public void setFasesProgramadas(List<EstimacionRequerimientoFase> fasesProgramadas) {
        this.fasesProgramadas = fasesProgramadas;
    }

}
