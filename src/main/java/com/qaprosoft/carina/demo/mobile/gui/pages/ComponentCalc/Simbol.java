package com.qaprosoft.carina.demo.mobile.gui.pages.ComponentCalc;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Simbol extends AbstractUIObject {
    @FindBy(id = "com.google.android.calculator:id/op_add")
    private ExtendedWebElement plus;

    @FindBy(id = "com.google.android.calculator:id/eq")
    private ExtendedWebElement equal;

    public Simbol(WebDriver driver){super(driver);}

    public void clickPlus() {
        plus.click();
    }
    public void clickEqual() {
        equal.click();
    }
}
