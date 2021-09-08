package com.qaprosoft.carina.demo.mobile.gui.pages.YandexMapPage;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.mobile.gui.pages.yandexMapComponent.CategoryItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends AbstractUIObject {

    @FindBy(id = "ru.yandex.yandexmaps:id/search_line_edit_text")
    private ExtendedWebElement searchField;

    @FindBy(id = "ru.yandex.yandexmaps:id/search_line_search_button")
    private ExtendedWebElement search;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='ru.yandex.yandexmaps:id/ordinal_category_container']")
    private List<CategoryItem> categorysItemList;


    public SearchPage(WebDriver driver){super(driver);}

    public void clickSearchField(){
        searchField.click();
    }

    public List<CategoryItem> categoryItems(){
        return categorysItemList;
    }



}
