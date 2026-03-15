package com.yoot.clinic.common.enums;

public enum MedicalCategory {
    DONG_Y("Đông y"),
    TAY_Y("Tây y"),
    KHAC("Khác");


    private final String displayName;

    MedicalCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
