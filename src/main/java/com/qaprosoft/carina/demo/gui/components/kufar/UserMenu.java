package com.qaprosoft.carina.demo.gui.components.kufar;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class UserMenu extends AbstractPage {
    public UserMenu(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[text()='Мои объявления']")
    private ExtendedWebElement myAds;

    @FindBy(xpath = "//span[text()='Мои сообщения']")
    private ExtendedWebElement myMesseges;

    public void clickMyAds(){
        myAds.click();
    }

    public void clickMyMesseges(){
        myMesseges.click();
    }
}
