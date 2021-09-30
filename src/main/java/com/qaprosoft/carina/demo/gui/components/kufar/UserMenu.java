package com.qaprosoft.carina.demo.gui.components.kufar;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class UserMenu extends AbstractPage {
    public UserMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='%s']")
    private ExtendedWebElement profileMenu;

    @FindBy(xpath = "//div[contains(@class, 'popup_type_active')]//span[contains(@class, 'popup_type_info_close')]")
    private ExtendedWebElement closeInfoField;

    public void clickMyAds(String messAds){
        profileMenu.format(messAds).click();
    }

    public void clickMyMesseges(String messAds){
        profileMenu.format(messAds).click();
    }

    public void closeInfoField(){
        closeInfoField.click();
    }

    public String getTextAds(String messAds){
        return profileMenu.format(messAds).getText();
    }
}
