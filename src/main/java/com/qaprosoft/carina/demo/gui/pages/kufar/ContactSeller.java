package com.qaprosoft.carina.demo.gui.pages.kufar;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ContactSeller extends AbstractPage {
    public ContactSeller(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@id='sidebar-buttons']//button[text()='Написать']")
    private ExtendedWebElement writeToSeller;

    @FindBy(xpath = "//div[@id='sidebar-buttons']//button[text()='Позвонить']")
    private ExtendedWebElement callToSeller;

    public void clickWrite(){
        writeToSeller.click();
    }

    public void clickCall(){
        callToSeller.click();
    }
}
