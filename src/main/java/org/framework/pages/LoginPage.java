package org.framework.pages;

import org.framework.utils.PageBase;
import org.framework.utils.UIActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("UnusedReturnValue")
public class LoginPage extends PageBase{
    @FindBy(id = "username")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(tagName = "button")
    private WebElement loginButton;
    @FindBy(css = "div[class='flash error']")
    private WebElement loginErrorMessage;
    @FindBy(css = "div[class='flash success']")
    private WebElement messageAfterLogout;

    public LoginPage(){
        super();
        baseUrl = "";
    }

    @Override
    public LoginPage open() {
        super.open();
        return this;
    }

    public void login(String username, String password){
        UIActions.waitAndSetValue(usernameInput, username);
        UIActions.waitAndSetValue(passwordInput, password);
        UIActions.waitAndClick(loginButton);
    }

    public SecureAreaPage openAndLoginAs(String username, String password){
        open();
        login(username, password);
        return new SecureAreaPage();
    }

    public LoginPage openAndLoginWithError(String username, String password) {
        this.open();
        this.login(username, password);
        return new LoginPage();
    }

    public LoginPage checkErrorLoginMessageIsPresent(){
        UIActions.waitForElement(loginErrorMessage);
        return this;
    }

    public LoginPage checkMessageAfterLogoutIsPresent(){
        UIActions.waitForElement(messageAfterLogout);
        return this;
    }
}
