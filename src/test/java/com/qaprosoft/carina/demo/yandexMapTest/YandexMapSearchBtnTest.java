package com.qaprosoft.carina.demo.yandexMapTest;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mobile.gui.pages.YandexMapPage.*;
import com.qaprosoft.carina.demo.mobile.gui.pages.yandexMapComponent.CategoryItem;
import com.qaprosoft.carina.demo.mobile.gui.pages.yandexMapComponent.Entrance;
import com.qaprosoft.carina.demo.mobile.gui.pages.yandexMapComponent.YandexMap;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class YandexMapSearchBtnTest implements IAbstractTest {

    @BeforeMethod
    public void openSearchBtn(){

        Entrance entrance = new Entrance(getDriver());
        try {
            entrance.clickLetsGoBtn();
            entrance.clickPlusBtn();
            entrance.clickDenyBtn();
        } catch (NoSuchElementException e){}

        YandexMap yandexMap = new YandexMap(getDriver());
        yandexMap.clickSearchBtn();
    }
    @Test
    public void testSearchStrBtn(){

        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.categoryItems().get(11).clickCategoryText();
        Assert.assertEquals(searchPage.categoryItems().get(14).getCategoryText(), "Saunas", "Button 'More' don't work");

        searchPage.clickSearchField();

        SearchStrPage searchStrPage = new SearchStrPage(getDriver());
        searchStrPage.typeSearchField("Могилёвская 1");
        searchStrPage.clickSearh();
        Assert.assertEquals(searchStrPage.checkSearchResult(), "53.883856, 27.538637", "Error in finding the street");
        pause(3);

    }

    @Test
    public void testFoodBtn(){
        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.categoryItems().get(0).clickCategoryText();

        FoodPage foodPage = new FoodPage(getDriver());
        foodPage.clickFoodPlaceField();
        Assert.assertTrue(foodPage.getCheckFoodCategorys());
    }

    @Test
    public void textGroceryBtn(){
        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.categoryItems().get(1).clickCategoryText();
        GroceryPage groceryPage = new GroceryPage(getDriver());
        Assert.assertEquals(groceryPage.getTextFoodDelivery(), "Food delivery", "page not opened");
    }

    @Test
    public void textPharmaciesBtn(){
        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.categoryItems().get(2).clickCategoryText();
        CategoryItem categoryItem = new CategoryItem(getDriver());
        Assert.assertEquals(categoryItem.getTextFieldSearch(), "Pharmacies", "page not opened");
    }

    @Test
    public void textBeautyBtn(){
        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.categoryItems().get(3).clickCategoryText();
        BeautyPage beautyPage = new BeautyPage(getDriver());
        Assert.assertEquals(beautyPage.getTextManicureField(), "Manicure", "page not opened");
    }

    @Test
    public void textGasStations(){
        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.categoryItems().get(4).clickCategoryText();
        CategoryItem categoryItem = new CategoryItem(getDriver());
        Assert.assertEquals(categoryItem.getTextFieldSearch(), "Gas", "page not opened");
    }
}
