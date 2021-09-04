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
    public void testPlus() {
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
    @Test()
    public void testMinus() {
        Number number = new Number(getDriver());
        pause(3);
        number.chooseDigit("9");
        number.chooseDigit("4");

        Simbol simbol = new Simbol(getDriver());
        simbol.clickMinus();

        number.chooseDigit("7");
        number.chooseDigit("6");

        simbol.clickEqual();
        pause(2);

        Display display = new Display(getDriver());
        display.getResultField();
        Assert.assertEquals(display.getResultField(), "18", "Incorrect answer");
    }
    @Test()
    public void testDivied() {
        Number number = new Number(getDriver());
        pause(3);
        number.chooseDigit("9");

        Simbol simbol = new Simbol(getDriver());
        simbol.clickDivied();

        number.chooseDigit("2");

        simbol.clickEqual();
        pause(2);

        Display display = new Display(getDriver());
        display.getResultField();
        Assert.assertEquals(display.getResultField(), "4.5", "Incorrect answer");
    }
    @Test()
    public void testMultiply() {
        Number number = new Number(getDriver());
        pause(3);
        number.chooseDigit("5");

        Simbol simbol = new Simbol(getDriver());
        simbol.clickMultiply();

        number.chooseDigit("6");

        simbol.clickEqual();
        pause(2);

        Display display = new Display(getDriver());
        display.getResultField();
        Assert.assertEquals(display.getResultField(), "30", "Incorrect answer");
    }

    @Test()
    public void testDelete_DividesZero() {
        Number number = new Number(getDriver());
        pause(3);
        number.chooseDigit("9");
        number.chooseDigit("4");

        Simbol simbol = new Simbol(getDriver());
        simbol.clickDelete();
        simbol.clickDelete();

        number.chooseDigit("7");
        number.chooseDigit("6");

        simbol.clickDivied();
        number.chooseDigit("0");

        simbol.clickEqual();
        pause(2);

        Display display = new Display(getDriver());
        display.getNoResult();
        Assert.assertEquals(display.getNoResult(), "Can't divide by 0", "Incorrect answer");
    }

}
