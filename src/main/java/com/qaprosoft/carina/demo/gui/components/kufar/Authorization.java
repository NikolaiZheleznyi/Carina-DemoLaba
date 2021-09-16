package com.qaprosoft.carina.demo.gui.components.kufar;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.pages.kufar.KufarHomePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Properties;

public class Authorization extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    public Authorization(WebDriver driver) {
        super(driver);
    }
    public static String getUser(String path, String user) {
        Properties properties = new Properties();
        FileInputStream file = null;
        try {
            file = new FileInputStream(path);
            properties.load(file);
            file.close();
            return properties.getProperty(user);

        } catch (IOException e) {
            System.err.println(" Incorrect user!");
        }
        return "default";
    }

    public static String getPassword(String path, String password) {
        Properties properties = new Properties();
        FileInputStream file = null;
        try {
            file = new FileInputStream(path);
            properties.load(file);
            file.close();
            return properties.getProperty(password);

        } catch (IOException e) {
            System.err.println(" Incorrect Password!");
        }
        return "default";
    }


    public void setDBSignificance(String path, String User, String valueUser, String password, String valuePassword){
        Properties properties =new Properties();
        try {
            FileOutputStream file = new FileOutputStream(path);
            properties.setProperty(User, valueUser);
            properties.setProperty(password,valuePassword);
            properties.store(file,"");
            file.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void testAuthorization(){
        KufarHomePage kufarHomePage = new KufarHomePage(getDriver());
        kufarHomePage.loginBlockButten();

        LoginBlock loginBlock = new LoginBlock(getDriver());
        try {
            loginBlock.LogInOtherProfile();
        } catch (NoSuchElementException e) {LOGGER.info("No profile selection required");}
        final String inputE = getUser("properties", "log_kufar");
        loginBlock.inputEmail(inputE);

        final String inputP = getPassword("properties", "password_kufar");
        loginBlock.inputPassword(inputP);
        loginBlock.authoButton();
    }
}
