package com.qaprosoft.carina.demo.mobile.gui.pages.YandexMapPage;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchStrPage extends AbstractUIObject {

    @FindBy(id = "ru.yandex.yandexmaps:id/search_line_edit_text")
    private ExtendedWebElement searchField;

    @FindBy(id = "ru.yandex.yandexmaps:id/search_line_search_button")
    private ExtendedWebElement search;

    @FindBy(id = "ru.yandex.yandexmaps:id/coordinates_text")
    private ExtendedWebElement searchResult;

    public SearchStrPage(WebDriver driver){super(driver);}

    public void typeSearchField(String query){
        searchField.type(query);
    }

    public void clickSearh(){
        search.click();
    }

    public String checkSearchResult(){
        return searchResult.getText();
    }
}
