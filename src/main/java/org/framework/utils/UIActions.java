package org.framework.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

public class UIActions {

    protected UIActions() {
    }

    public static void setValue(WebElement element, String value) {
        if (value == null || Objects.equals(value, "null")) {
            return;
        }
        try {
            element.clear();
        } catch (Exception ignored) {
        }
        element.sendKeys(value);
    }

    public static void waitAndSetValue(WebElement element, String value) {
        if (value == null) {
            return;
        }

        UIActions.waitForElement(element);
        setValue(element, value);
    }

    public static void waitForElement(WebElement webElement) {
        LocalWebDriver.disableImplicitWait();
        WebElement element = LocalWebDriver.waitForElementWithDefaultTimeout()
                .until(ExpectedConditions.visibilityOf(webElement));
        LocalWebDriver.enableImplicitWait();
    }

    public static void waitAndClick(WebElement element) {
        LocalWebDriver.waitForElementWithDefaultTimeout()
                .until(ExpectedConditions.elementToBeClickable(element));
        click(element);
    }

    public static void click(WebElement element) {
        element.click();
    }
}
