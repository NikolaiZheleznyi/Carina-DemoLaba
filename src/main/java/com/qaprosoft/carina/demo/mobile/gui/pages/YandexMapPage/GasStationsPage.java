package com.qaprosoft.carina.demo.mobile.gui.pages.YandexMapPage;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GasStationsPage extends AbstractUIObject {
    @FindBy(id = "ru.yandex.yandexmaps:id/search_line_search_text")
    private ExtendedWebElement fieldSearch;
    public GasStationsPage(WebDriver driver){super(driver);}

    public String getTextFieldSearch(){
        return fieldSearch.getText();
    }
}
