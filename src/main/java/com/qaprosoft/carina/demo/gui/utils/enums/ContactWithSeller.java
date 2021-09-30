package com.qaprosoft.carina.demo.gui.utils.enums;

public enum ContactWithSeller {
    CALL(""),
    WRITE("");

    public final String contact;

    ContactWithSeller(String contact){
        this.contact = contact;
    }
    public String getContact(){
        return contact;
    }
}
