package com.qaprosoft.carina.demo.mobile.gui.pages.yandexMapComponent;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Entrance extends AbstractUIObject {
    @FindBy(id ="ru.yandex.yandexmaps:id/onboarding_universal_skip")
    private ExtendedWebElement letsGoBtn;

    @FindBy(id ="ru.yandex.yandexmaps:id/control_zoom_in")
    private ExtendedWebElement plusBtn;

    @FindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private  ExtendedWebElement denyBtn;

    public Entrance(WebDriver driver){super(driver);}

    public void clickLetsGoBtn(){
        letsGoBtn.click();
    }
    public void clickPlusBtn(){
        plusBtn.click();
    }
    public void clickDenyBtn(){
        denyBtn.click();
    }
}
