package com.qaprosoft.carina.demo.gui.components.kufar;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginBlock extends AbstractPage {
    public LoginBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='E-mail']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//input[@placeholder='Пароль']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//div[@data-name='login_submit']//button[@type='submit']")
    private ExtendedWebElement authoButton;

    public void inputEmail(String e){
        emailField.click();
        emailField.type(e);
    }

    public void inputPassword(String p){
        passwordField.click();
        passwordField.type(p);
    }

    public void authoButton(){
        authoButton.click();
    }
}

