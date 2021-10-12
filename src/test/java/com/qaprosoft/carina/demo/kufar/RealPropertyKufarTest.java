package com.qaprosoft.carina.demo.kufar;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.gui.pages.kufar.KufarHomePage;
import com.qaprosoft.carina.demo.gui.pages.kufar.RealPropertyPage;
import com.qaprosoft.carina.demo.gui.utils.enums.FilterProperty;
import com.qaprosoft.carina.demo.gui.utils.enums.NamePageTopMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class RealPropertyKufarTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    KufarHomePage kufarHomePage = new KufarHomePage(getDriver());

    @BeforeClass
    public void openHomePage() {
        kufarHomePage.open();
        kufarHomePage.closePortal();
        kufarHomePage.closePortal2();
        RealPropertyPage realPropertyPage = new RealPropertyPage(getDriver());
        realPropertyPage.clickRealPropertyBtn();}

    @Test
    public void testGoingOnBuildingsPage(){
        RealPropertyPage realPropertyPage = new RealPropertyPage(getDriver());
        Assert.assertEquals(realPropertyPage.getTextNamePage(NamePageTopMenu.BUILDINGS.getNamePage()), NamePageTopMenu.BUILDINGS.getNamePage());
        pause(3);
    }

    @Test(dataProvider = "SingleDataProvider")
    @XlsDataSourceParameters(path = "xls/demo.xlsx", sheet = "listBuildings", dsUid = "TUID", dsArgs = "propertyType")
    public void testChoosePropertyPopupMenu(String typeProperty){
        RealPropertyPage realPropertyPage = new RealPropertyPage(getDriver());
        realPropertyPage.clickChoosePropertyBtn();
        realPropertyPage.clickChoosePropertyType(typeProperty);
    }
    //test with use XML parametrization
    @Test
    @Parameters({"currency"})
    public void testFieldPriceForFilterProperty(String currency){
        RealPropertyPage realPropertyPage = new RealPropertyPage(getDriver());
        realPropertyPage.clickPriceBtn(FilterProperty.PRICE.getFieldName());
        realPropertyPage.clickCurrencyBtn();
        realPropertyPage.clickCurrency(currency);
        Assert.assertEquals(realPropertyPage.getTextCurrencyBtn(currency), currency);
    }

    @Test(dataProvider = "DP1")
    public void testFieldRoomForFilterProperty(String numRooms){
        RealPropertyPage realPropertyPage = new RealPropertyPage(getDriver());
        realPropertyPage.clickRoomBtn(FilterProperty.ROOM.getFieldName());
        realPropertyPage.clickNumbersRoom(numRooms);
        Assert.assertEquals(realPropertyPage.getTextNumberRoom(numRooms), numRooms);
    }
    @DataProvider(parallel = false, name = "DP1")
    public static Object[][] dataprovider(){
        return new Object[][]{
                {"1"},
                {"2"},
                {"3"},
                {"4"},
                {"5+"}
        };
    }
}
