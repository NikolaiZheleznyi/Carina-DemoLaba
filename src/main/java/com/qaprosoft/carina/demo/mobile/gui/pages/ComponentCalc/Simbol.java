package com.qaprosoft.carina.demo.mobile.gui.pages.componentCalc;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Simbol extends AbstractUIObject {

    @FindBy(id = "com.google.android.calculator:id/eq")
    private ExtendedWebElement equal;

    @FindBy(id = "com.google.android.calculator:id/op_add")
    private ExtendedWebElement plus;

    @FindBy(id = "com.google.android.calculator:id/op_sub")
    private ExtendedWebElement minus;

    @FindBy(id = "com.google.android.calculator:id/op_div")
    private ExtendedWebElement divied;

    @FindBy(id = "com.google.android.calculator:id/op_mul")
    private ExtendedWebElement multiply;

    @FindBy(id = "com.google.android.calculator:id/del")
    private ExtendedWebElement delete;

    public Simbol(WebDriver driver){super(driver);}

    public void clickPlus() {
        plus.click();
    }
    public void clickEqual() {
        equal.click();
    }
    public void clickMinus() {
        minus.click();
    }
    public void clickDivied() {
        divied.click();
    }
    public void clickMultiply() {
        multiply.click();
    }
    public void clickDelete() {
        delete.click();
    }
}
