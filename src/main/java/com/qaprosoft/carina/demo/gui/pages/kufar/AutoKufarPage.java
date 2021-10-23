package com.qaprosoft.carina.demo.gui.pages.kufar;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.kufar.FileReadSparesKufar;
import com.qaprosoft.carina.demo.gui.utils.enums.ModelCar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.LinkedList;
import java.util.List;

public class AutoKufarPage extends AbstractPage {
    public AutoKufarPage(WebDriver driver){super(driver);}
    @FindBy(xpath = "//a[@data-name='header-generalist-to-auto']")
    private ExtendedWebElement autoBtn;

    @FindBy(xpath = "//span[text()='%s']")
    private ExtendedWebElement namePageAuto;

    @FindBy(xpath = "//section[@data-cy='auto-section-popular-brands']//span[text()='%s']")
    private ExtendedWebElement mercedesBtn;

    @FindBy(xpath = "//span[text()='E-Класс']")
    private ExtendedWebElement eClassBtn;

    @FindBy(xpath = "//div[@data-cy='auto-listing-block']//a//h3")
    private List<ExtendedWebElement> fieldCarNames;

    @FindBy(xpath = "//div[@class='swiper-wrapper']//a[@data-name='Запчасти, расходники']")
    private ExtendedWebElement sparesTopMenu;

    @FindBy(xpath = "//section[@id='listings_content']//span[text()='%s']")
    private ExtendedWebElement sparesForMercedes;

    @FindBy(xpath = "//div[contains(text(),'Запчасти для легковых авто')]")
    private List<ExtendedWebElement> listFieldSparesItems;

    @FindBy(xpath = "//div[@id='header']//span[1]")
    private ExtendedWebElement categMenuBtn;

    @FindBy(xpath = "//a[@href='https://re.kufar.by']")
    private ExtendedWebElement propertyPageGoBtn;

    KufarHomePage kufarHomePage = new KufarHomePage(getDriver());

    public void clickAutoBtn(){
        autoBtn.click();
    }

    public ExtendedWebElement getAutoBtn(){
        return autoBtn;
    }

    public String getTextNamePageAuto(String namePage){
        kufarHomePage.closePortal2();
        return namePageAuto.format(namePage).getText();
    }
    public void clickMercedesBtn(String modelCar){
        mercedesBtn.format(modelCar).click();
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

    public void clickSparesForMercedes(String modelCar){
        sparesForMercedes.format(modelCar).click();
    }

    public List<String> getListFieldSparesItems(){
        List<String> nameSpares = new LinkedList<>();
        for(ExtendedWebElement spareName : listFieldSparesItems){
            nameSpares.add(spareName.getText());
        }
        return nameSpares;
    }

    public void clickGoHomePage1(){
        categMenuBtn.click();
    }

    public ExtendedWebElement clickGoHomePage2(){
        return propertyPageGoBtn;
    }

    public  void checkAssertSparesFor3Page(){
        FileReadSparesKufar fileSpares = new FileReadSparesKufar();
        List<String> spareNames = getListFieldSparesItems();

        for(int i = 0; i<3; i++){
            for (String name : spareNames){
                List<String> spareLst = fileSpares.getLineList();
                boolean hasSpare = false;
                for(String lstSpare : spareLst){
                    if (name.contains(lstSpare)){
                        hasSpare = true;
                    }
                }
                Assert.assertTrue(hasSpare);
            }
            kufarHomePage.clickNextPage();
        }
    }

    public void checkAssertModelMercedesFor3Page(){
        SoftAssert softAssert = new SoftAssert();
        for(int i = 0; i<3; i++){
            List<String> names = getTextFieldItemsName();
            for(String carName : names){
                softAssert.assertTrue(carName.contains("Mercedes-Benz E-Класс"));
            }
            kufarHomePage.clickNextPage();

        }
        softAssert.assertAll();
    }
}
