package com.qaprosoft.carina.demo.mobile.gui.pages.YandexMapPage;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FoodPage extends AbstractUIObject {
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget." +
            "FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget." +
            "FrameLayout/android.widget.FrameLayout[4]/android.widget.FrameLayout/android.widget." +
            "FrameLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget." +
            "FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx." +
            "recyclerview.widget.RecyclerView[2]")
    private ExtendedWebElement foodPlaceField;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget." +
            "FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget." +
            "FrameLayout/android.widget.FrameLayout[4]/android.widget.FrameLayout/android.widget." +
            "FrameLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget." +
            "FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget." +
            "FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/androidx.recyclerview.widget." +
            "RecyclerView[1]/androidx.recyclerview.widget.RecyclerView[1]/android.widget.TextView[2]")
    private ExtendedWebElement typeFoodField;
    public FoodPage(WebDriver driver){super(driver);}

    public void clickFoodPlaceField(){
        foodPlaceField.click();
    }

    public String getTextBookTableBtn(){
        return typeFoodField.getText();
    }
    public boolean getCheckFoodCategorys(){
        boolean checkFoodCategorys = false;
        if (getTextBookTableBtn().contains("Cafe")){checkFoodCategorys = true;}
        else if (getTextBookTableBtn().contains("Restaurant")){checkFoodCategorys = true;}
        else if (getTextBookTableBtn().contains("Fast food")){checkFoodCategorys = true;}
        else if (getTextBookTableBtn().contains("Pizzeria")){checkFoodCategorys = true;}
        else if (getTextBookTableBtn().contains("Food")){checkFoodCategorys = true;}
        else if (getTextBookTableBtn().contains("food")){checkFoodCategorys = true;}
        else checkFoodCategorys = false;
        return checkFoodCategorys;
    }
}
