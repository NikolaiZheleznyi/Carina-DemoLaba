package com.qaprosoft.carina.demo.gui.utils.enums;

public enum ProfileMenu {
    ADS("Мои объявления"),
    MESSEGES("Мои сообщения"),
    GETADS("Отметить все как прочитанные");

    public final String messAds;
    ProfileMenu(String messAds){
        this.messAds = messAds;
    }
    public String getMessAds(){
        return messAds;
    }
}
