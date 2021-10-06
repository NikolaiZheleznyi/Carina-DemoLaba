package com.qaprosoft.carina.demo.gui.pages.kufar;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.LinkedList;
import java.util.List;

public class CitySelectionKufar extends AbstractPage {
    public CitySelectionKufar(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//select[@id='rgn']")
    private ExtendedWebElement district;

    @FindBy(xpath = "//select[@id='rgn']//option[text()='%s']")
    private ExtendedWebElement chooseDistrict;

    @FindBy(xpath = "//select[@id='ar']")
    private ExtendedWebElement city;

    @FindBy(xpath = "//select[@id='ar']//option[text()='%s']")
    private ExtendedWebElement chooseCity;

    @FindBy(xpath = "//div[@data-name='get_listing']//button[@type='submit']")
    private ExtendedWebElement searchBtn;

    @FindBy(xpath = "//button[@type='button']//span[text()='%s']")
    private ExtendedWebElement checkCity;

    public void clickDistrict(){
        district.click();
    }
    public void clickChooseDistrict(String district){
        chooseDistrict.format(district).click();
    }

    public void clickCity(){
        city.click();
    }

    public void clickChooseCity(String city){
        chooseCity.format(city).click();
    }

    public void clickSearchBtn(){
        searchBtn.click();
    }

    public String getTextCity(String city){
        return checkCity.format(city).getText();
    }

}
