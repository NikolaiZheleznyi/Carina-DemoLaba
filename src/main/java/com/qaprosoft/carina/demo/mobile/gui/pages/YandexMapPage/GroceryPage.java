package com.qaprosoft.carina.demo.mobile.gui.pages.YandexMapPage;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GroceryPage extends AbstractUIObject {

    @FindBy(xpath = "//android.widget.TextView[@text='Food delivery']")
    private ExtendedWebElement foodDeliveryField;
    public GroceryPage(WebDriver driver) {
        super(driver);
    }
    public String getTextFoodDelivery(){
        return foodDeliveryField.getText();
    }
}
