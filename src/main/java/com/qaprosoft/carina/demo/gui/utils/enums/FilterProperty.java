package com.qaprosoft.carina.demo.gui.utils.enums;

public enum FilterProperty {
    PRICE("Цена"),
    ROOM("Комнат");

    public final String fieldName;

    FilterProperty(String fieldName){
        this.fieldName = fieldName;
    }

    public String getFieldName(){
        return fieldName;
    }
}
