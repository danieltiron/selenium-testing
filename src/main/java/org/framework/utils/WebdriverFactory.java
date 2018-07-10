package org.framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebdriverFactory {
    public static String browserName;

    static WebDriver createInstance() {
        WebDriver driver;
        if (browserName.toLowerCase().contains("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            return driver;
        }
        return null;
    }
}
