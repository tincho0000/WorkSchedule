package com.workschedule.app.enums;

public enum RequirementType {
    EVOLUTIVO("Evolutivo"),
    CORRECTIVO("Correctivo"),
    ANALISIS("Analisis"),
    REWORK("Rework");

    private final String value;

    private RequirementType(String value) {
        this.value = value;
    }

    public String getDisplayValue() {
        return value;
    }
}
