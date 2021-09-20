package com.qaprosoft.carina.demo.kufar;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.components.kufar.FileReadSparesKufar;
import com.qaprosoft.carina.demo.gui.pages.kufar.KufarHomePage;
import com.qaprosoft.carina.demo.gui.pages.kufar.AutoKufarPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class AutoKufarTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    KufarHomePage kufarHomePage = new KufarHomePage(getDriver());

    @BeforeSuite
    public void beforeSuite() {
        LOGGER.info("Before test with Authorization");
    }

    @BeforeTest
    public void openHomePage() {
        kufarHomePage.open();
        kufarHomePage.closePortal();
        kufarHomePage.closePortal2();
    }
/*    @BeforeMethod
    public void numberTest(){
        kufarHomePage.open();
        kufarHomePage.closePortal();
        kufarHomePage.closePortal2();
        LOGGER.info("Test starting");
    }*/

    @Test
    @MethodOwner(owner = "nzheleznyi")
    public void testCheckItemsNameForCarMercedesEClass() {
        AutoKufarPage mercedesBenzEClass = new AutoKufarPage(getDriver());
        mercedesBenzEClass.clickAutoBtn();
        mercedesBenzEClass.clickMercedesBtn();
        mercedesBenzEClass.clickEClassBtn();
        pause(5);
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://auto.kufar.by/l/cars/mercedes-benz-e-klass");
        for(int i = 0; i<3; i++){
            List<String> names = mercedesBenzEClass.getTextFieldItemsName();
            for(String carName : names){
                Assert.assertTrue(carName.contains("Mercedes-Benz E-Класс"));
            }
            kufarHomePage.clickNextPage();
        }

    }
    @Test
    @MethodOwner(owner = "nzheleznyi")
    public void testCheckItemsNameForSparesMercedes(){
        AutoKufarPage sparesMercedes = new AutoKufarPage(getDriver());
        //sparesMercedes.clickAutoBtn();
        sparesMercedes.clickSparesTopMenu();
        sparesMercedes.clickSparesForMercedes();
        FileReadSparesKufar fileSpares = new FileReadSparesKufar();
        for(int i = 0; i<3; i++){
            List<String> spareNames = sparesMercedes.getListFieldSparesItems();
            for (String name : spareNames){
                List<String> spareLst = fileSpares.getLineList();
                boolean hasSpare = false;
                for(String lstSpare : spareLst){
                    if (name.contains(lstSpare)){
                        hasSpare = true;
                    }
                }
                Assert.assertTrue(hasSpare);
            }
        kufarHomePage.clickNextPage();
        }






    }

}
