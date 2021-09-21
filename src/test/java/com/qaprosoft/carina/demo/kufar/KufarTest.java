package com.qaprosoft.carina.demo.kufar;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.components.kufar.CategoryItem;
import com.qaprosoft.carina.demo.gui.components.kufar.ChooseProductCategory;
import com.qaprosoft.carina.demo.gui.pages.kufar.ContactSeller;
import com.qaprosoft.carina.demo.gui.components.kufar.LoginBlock;
import com.qaprosoft.carina.demo.gui.components.kufar.UserMenu;
import com.qaprosoft.carina.demo.gui.pages.kufar.KufarHomePage;


import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.invoke.MethodHandles;
import java.util.List;

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
        kufarHomePage.closePortal2();
    }
    @BeforeMethod
    public void numberTest(){
        LOGGER.info("Test starting");
    }

    @Test
    @MethodOwner(owner = "nzheleznyi")
    public void testChangeLanguage() {

        kufarHomePage.clickChangeLanguageBLR();
        Assert.assertEquals(kufarHomePage.getTextAllBelarusDtn(),"Уся Беларусь");
        kufarHomePage.clickChangeLanguageRUS();
    }

    @Test
    @MethodOwner(owner = "nzheleznyi")
    public void testBackPage() {

        kufarHomePage.clickBackPage();
        pause(2);
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.kufar.by/l?cursor=eyJ0IjoiYWJzIiwiZiI6dHJ1ZSwicCI6MX0=");
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

   /* @Test
    @MethodOwner(owner = "nzheleznyi")
    public void testSearchField() {

        final String inputSF = "подушка";
        kufarHomePage.openSearchField(inputSF);

    }*/

    @AfterClass
    public void testPassed() {
        LOGGER.info("Test passed");
    }


    @AfterSuite
    public void afterSuite() {
        LOGGER.info("After test with Authorization");
    }
}
