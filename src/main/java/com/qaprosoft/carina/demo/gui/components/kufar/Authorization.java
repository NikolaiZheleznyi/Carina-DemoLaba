package com.qaprosoft.carina.demo.gui.components.kufar;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.pages.kufar.KufarHomePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class Authorization extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    public Authorization(WebDriver driver) {
        super(driver);
    }
    public void testAuthorization(){
        KufarHomePage kufarHomePage = new KufarHomePage(getDriver());
        kufarHomePage.loginBlockButten();

        LoginBlock loginBlock = new LoginBlock(getDriver());
        try {
            loginBlock.LogInOtherProfile();
        } catch (NoSuchElementException e) {LOGGER.info("No profile selection required");}
        final String inputE = "nikolaizheleznyi@gmail.com";
        loginBlock.inputEmail(inputE);

        final String inputP = "375336556889Nv";
        loginBlock.inputPassword(inputP);
        loginBlock.authoButton();
    }
}
