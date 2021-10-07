package com.qaprosoft.carina.demo.gui.utils.enums;

public enum NamePageTopMenu {
    CAR("Авто"),
    BUILDINGS("Недвижимость");

    public final String namePage;
    NamePageTopMenu(String namePage){
        this.namePage = namePage;
    }
    public String getNamePage(){
        return namePage;
    }

}
