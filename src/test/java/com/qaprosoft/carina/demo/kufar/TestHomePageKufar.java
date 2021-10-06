package com.qaprosoft.carina.demo.kufar;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.components.kufar.CategoryItem;
import com.qaprosoft.carina.demo.gui.components.kufar.ChooseProductCategory;
import com.qaprosoft.carina.demo.gui.pages.kufar.CitySelectionKufar;
import com.qaprosoft.carina.demo.gui.pages.kufar.KufarHomePage;


import com.qaprosoft.carina.demo.gui.utils.enums.Languages;
import org.junit.runner.notification.RunListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class TestHomePageKufar implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    KufarHomePage kufarHomePage = new KufarHomePage(getDriver());

    @BeforeSuite
    public void beforeSuite() {
        LOGGER.info("Before test with Authorization");
    }

    @BeforeClass
    public void openHomePage() {
        kufarHomePage.open();
        kufarHomePage.closePortal();
        kufarHomePage.closePortal2();
    }
    @BeforeMethod
    public void numberTest(){
        LOGGER.info("Test starting");
    }

    @Test
    @MethodOwner(owner = "nzheleznyi")
    public void testChangeLanguage() {

        kufarHomePage.clickChangeLanguage(Languages.BLR.getName());
        Assert.assertEquals(kufarHomePage.getTextAllBelarusDtn(),"Уся Беларусь");
        kufarHomePage.clickChangeLanguage(Languages.RUS.getName());
    }

    @Test
    @MethodOwner(owner = "nzheleznyi")
    public void testBackPage() {

        kufarHomePage.clickBackPage();
        pause(2);
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.kufar.by/l?cursor=eyJ0IjoiYWJzIiwiZiI6dHJ1ZSwicCI6M30");
    }

    @Test
    @MethodOwner(owner = "nzheleznyi")
    public void testNextPage() {

        kufarHomePage.clickNextPage();
        pause(2);
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.kufar.by/l?cursor=eyJ0IjoiYWJzIiwiZiI6dHJ1ZSwicCI6Mn0=");
    }


    @Test
    @MethodOwner(owner = "nzheleznyi")
    public void testChooseProductCategory() {
        ChooseProductCategory chooseProductCategory = new ChooseProductCategory(getDriver());
        chooseProductCategory.clickCategoryButton();
        chooseProductCategory.clickAnimalsButton();
        chooseProductCategory.clickPetsButtin();
        chooseProductCategory.clickShowResults();
        CategoryItem categoryItem = new CategoryItem(getDriver());
        for(int i = 1; i<3; i++){
            List<String> nameAnimal = categoryItem.getTextFieldCategoryItems();
            for(String animalName : nameAnimal){
                Assert.assertTrue(animalName.contains("Домашние питомцы"));}
            kufarHomePage.clickNextPage();
        }
    }

    @Test(dataProvider = "SingleDataProvider")
    @XlsDataSourceParameters(path = "xls/demo.xlsx", sheet = "listItemsForSearch", dsUid = "TUID", dsArgs = "item")
    public void testSearchField(String item) {
        kufarHomePage.openSearchField(item);
        kufarHomePage.AssertSearchResult(item);
    }

    @Test(dataProvider = "SingleDataProvider")
    @XlsDataSourceParameters(path = "xls/demo.xlsx", sheet = "citySelection", dsUid = "TUID", dsArgs = "city, district")
    public void testCheckCity(String city, String district) {
        CitySelectionKufar citySelectionKufar = new CitySelectionKufar(getDriver());
        citySelectionKufar.clickDistrict();
        citySelectionKufar.clickChooseDistrict(district);
        citySelectionKufar.clickCity();
        citySelectionKufar.clickChooseCity(city);
        citySelectionKufar.clickSearchBtn();

        Assert.assertEquals(citySelectionKufar.getTextCity(city), city);
        System.out.println(city);
    }


    @AfterClass
    public void testPassed() {
        LOGGER.info("Test passed");
    }


    @AfterSuite
    public void afterSuite() {
        LOGGER.info("After test with Authorization");
    }
}