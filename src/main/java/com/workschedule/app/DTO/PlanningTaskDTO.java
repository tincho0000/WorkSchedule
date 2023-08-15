package com.workschedule.app.DTO;

import com.workschedule.app.models.entity.PlanificacionEstimada;
import com.workschedule.app.models.entity.EstimacionTarea;

import java.util.List;

public class PlanningTaskDTO {
    private PlanificacionEstimada planificacionEstimada = new PlanificacionEstimada();
    private List<EstimacionTarea> taskList;

    // default and parameterized constructor

    public void addTask(EstimacionTarea task) {
        this.taskList.add(task);
    }

    // getter and setter
}
