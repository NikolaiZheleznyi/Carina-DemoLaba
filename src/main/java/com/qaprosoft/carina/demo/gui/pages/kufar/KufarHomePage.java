package com.qaprosoft.carina.demo.gui.pages.kufar;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.lang.invoke.MethodHandles;
import java.util.LinkedList;
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

    @FindBy(xpath = "//h3[contains(text(), '%s')]")
    private List<ExtendedWebElement> searchResult;

    @FindBy(xpath = "//button[@type='button']//span[text()='Уся Беларусь']")
    private ExtendedWebElement allBelarusBtn;

    @FindBy(xpath = "//a[@target='_blank']//h3[contains(text(), '%s')]")
    private ExtendedWebElement fieldResultSearch;

    @FindBy(xpath = "//div[@data-name='notification_icon']")
    private ExtendedWebElement notificationsButton;

    @FindBy(xpath = "//div[@data-name='megamenu']//button")
    private ExtendedWebElement categoryButton;

    @FindBy(xpath = "//span[text()='%s']")
    private ExtendedWebElement changeLanguage;

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

    public void refresh(){driver.get("www.kufar.by");}

    public void closePortal() {
        portalCloseButton.clickIfPresent();
    }
    public void closePortal2() {
        portalCloseButton2.clickIfPresent();
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
    public List<String> getSearchResult(String itemName){
        List<String> itemTextList = new LinkedList<>();
        for (ExtendedWebElement item:searchResult
             ) {itemTextList.add(item.format(itemName).getText());}
        return itemTextList;
    }
    public void AssertSearchResult(String item){
        List<String> itemsList = getSearchResult(item);
        for(String checkItems : itemsList){
            Assert.assertTrue(checkItems.contains(item));
        }
    }
    public String getTextAllBelarusDtn(){
        return allBelarusBtn.getText();
    }

    public void clickNotificationsButton() {
        notificationsButton.click();
    }


    public String getTextFieldResultSearch(String request) {
        return fieldResultSearch.format(request).getText();
    }

    public void clickChangeLanguage(String name) {
        changeLanguage.format(name).click();

    }

    public void clickNextPage() {

        nextPage.click();
        pause(2);

    }
    public void clickBackPage() {

        backPage.click();
        pause(2);
    }
    public LotDescriptionPage openlotDescriptionPage() {
        lotLink.clickIfPresent();
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