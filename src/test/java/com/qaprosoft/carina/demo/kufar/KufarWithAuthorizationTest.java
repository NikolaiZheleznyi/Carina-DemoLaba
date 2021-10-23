package com.qaprosoft.carina.demo.kufar;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.components.kufar.Authorization;
import com.qaprosoft.carina.demo.gui.components.kufar.UserMenu;
import com.qaprosoft.carina.demo.gui.pages.kufar.ContactSeller;
import com.qaprosoft.carina.demo.gui.pages.kufar.KufarHomePage;
import com.qaprosoft.carina.demo.gui.utils.enums.ContactWithSeller;
import com.qaprosoft.carina.demo.gui.utils.enums.ProfileMenu;
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
        try {
            kufarHomePage.closePortal();
            kufarHomePage.closePortal2();
        }catch(NoSuchElementException e){}
        Authorization authorization = new Authorization(getDriver());
        authorization.testAuthorization();
        Assert.assertTrue(kufarHomePage.getElementUserImageBtn().isElementPresent(),"Н");}
    @BeforeClass
    public void closeFlyPage(){
        try {
            kufarHomePage.closePortal2();
        }catch (NoSuchElementException e){}
    }

    @Test(priority = 2)
    @MethodOwner(owner = "nzheleznyi")
    public void testMyAds() {

        kufarHomePage.openUserMenu();

        UserMenu userMenu = new UserMenu(getDriver());
        userMenu.clickMyAds(ProfileMenu.ADS.getMessAds());
        userMenu.closeInfoField();
        pause(1);
        Assert.assertEquals(getDriver().getTitle(),"Мои объявления");

    }
    @Test(priority = 3)
    @MethodOwner(owner = "nzheleznyi")
    public void testMyMesseges() {
        kufarHomePage.openUserMenu();

        UserMenu userMenu = new UserMenu(getDriver());
        userMenu.clickMyMesseges(ProfileMenu.MESSEGES.getMessAds());
        Assert.assertEquals(getDriver().getTitle(),"Kufar | Продавайте и покупайте любые товары");
    }

    @Test(priority = 1)
    @MethodOwner(owner = "nzheleznyi")
    public void testNotifications() {
        kufarHomePage.clickNotificationsButton();
        UserMenu userMenu = new UserMenu(getDriver());
        Assert.assertEquals(userMenu.getTextAds(ProfileMenu.GETADS.getMessAds()),"Отметить все как прочитанные");

    }

    @Test(priority = 4)
    @MethodOwner(owner = "nzheleznyi")
    public void testWriteToSeller() {
        kufarHomePage.openProductPage();

        ContactSeller contactSeller = new ContactSeller(getDriver());
        contactSeller.clickWrite(ContactWithSeller.WRITE.getContact());
        Assert.assertEquals(contactSeller.getTextSendMessageBtn(),"Отправить");
        contactSeller.clickCloseBtnMssg();
        contactSeller.clickGoHomePage();
    }

    @Test(priority = 5)
    @MethodOwner(owner = "nzheleznyi")
    public void testCallToSeller() {
       try {
           //kufarHomePage.clickChooseProduct();
           kufarHomePage.openProductPage();

           ContactSeller contactSeller = new ContactSeller(getDriver());
           contactSeller.clickCall(ContactWithSeller.CALL.getContact());
           Assert.assertEquals(contactSeller.getTextAfterCallBtn(),"Пожалуйста, скажите продавцу, что звоните по объявлению с Куфара");
           contactSeller.clickCloseBtnCall();
           contactSeller.clickGoHomePage();
       } catch (NoSuchElementException e) {LOGGER.info("Button call not found");}

    }
    /*@AfterMethod
    public void closePage(){
        ContactSeller contactSeller = new ContactSeller(getDriver());
        contactSeller.clickGoHomePage();
    }*/
    @AfterSuite
    public void afterSuite() {
        LOGGER.info("After test with Authorization");
    }

}
