package com.workschedule.app.DTO;

import com.workschedule.app.models.entity.PlanificacionEstimada;
import com.workschedule.app.models.entity.PlanificacionTarea;

import java.util.List;

public class PlanningTaskDTO {
    private PlanificacionEstimada planificacionEstimada = new PlanificacionEstimada();
    private List<PlanificacionTarea> taskList;

    // default and parameterized constructor

    public void addTask(PlanificacionTarea task) {
        this.taskList.add(task);
    }

    // getter and setter
}
