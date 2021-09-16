package com.qaprosoft.carina.demo.kufar;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.components.kufar.Authorization;
import com.qaprosoft.carina.demo.gui.components.kufar.LogOut;
import com.qaprosoft.carina.demo.gui.components.kufar.LoginBlock;
import com.qaprosoft.carina.demo.gui.components.kufar.UserMenu;
import com.qaprosoft.carina.demo.gui.pages.kufar.ContactSeller;
import com.qaprosoft.carina.demo.gui.pages.kufar.KufarHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.invoke.MethodHandles;

public class KufarWithAuthorizationTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    KufarHomePage kufarHomePage = new KufarHomePage(getDriver());
    @BeforeSuite
    public void beforeSuite() {
        LOGGER.info("Before test with Authorization");
    }
    @BeforeClass
    public void openHomePage() {
        kufarHomePage.open();
        //pause(2);
        kufarHomePage.closePortal();
        kufarHomePage.closePortal2();
        //LOGGER.info("Start test-methods");
    }
   @BeforeMethod
    public void testAuthorization() {

       Authorization authorization = new Authorization(getDriver());
       authorization.testAuthorization();
       Assert.assertTrue(kufarHomePage.getUserImageBtn().isElementPresent(),"Н");
    }

    @Test
    @MethodOwner(owner = "nzheleznyi")
    public void testMyAds() {

        kufarHomePage.openUserMenu();

        UserMenu userMenu = new UserMenu(getDriver());
        userMenu.clickMyAds();
        userMenu.closeInfoField();
        pause(1);
        Assert.assertEquals(getDriver().getTitle(),"Мои объявления");

    }
    @Test
    @MethodOwner(owner = "nzheleznyi")
    public void testMyMesseges() {
        kufarHomePage.openUserMenu();

        UserMenu userMenu = new UserMenu(getDriver());
        userMenu.clickMyMesseges();
        Assert.assertEquals(getDriver().getTitle(),"Kufar | Продавайте и покупайте любые товары");
    }

    @Test
    @MethodOwner(owner = "nzheleznyi")
    public void testNotifications() {
        kufarHomePage.clickNotificationsButton();
        UserMenu userMenu = new UserMenu(getDriver());
        Assert.assertEquals(userMenu.getTextAds(),"Отметить все как прочитанные");

    }

    @Test
    @MethodOwner(owner = "nzheleznyi")
    public void testWriteToSeller() {
        kufarHomePage.openProductPage();

        ContactSeller contactSeller = new ContactSeller(getDriver());
        contactSeller.clickWrite();
        Assert.assertEquals(contactSeller.getTextSendMessageBtn(),"Отправить");
    }

    @Test
    @MethodOwner(owner = "nzheleznyi")
    public void testCallToSeller() {
       try {
           //kufarHomePage.clickChooseProduct();
           kufarHomePage.openProductPage();

           ContactSeller contactSeller = new ContactSeller(getDriver());
           contactSeller.clickCall();
           Assert.assertEquals(contactSeller.getTextAfterCallBtn(),"Отправить");
       } catch (NoSuchElementException e) {LOGGER.info("Button call not found");}
    }
   /* @AfterMethod
    public void closePage(){
        kufarHomePage.openUserMenu();
        LogOut logOut = new LogOut(getDriver());
        logOut.clickExitAccount();
        pause(2);
       //LOGGER.info("Something close page");
    }
    @AfterSuite
    public void afterSuite() {
        LOGGER.info("After test with Authorization");
    }*/

}
