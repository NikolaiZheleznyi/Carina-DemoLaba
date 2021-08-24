package com.qaprosoft.carina.demo.gui.components.kufar;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LogOut extends AbstractPage {
    public LogOut(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//button[@data-name='profile_menu_logout_link']//span[text()='Выход']")
    private ExtendedWebElement exitAccount;

    public void clickExitAccount(){
        exitAccount.click();
    }
}
