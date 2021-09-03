package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class TestP extends AbstractPage {
    public TestP(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://qaprosoft.s3-us-west-2.amazonaws.com/carinademoexample.apk");
    }


}
