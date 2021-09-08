package com.qaprosoft.carina.demo.mobile.gui.pages.YandexMapPage;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.Executable;

public class BeautyPage extends AbstractUIObject {
    @FindBy(xpath = "//android.widget.TextView[@text='Manicure']")
    private ExtendedWebElement manicureField;

    public BeautyPage(WebDriver driver) {
        super(driver);
    }
    public String getTextManicureField(){
        return manicureField.getText();
    }
}
