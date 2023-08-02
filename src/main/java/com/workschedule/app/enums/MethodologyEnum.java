package com.workschedule.app.enums;

public enum MethodologyEnum {
    WATERFALL("Waterfall"),
    AGILE("Agile"),
    HIBRID("Hibrid");

    private final String value;

    private MethodologyEnum(String value) {
        this.value = value;
    }

    public String getDisplayValue() {
        return value;
    }
}
