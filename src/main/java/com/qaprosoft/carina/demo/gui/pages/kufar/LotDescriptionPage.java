package com.qaprosoft.carina.demo.gui.pages.kufar;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LotDescriptionPage extends AbstractPage {
    public LotDescriptionPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//link[@rel='canonical']")
    private ExtendedWebElement lotLabel;

}

