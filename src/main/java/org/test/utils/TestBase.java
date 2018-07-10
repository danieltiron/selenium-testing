package org.test.utils;

import org.framework.utils.LocalWebDriver;
import org.framework.utils.WebdriverFactory;
import org.testng.annotations.*;

public class TestBase {

    @Parameters({"browserName", "appUrl"})
    @BeforeSuite
    public void setupDriver(@Optional("chrome") String browserName, @Optional("http://the-internet.herokuapp.com/login") String appUrl){
        LocalWebDriver.setBaseUrl(appUrl);
        WebdriverFactory.browserName = browserName;
    }

    @BeforeMethod
    public void methodSetup() {
        LocalWebDriver.create();
    }

    @AfterMethod
    public void teardown() {
        LocalWebDriver.quit();
    }
}
