package com.qaprosoft.carina.demo.gui.pages.kufar;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

import com.qaprosoft.carina.demo.gui.components.kufar.ChooseProductCategory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class KufarHomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@data-name='login_button']")
    private ExtendedWebElement loginBlockButten;

    @FindBy(xpath = "//div[@id='portal']//descendant::img[@alt='close']")
    private ExtendedWebElement portalCloseButton;

    @FindBy(xpath = "//div[@id='__next']//button[@id='cancel']")
    private ExtendedWebElement portalCloseButton2;

    @FindBy(xpath = "//div[@data-name='user_profile_pic']")
    private ExtendedWebElement userMenu;

    @FindBy(xpath = "//input[@placeholder='Товар, услуга']")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//button[@class='kf-LRuy-6ff1f']//span[text()='Уся Беларусь']")
    private ExtendedWebElement allBelarusBtn;

    @FindBy(xpath = "//div[@class='kf-uLg-4888a']//h1[text()='подушка купить в Беларуси']")
    private ExtendedWebElement fieldResultSearch;

    @FindBy(xpath = "//div[@data-name='notification_icon']")
    private ExtendedWebElement notificationsButton;

    @FindBy(xpath = "//div[@data-name='megamenu']//button")
    private ExtendedWebElement categoryButton;

    @FindBy(xpath = "//div[@class='kf-OZzP-810dc']//div[1]//a")
    private ExtendedWebElement chooseProduct;

    @FindBy(xpath = "//span[text()='Беларуская']")
    private ExtendedWebElement changeLanguageBelarus;

    @FindBy(xpath = "//span[text()='Русский']")
    private ExtendedWebElement changeLanguageRussia;

    @FindBy(xpath = "//div[@data-cy]//a[last()][not(@target)]")
    private ExtendedWebElement nextPage;

    @FindBy(xpath = "//div[@data-cy]//a[1][not(@target)]")
    private ExtendedWebElement backPage;

    @FindBy(xpath = "./*")
    private ExtendedWebElement lotLink;

    @FindBy(xpath = "//div[@data-name='user_profile_pic']//span[text()='Н']")
    private ExtendedWebElement userImageBtn;

    public KufarHomePage(WebDriver driver) {
        super(driver);
    }

    public void closePortal() {
        portalCloseButton.click();
    }
    public void closePortal2() {
        portalCloseButton2.click();
    }

    public void loginBlockButten() {
        loginBlockButten.click();
    }

    public void openUserMenu() {
        userMenu.click();
    }

    public void openSearchField(String sf) {
        searchField.click();
        searchField.type(sf);
        searchField.sendKeys(Keys.ENTER);
    }
    public String getTextAllBelarusDtn(){
        return allBelarusBtn.getText();
    }

    public void clickNotificationsButton() {
        notificationsButton.click();
    }

    public void clickCategoryButton() {
        categoryButton.click();
    }
    public void clickChooseProduct() {
        chooseProduct.click();
    }

    public String getTextFieldResultSearch() {
        return fieldResultSearch.getText();
    }

    public void clickChangeLanguage() {
        changeLanguageBelarus.click();
        //changeLanguageRussia.click();
    }
    public void clickNextPage() {
        nextPage.scrollTo();
        nextPage.click();
        pause(2);

    }
    public void clickBackPage() {
        backPage.scrollTo();
        nextPage.click();
        backPage.click();
        pause(2);
    }
    public LotDescriptionPage openlotDescriptionPage() {
        lotLink.click();
        return new LotDescriptionPage(driver);
    }

   public LotDescriptionPage openProductPage() {
        lotLink.click();
        String originalWindow = getDriver().getWindowHandle();
        for (String windowHandle : getDriver().getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
        return new LotDescriptionPage(getDriver());
    }

    public ExtendedWebElement getUserImageBtn(){
        return userImageBtn;
    }
}