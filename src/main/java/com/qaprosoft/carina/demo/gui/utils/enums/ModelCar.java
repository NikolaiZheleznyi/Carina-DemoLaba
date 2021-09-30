package com.qaprosoft.carina.demo.gui.utils.enums;

public enum ModelCar {
    AUDI("Audi"),
    BMW ("BMW"),
    CITROEN ("Citroen"),
    FIAT ("Fiat"),
    FORD ("Ford"),
    HONDA("Honda"),
    HYUNDAI("Hyundai"),
    KIA("Kia"),
    LADA("LADA (ВАЗ)"),
    MAZDA("Mazda"),
    MERCEDES("Mercedes-Benz"),
    MITSUBISHI("Mitsubishi"),
    NISSAN("Nissan"),
    OPEL("Opel"),
    PEUGEO("Peugeot"),
    RENO("Renault"),
    SHKODA("Skoda"),
    TOYOTA("Toyota"),
    VW("Volkswagen"),
    VOLVO("Volvo");

    public final String model;
    ModelCar(String model){
        this.model = model;
    }
    public String getModel(){
        return model;
    }
}
