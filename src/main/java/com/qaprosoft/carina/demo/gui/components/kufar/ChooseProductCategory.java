package com.qaprosoft.carina.demo.gui.components.kufar;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ChooseProductCategory extends AbstractPage {
    public ChooseProductCategory(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@data-name='megamenu']//button")
    private ExtendedWebElement categoryButton;

    @FindBy(xpath = "//div[@style='top:112px']//span[text()='Животные']")
    private ExtendedWebElement animalsButton;

    @FindBy(xpath = "//span[text()='Домашние питомцы']")
    private ExtendedWebElement petsButton;

    @FindBy(xpath = "//div[@data-name='get_listing']//span[text()='Показать результаты']")
    private ExtendedWebElement showResults;

    @FindBy(xpath = "//a[@target='_blank']//div[contains(text(),'Домашние питомцы')]")
    private List<CategoryItem> categorysItemList;

    public void clickAnimalsButton(){
        animalsButton.click();
    }

    public void clickPetsButtin(){
        petsButton.click();
    }

    public void clickShowResults(){
        showResults.click();
    }

    public void clickCategoryButton() {
        categoryButton.click();
    }

    public List<CategoryItem> CategoryItems(){ return categorysItemList;}


}
