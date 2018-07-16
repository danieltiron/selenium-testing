package org.framework.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
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

    public static void selectFromDropdownByValue(WebElement element, String value) {
        if (value == null) {
            return;
        }
        element.findElement(By.cssSelector("option[value='" + value + "']")).click();
    }

    public static void selectRadioAndCheckoxByValue(By element, List<String> value) {
        if (value == null) {
            return;
        }

        List<WebElement> radios = LocalWebDriver.get().findElements(element);
        for (WebElement radio:radios){
            for (String anyValue : value) {
                if (radio.getAttribute("value").contains(anyValue.toLowerCase())) {
                    radio.click();
                }
            }
        }
    }

    public static WebElement getElementParent(WebElement element) {
        return element.findElement(By.xpath(".."));
    }

}
