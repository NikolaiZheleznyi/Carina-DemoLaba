package com.qaprosoft.carina.demo.kufar;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.kufar.AutoKufarPage;
import com.qaprosoft.carina.demo.gui.pages.kufar.KufarHomePage;
import com.qaprosoft.carina.demo.utils.JSUtil;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class TestWithJSExecutor implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestWithJSExecutor.class);
    KufarHomePage kufarHomePage = new KufarHomePage(getDriver());
    @BeforeMethod
    public void openHomePage(){
        kufarHomePage.open();
        kufarHomePage.closePortal2();

    }
    @Test
    public void flashing() {
        AutoKufarPage autoKufarPage = new AutoKufarPage(getDriver());
        JSUtil.flash(autoKufarPage.getAutoBtn().getElement(), getDriver());

    }

    @Test
    public void drawingBorderAndScreenshot() {
        AutoKufarPage autoKufarPage = new AutoKufarPage(getDriver());
        JSUtil.drawBorder(autoKufarPage.getAutoBtn().getElement(), getDriver());

        File scr = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        File scrPackage = new File("/Users/nzheleznui/SOLVD/screenshots/kufar.by/testScr.png");
        try {
            FileUtils.copyFile(scr,scrPackage );
        } catch (IOException e) {
            e.printStackTrace();
        }
        String title = JSUtil.getTitleByJS(getDriver());
        System.out.println(title);
    }

    @Test
    public void clickOnElementByJS() {
        AutoKufarPage autoKufarPage = new AutoKufarPage(getDriver());
        autoKufarPage.clickAutoBtn();
        kufarHomePage.closePortal2();
        autoKufarPage.clickGoHomePage1();
        //click on element by JS
        JSUtil.clickElementByJS(autoKufarPage.clickGoHomePage2().getElement(), getDriver());
        pause(2);
        //capture title of the page
        String title = JSUtil.getTitleByJS(getDriver());
        System.out.println(title);
        //refreshing page by JS
        JSUtil.refresherBrouserByJS(getDriver());
        //generate alert
        JSUtil.generateAlert(getDriver(), "get bed motherfucker");
        pause(2);
    }
}
