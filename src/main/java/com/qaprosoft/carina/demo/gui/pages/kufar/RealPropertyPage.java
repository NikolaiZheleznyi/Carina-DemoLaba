package com.qaprosoft.carina.demo.gui.pages.kufar;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RealPropertyPage extends AbstractPage {
    public RealPropertyPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = ("//a[@data-name='header-generalist-to-realty']//img"))
    private ExtendedWebElement realPropertyBtn;
    

    public void clickRealPropertyBtn(){
        realPropertyBtn.click();
    }
}
