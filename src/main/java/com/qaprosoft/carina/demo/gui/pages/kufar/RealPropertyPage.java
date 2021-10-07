package com.qaprosoft.carina.demo.gui.pages.kufar;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RealPropertyPage extends AbstractPage {
    public RealPropertyPage(WebDriver driver) {
        super(driver);
    }
    KufarHomePage kufarHomePage = new KufarHomePage(getDriver());

    @FindBy(xpath = "//a[@data-name='header-generalist-to-realty']//img")
    private ExtendedWebElement realPropertyBtn;

    @FindBy(xpath = "//a[text()='%s']")
    private ExtendedWebElement namePage;

    @FindBy(xpath = "//select[@name='cat']")
    private ExtendedWebElement choosePropertyBtn;

    @FindBy(xpath = "//option[text()='%s']")
    private ExtendedWebElement choosePropertyType;

    public void clickChoosePropertyType(String typeProperty){
        choosePropertyType.format(typeProperty).click();
        Assert.assertEquals(choosePropertyType.format(typeProperty).getText(), typeProperty);
    }

    public void clickChoosePropertyBtn(){
        choosePropertyBtn.click();
    }
    public void clickRealPropertyBtn(){
        realPropertyBtn.click();
    }
    public String getTextNamePage(String name){
       // kufarHomePage.closePortal2();
        return namePage.format(name).getText();
    }

}
