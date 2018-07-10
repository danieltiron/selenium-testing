package org.framework.pages;

import org.framework.utils.PageBase;
import org.framework.utils.UIActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecureAreaPage extends PageBase{
    @FindBy(css = "a[class='button secondary radius']")
    private WebElement logoutButton;
    @FindBy(css = "div[class='flash success']")
    private WebElement successMessageElement;

    public SecureAreaPage(){
        super();
        baseUrl = "/secure";
    }

    @Override
    public SecureAreaPage open() {
        super.open();
        return this;
    }

    public SecureAreaPage checkSuccessLoginMessageIsPresent(){
        UIActions.waitForElement(successMessageElement);
        return this;
    }

    public String getSuccessMessageText(){
        return successMessageElement.getText();
    }

    public LoginPage clickLogout() {
        UIActions.waitAndClick(logoutButton);
        return new LoginPage();
    }
}
