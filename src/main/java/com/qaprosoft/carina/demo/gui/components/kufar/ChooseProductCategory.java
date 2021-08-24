package com.qaprosoft.carina.demo.gui.components.kufar;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ChooseProductCategory extends AbstractPage {
    public ChooseProductCategory(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='mm-aK-742a5']//a[@data-id='21000']")
    private ExtendedWebElement furnitureCategory;

    @FindBy(xpath = "//span[text()='Стулья']")
    private ExtendedWebElement chairCategory;

    @FindBy(xpath = "//div[@data-name='get_listing']//span[text()='Показать результаты']")
    private ExtendedWebElement showResults;

    public void clickFurnitureCategory(){
        furnitureCategory.click();
    }

    public void clickChairCategory(){
        chairCategory.click();
    }

    public void clickShowResults(){
        showResults.click();
    }
}
