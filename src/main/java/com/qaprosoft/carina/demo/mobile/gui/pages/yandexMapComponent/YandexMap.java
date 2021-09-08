package com.qaprosoft.carina.demo.mobile.gui.pages.yandexMapComponent;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YandexMap extends AbstractUIObject {
    @FindBy(id = "ru.yandex.yandexmaps:id/tab_navigation_tab_search")
    private ExtendedWebElement searchBtn;

    @FindBy(id = "ru.yandex.yandexmaps:id/tab_navigation_tab_routes")
    private ExtendedWebElement routeBtn;

    @FindBy(id = "ru.yandex.yandexmaps:id/tab_navigation_tab_free_drive")
    private ExtendedWebElement navigatorBtn;

    @FindBy(id = "ru.yandex.yandexmaps:id/tab_navigation_tab_transport")
    private ExtendedWebElement transportBtn;

    public YandexMap(WebDriver driver){super(driver);}

    public void clickSearchBtn(){
        searchBtn.click();
    }

    public void clickRouteBtn(){
        routeBtn.click();
    }

    public void clickNavigatorBtn(){
        navigatorBtn.click();
    }

    public void clickTransportBtn(){
        transportBtn.click();
    }
}
