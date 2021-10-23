package com.qaprosoft.carina.demo.kufar;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.gui.pages.kufar.KufarHomePage;
import com.qaprosoft.carina.demo.gui.pages.kufar.RealPropertyPage;
import com.qaprosoft.carina.demo.gui.utils.enums.FilterProperty;
import com.qaprosoft.carina.demo.gui.utils.enums.NamePageTopMenu;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.util.Set;

public class RealPropertyKufarTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    KufarHomePage kufarHomePage = new KufarHomePage(getDriver());

    @BeforeClass
    public void openHomePage() {
        kufarHomePage.open();
        kufarHomePage.closePortal();
        kufarHomePage.closePortal2();
        RealPropertyPage realPropertyPage = new RealPropertyPage(getDriver());
        realPropertyPage.clickRealPropertyBtn();
    }

    @Test
    public void testSwitchOnIncognitoPage() {
        RealPropertyPage realPropertyPage = new RealPropertyPage(getDriver());
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://re.kufar.by/");
        //String windowParent = getDriver().getWindowHandle();
        realPropertyPage.incognitoPage();
        //getDriver().switchTo().window(realPropertyPage.nextWindowHandle(getDriver()));

        // getDriver().switchTo().window(windowParent);

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://re.kufar.by/");
        pause(2);
    }

    @Test
    public void testSwitchBetweenTabs() {
        RealPropertyPage realPropertyPage = new RealPropertyPage(getDriver());
        Assert.assertEquals(realPropertyPage.getTextNamePage(NamePageTopMenu.BUILDINGS.getNamePage()), NamePageTopMenu.BUILDINGS.getNamePage());
        pause(3);
        //String pageSours = realPropertyPage.getDriver().getPageSource();
        //System.out.println(pageSours);
        System.out.println(getDriver().getTitle().length());

        realPropertyPage.clickFirsOfferOnThePage();
        String windowParent = getDriver().getWindowHandle();
        getDriver().switchTo().window(realPropertyPage.nextWindowHandle(getDriver()));
        Assert.assertEquals(realPropertyPage.getTextSectionName(), "Новостройки в Минске");
        getDriver().close();

        getDriver().switchTo().window(windowParent);
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://re.kufar.by/");
    }

    @Test(dataProvider = "SingleDataProvider")
    @XlsDataSourceParameters(path = "xls/demo.xlsx", sheet = "listBuildings", dsUid = "TUID", dsArgs = "propertyType")
    public void testChoosePropertyPopupMenu(String typeProperty) {
        RealPropertyPage realPropertyPage = new RealPropertyPage(getDriver());
        realPropertyPage.clickChoosePropertyBtn();
        realPropertyPage.clickChoosePropertyType(typeProperty);
    }

    //test with use XML parametrization
    @Test
    @Parameters({"currency"})
    public void testFieldPriceForFilterProperty(String currency) {
        RealPropertyPage realPropertyPage = new RealPropertyPage(getDriver());
        realPropertyPage.clickPriceBtn(FilterProperty.PRICE.getFieldName());
        realPropertyPage.clickCurrencyBtn();
        realPropertyPage.clickCurrency(currency);
        Assert.assertEquals(realPropertyPage.getTextCurrencyBtn(currency), currency);
    }

    @Test(dataProvider = "DP1")
    public void testFieldRoomForFilterProperty(String numRooms) {
        RealPropertyPage realPropertyPage = new RealPropertyPage(getDriver());
        realPropertyPage.clickRoomBtn(FilterProperty.ROOM.getFieldName());
        realPropertyPage.clickNumbersRoom(numRooms);
        Assert.assertEquals(realPropertyPage.getTextNumberRoom(numRooms), numRooms);
    }

    @DataProvider(parallel = false, name = "DP1")
    public static Object[][] dataprovider() {
        return new Object[][]{
                {"1"},
                {"2"},
                {"3"},
                {"4"},
                {"5+"}
        };
    }
}
