package com.qaprosoft.carina.demo.gui.pages.kufar;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.LinkedList;
import java.util.List;

public class AutoKufarPage extends AbstractPage {
    public AutoKufarPage(WebDriver driver){super(driver);}
    @FindBy(xpath = "//a[@data-name='header-generalist-to-auto']")
    private ExtendedWebElement autoBtn;

    @FindBy(xpath = "//section[@data-cy='auto-section-popular-brands']//span[text()='Mercedes-Benz']")
    private ExtendedWebElement mercedesBtn;

    @FindBy(xpath = "//span[text()='E-Класс']")
    private ExtendedWebElement eClassBtn;

    @FindBy(xpath = "//div[@data-cy='auto-listing-block']//a//h3")
    private List<ExtendedWebElement> fieldCarNames;

    @FindBy(xpath = "//div[@class='swiper-wrapper']//a[@data-name='Запчасти, расходники']")
    private ExtendedWebElement sparesTopMenu;

    @FindBy(xpath = "//section[@id='listings_content']//span[text()='Mercedes-Benz']")
    private ExtendedWebElement sparesForMercedes;

    @FindBy(xpath = "//div[contains(text(),'Запчасти для легковых авто')]")
    private List<ExtendedWebElement> listFieldSparesItems;

    public void clickAutoBtn(){
        autoBtn.click();
    }
    public void clickMercedesBtn(){
        mercedesBtn.click();
    }
    public void clickEClassBtn(){
        eClassBtn.click();
    }

    public List<String> getTextFieldItemsName(){
        List<String> names = new LinkedList<>();
        for(ExtendedWebElement carLabel : fieldCarNames) {
            names.add(carLabel.getText());
        }
        return names;
    }

    public void clickSparesTopMenu(){
        sparesTopMenu.click();
    }
    public void clickSparesForMercedes(){
        sparesForMercedes.click();
    }

    public List<String> getListFieldSparesItems(){
        List<String> nameSpares = new LinkedList<>();
        for(ExtendedWebElement spareName : listFieldSparesItems){
            nameSpares.add(spareName.getText());
        }
        return nameSpares;
    }
}
