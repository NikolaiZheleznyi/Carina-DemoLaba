package com.qaprosoft.carina.demo.kufar;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.components.kufar.ChooseProductCategory;
import com.qaprosoft.carina.demo.gui.pages.kufar.ContactSeller;
import com.qaprosoft.carina.demo.gui.components.kufar.LoginBlock;
import com.qaprosoft.carina.demo.gui.components.kufar.UserMenu;
import com.qaprosoft.carina.demo.gui.pages.kufar.KufarHomePage;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.invoke.MethodHandles;

public class KufarTest implements IAbstractTest {

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
    }
    @BeforeMethod
    public void numberTest(){
        LOGGER.info("Test starting");
    }
    @Test
    @MethodOwner(owner = "nzheleznyi")
    public void testSearchField() {

        final String inputSF = "подушка";
        kufarHomePage.openSearchField(inputSF);
    }

    @Test
    @MethodOwner(owner = "nzheleznyi")
    public void testChooseProductCategory() {

        kufarHomePage.clickCategoryButton();

        ChooseProductCategory chooseProductCategory = new ChooseProductCategory(getDriver());
        chooseProductCategory.clickFurnitureCategory();
        chooseProductCategory.clickChairCategory();
        chooseProductCategory.clickShowResults();
        pause(2);
        Assert.assertEquals(getDriver().getTitle(),"Стулья купить в Беларуси");
    }

    @Test
    @MethodOwner(owner = "nzheleznyi")
    public void testChangeLanguage() {

        kufarHomePage.clickChangeLanguage();

    }

    @Test
    @MethodOwner(owner = "nzheleznyi")
    public void testNextPage() {

        kufarHomePage.clickNextPage();
    }

    @Test
    @MethodOwner(owner = "nzheleznyi")
    public void testBackPage() {

        kufarHomePage.clickBackPage();
    }
    @AfterMethod
    public void testPassed() {
        LOGGER.info("Test passed");
    }

    @AfterClass
    public void quitDriver() {
        getDriver().quit();
    }

    @AfterSuite
    public void afterSuite() {
        LOGGER.info("After test with Authorization");
    }
}
