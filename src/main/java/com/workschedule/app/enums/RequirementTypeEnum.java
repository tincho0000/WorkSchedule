package com.workschedule.app.enums;

public enum RequirementTypeEnum {
    EVOLUTIVO("Evolutivo"),
    CORRECTIVO("Correctivo"),
    ANALISIS("Analisis"),
    REWORK("Rework");

    private final String value;

    private RequirementTypeEnum(String value) {
        this.value = value;
    }

    public String getDisplayValue() {
        return value;
    }
}
