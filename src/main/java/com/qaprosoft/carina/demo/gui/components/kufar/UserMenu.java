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

    @FindBy(xpath = "//span[text()='Отметить все как прочитанные']")
    private ExtendedWebElement getMyAds;

    @FindBy(xpath = "//span[text()='Мои сообщения']")
    private ExtendedWebElement myMesseges;

    @FindBy(xpath = "//div[contains(@class, 'popup_type_active')]//span[contains(@class, 'popup_type_info_close')]")
    private ExtendedWebElement closeInfoField;

    public void clickMyAds(){
        myAds.click();
    }

    public void clickMyMesseges(){
        myMesseges.click();
    }

    public void closeInfoField(){
        closeInfoField.click();
    }

    public String getTextAds(){
        return getMyAds.getText();
    }
}
