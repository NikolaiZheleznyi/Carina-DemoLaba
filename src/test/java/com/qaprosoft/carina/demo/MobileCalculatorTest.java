package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mobile.gui.pages.ComponentCalc.Display;
import com.qaprosoft.carina.demo.mobile.gui.pages.ComponentCalc.Number;
import com.qaprosoft.carina.demo.mobile.gui.pages.ComponentCalc.Simbol;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileCalculatorTest implements IAbstractTest {

    @Test()
    public void testCalc() {
        Number number = new Number(getDriver());
        pause(3);
        number.chooseDigit("2");
        number.clickPoint();
        number.chooseDigit("4");

        Simbol simbol = new Simbol(getDriver());
        simbol.clickPlus();

        number.chooseDigit("7");
        number.clickPoint();
        number.chooseDigit("6");

        simbol.clickEqual();
        pause(4);

        Display display = new Display(getDriver());
        display.getResultField();
        Assert.assertEquals(display.getResultField(), "10", "Error");



    }


}
