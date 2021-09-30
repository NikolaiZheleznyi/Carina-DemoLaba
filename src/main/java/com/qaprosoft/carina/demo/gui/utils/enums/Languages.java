package com.qaprosoft.carina.demo.gui.utils.enums;

public enum Languages {
    BLR("Беларуская"),
    RUS("Русский");

    public final String name;

    Languages(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
