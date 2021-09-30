package com.qaprosoft.carina.demo.kufar;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.components.kufar.FileReadSparesKufar;
import com.qaprosoft.carina.demo.gui.pages.kufar.KufarHomePage;
import com.qaprosoft.carina.demo.gui.pages.kufar.AutoKufarPage;
import com.qaprosoft.carina.demo.gui.utils.enums.ModelCar;
import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;
import java.util.List;


public class TestAutoKufar implements IAbstractTest {
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

        AutoKufarPage openAutoBtn = new AutoKufarPage(getDriver());
        openAutoBtn.clickAutoBtn();}

    @Test
    @MethodOwner(owner = "nzheleznyi")
    public void testCheckItemsNameForCarMercedesEClass() {
        AutoKufarPage autoKufarPage = new AutoKufarPage(getDriver());
        //mercedesBenzEClass.clickAutoBtn();
        autoKufarPage.clickMercedesBtn(ModelCar.MERCEDES.getModel());
        autoKufarPage.clickEClassBtn();
        pause(5);
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://auto.kufar.by/l/cars/mercedes-benz-e-klass");
        autoKufarPage.checkAssertModelMercedesFor3Page();

    }
    @Test
    @MethodOwner(owner = "nzheleznyi")
    public void testCheckItemsNameForSparesMercedes(){
        AutoKufarPage autoKufarPage = new AutoKufarPage(getDriver());
        //sparesMercedes.clickAutoBtn();
        autoKufarPage.clickSparesTopMenu();
        autoKufarPage.clickSparesForMercedes(ModelCar.MERCEDES.getModel());
        autoKufarPage.checkAssertSparesFor3Page();

    }
    @AfterClass
    public void openHomePageAgain(){
        kufarHomePage.open();
    }
}
