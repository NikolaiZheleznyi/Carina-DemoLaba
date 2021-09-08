package com.qaprosoft.carina.demo.mobile.gui.pages.yandexMapComponent;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CategoryItem extends AbstractUIObject {
    @FindBy(xpath = ".//android.widget.TextView[@resource-id='ru.yandex.yandexmaps:id/ordinal_category_item_caption']")
    private ExtendedWebElement categoryText;

    @FindBy(id = "ru.yandex.yandexmaps:id/search_line_search_text")
    private ExtendedWebElement fieldSearch;

    public CategoryItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CategoryItem(WebDriver driver) {
        super(driver);
    }

    public String getCategoryText(){
        return categoryText.getText();
    }
    public void clickCategoryText(){
        categoryText.click();
    }
    public String getTextFieldSearch(){
        return fieldSearch.getText();
    }
}
