package com.qaprosoft.carina.demo.kufar;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.demo.gui.components.kufar.ChooseProductCategory;
import com.qaprosoft.carina.demo.gui.components.kufar.ContactSeller;
import com.qaprosoft.carina.demo.gui.components.kufar.LoginBlock;
import com.qaprosoft.carina.demo.gui.components.kufar.UserMenu;
import com.qaprosoft.carina.demo.gui.pages.kufar.KufarHomePage;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class KufarTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    @MethodOwner(owner = "nzheleznyi")
    @TestPriority(Priority.P1)
    public void testAuthorization() {
        KufarHomePage kufarHomePage = new KufarHomePage(getDriver());
        kufarHomePage.open();
        kufarHomePage.closePortal();
        kufarHomePage.loginBlockButten();

        LoginBlock loginBlock = new LoginBlock(getDriver());

        final String inputE = "mkzhel91@gmail.com";
        loginBlock.inputEmail(inputE);

        final String inputP = "12345678NvD";
        loginBlock.inputPassword(inputP);

        loginBlock.authoButton();

    }

    @Test
    @MethodOwner(owner = "nzheleznyi")
    @TestPriority(Priority.P1)
    public void testMyAds() {
        KufarHomePage kufarHomePage = new KufarHomePage(getDriver());
        kufarHomePage.open();
        kufarHomePage.closePortal();
        kufarHomePage.loginBlockButten();

        LoginBlock loginBlock = new LoginBlock(getDriver());

        final String inputE = "mkzhel91@gmail.com";
        loginBlock.inputEmail(inputE);

        final String inputP = "12345678NvD";
        loginBlock.inputPassword(inputP);
        loginBlock.authoButton();
        pause(2);

        kufarHomePage.openUserMenu();

        UserMenu userMenu = new UserMenu(getDriver());
        userMenu.clickMyAds();

    }

    @Test
    @MethodOwner(owner = "nzheleznyi")
    @TestPriority(Priority.P1)
    public void testMyMesseges() {
        KufarHomePage kufarHomePage = new KufarHomePage(getDriver());
        kufarHomePage.open();
        kufarHomePage.closePortal();
        kufarHomePage.loginBlockButten();

        LoginBlock loginBlock = new LoginBlock(getDriver());

        final String inputE = "mkzhel91@gmail.com";
        loginBlock.inputEmail(inputE);

        final String inputP = "12345678NvD";
        loginBlock.inputPassword(inputP);
        loginBlock.authoButton();
        pause(2);

        kufarHomePage.openUserMenu();

        UserMenu userMenu = new UserMenu(getDriver());
        userMenu.clickMyMesseges();

    }

    @Test
    @MethodOwner(owner = "nzheleznyi")
    @TestPriority(Priority.P1)
    public void testSearchField() {
        KufarHomePage kufarHomePage = new KufarHomePage(getDriver());
        kufarHomePage.open();
        kufarHomePage.closePortal();

        final String inputSF = "подушка";
        kufarHomePage.openSearchField(inputSF);

    }

    @Test
    @MethodOwner(owner = "nzheleznyi")
    @TestPriority(Priority.P1)
    public void testNotifications() {
        KufarHomePage kufarHomePage = new KufarHomePage(getDriver());
        kufarHomePage.open();
        kufarHomePage.closePortal();
        kufarHomePage.loginBlockButten();

        LoginBlock loginBlock = new LoginBlock(getDriver());

        final String inputE = "mkzhel91@gmail.com";
        loginBlock.inputEmail(inputE);

        final String inputP = "12345678NvD";
        loginBlock.inputPassword(inputP);
        loginBlock.authoButton();
        pause(2);

        kufarHomePage.clickNotificationsButton();


    }

    @Test
    @MethodOwner(owner = "nzheleznyi")
    @TestPriority(Priority.P1)
    public void testChooseProductCategory() {
        KufarHomePage kufarHomePage = new KufarHomePage(getDriver());
        kufarHomePage.open();
        kufarHomePage.closePortal();

        kufarHomePage.clickCategoryButton();

        ChooseProductCategory chooseProductCategory = new ChooseProductCategory(getDriver());
        chooseProductCategory.clickFurnitureCategory();
        chooseProductCategory.clickChairCategory();
        chooseProductCategory.clickShowResults();
        pause(2);
    }

    @Test
    @MethodOwner(owner = "nzheleznyi")
    @TestPriority(Priority.P1)
    public void testWriteToSeller() {
        KufarHomePage kufarHomePage = new KufarHomePage(getDriver());
        kufarHomePage.open();
        kufarHomePage.closePortal();
        kufarHomePage.loginBlockButten();

        LoginBlock loginBlock = new LoginBlock(getDriver());

        final String inputE = "mkzhel91@gmail.com";
        loginBlock.inputEmail(inputE);

        final String inputP = "12345678NvD";
        loginBlock.inputPassword(inputP);
        loginBlock.authoButton();
        pause(2);

        kufarHomePage.clickChooseProduct();
        // kufarHomePage.openProductPage();

        ContactSeller contactSeller = new ContactSeller(getDriver());
        contactSeller.clickWrite();
    }

    @Test
    @MethodOwner(owner = "nzheleznyi")
    @TestPriority(Priority.P1)
    public void testChangeLanguage() {
        KufarHomePage kufarHomePage = new KufarHomePage(getDriver());
        kufarHomePage.open();
        kufarHomePage.closePortal();
        kufarHomePage.clickChangeLanguage();
    }

    @Test
    @MethodOwner(owner = "nzheleznyi")
    @TestPriority(Priority.P1)
    public void testNextPage() {
        KufarHomePage kufarHomePage = new KufarHomePage(getDriver());
        kufarHomePage.open();
        kufarHomePage.closePortal();
        kufarHomePage.clickNextPage();
    }
}
