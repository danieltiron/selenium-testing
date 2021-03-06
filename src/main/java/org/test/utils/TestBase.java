package org.test.utils;

import org.framework.data.TestData;
import org.framework.utils.LocalWebDriver;
import org.framework.utils.WebdriverFactory;
import org.testng.Reporter;
import org.testng.annotations.*;

public class TestBase {

    public static String randomSuffix;

    @Parameters({"browserName", "appUrl"})
    @BeforeSuite
    public void setupDriver(@Optional("chrome") String browserName, @Optional("http://demoqa.com/registration/") String appUrl){
        LocalWebDriver.setBaseUrl(appUrl);
        WebdriverFactory.browserName = browserName;
        randomSuffix = TestData.getRandomSuffix();
        Reporter.log("Random suffix used: " + randomSuffix, true);

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
