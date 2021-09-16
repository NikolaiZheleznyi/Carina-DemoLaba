package com.qaprosoft.carina.demo.gui.components.kufar;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.LinkedList;
import java.util.List;

public class CategoryItem extends AbstractPage {
    public CategoryItem(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//article[@class='kf-kcLG-09ad7']//a[@class='kf-LEuA-880a1']//div[@class='kf-LEgE-cacdf']")
    private List<ExtendedWebElement> fieldCategoryItems;


    public List<String> getTextFieldCategoryItems(){
        List<String> nameAnimal = new LinkedList<>();
        for(ExtendedWebElement names : fieldCategoryItems ){
            nameAnimal.add(names.getText());
        }
        return nameAnimal;
    }

}
