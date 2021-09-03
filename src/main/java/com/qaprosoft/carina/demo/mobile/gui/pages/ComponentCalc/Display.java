package com.qaprosoft.carina.demo.mobile.gui.pages.ComponentCalc;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Display extends AbstractUIObject {

    @FindBy(id = "com.google.android.calculator:id/result_final")
    private ExtendedWebElement field;

    public Display(WebDriver driver){super(driver);}

    public String getResultField(){
        return field.getText();
    }
}
