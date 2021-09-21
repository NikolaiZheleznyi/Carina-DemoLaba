package com.qaprosoft.carina.demo.gui.pages.kufar;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ContactSeller extends AbstractPage {
    public ContactSeller(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[text()='Отправить']")
    private ExtendedWebElement sendMessageBtn;
    @FindBy(xpath = "//div[@id='sidebar-buttons']//button[text()='Написать']")
    private ExtendedWebElement writeToSeller;
        @FindBy(xpath = "//div[@id='__next']//img[@alt='close']")
    private ExtendedWebElement closeFieldMssgBtn;

    @FindBy(xpath = "//div[@id='sidebar-buttons']//button[text()='Позвонить']")
    private ExtendedWebElement callToSeller;
    @FindBy(xpath = "//div[@data-name='phone-number-modal']//div[last()]")
    private ExtendedWebElement fieldSaySalesman;
    @FindBy(xpath = "//div[@id='adview_content']//img[@alt='close']")
    private ExtendedWebElement closeFieldCallBtn;

    @FindBy(xpath = "//div[@id='header']//a//img[@width='130']")
    private ExtendedWebElement goPageHome;

    public void clickWrite(){
        writeToSeller.click();
    }
    public void clickCloseBtnMssg(){
        closeFieldMssgBtn.click();
    }

    public void clickCall(){
        callToSeller.click();
    }
    public void clickCloseBtnCall(){closeFieldCallBtn.click();
    }

    public String getTextSendMessageBtn(){
        return sendMessageBtn.getText();
    }
    public String getTextAfterCallBtn(){
        return fieldSaySalesman.getText();
    }

    public void clickGoHomePage(){
        goPageHome.click();
    }
}
