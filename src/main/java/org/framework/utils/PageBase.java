package org.framework.utils;

import org.framework.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
    protected WebDriver driver = LocalWebDriver.get();

    protected String baseUrl = "";

    public PageBase() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Opens the current page in the browser.
     *
     * @return current page
     */
    protected PageBase open() {
        LocalWebDriver.openWithBaseUrl(baseUrl);
        return this;
    }

    protected PageBase openAndLoginAs(String userName, String password) {
        open();
        new LoginPage().login(userName, password);
        return this;
    }
}
