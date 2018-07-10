package org.framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public final class LocalWebDriver {

    static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static void setBaseUrl(String url) {
        baseUrl = url;
    }

    private static String baseUrl = "";

    private LocalWebDriver() {
    }

    public static WebDriver get() {
        return webDriver.get();
    }

    public static void quit() {
        get().quit();
    }

    public static void openWithBaseUrl(String url) {
        get().get(baseUrl + url);
    }

    private static void set(WebDriver driver) {
        webDriver.set(driver);
    }

    public static void create() {
        set(WebdriverFactory.createInstance());
    }

    public static void disableImplicitWait() {
        get().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public static WebDriverWait waitForElementWithDefaultTimeout() {
        return waitForElement(60);
    }

    public static WebDriverWait waitForElement(int timeOut) {
        return new WebDriverWait(get(), timeOut);
    }

    public static void enableImplicitWait() {
        get().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
}
