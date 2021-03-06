package org.test;


import org.framework.pages.LoginPage;
import org.framework.strings.StringsEN;
import org.test.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginPage extends TestBase {
    @Test
    public void testLoginWithValidData(){
        new LoginPage()
                .openAndLoginAs("tomsmith", "SuperSecretPassword!")
                .checkSuccessLoginMessageIsPresent();
    }

    @Test
    public void testLoginWithIncorrectUsername(){
        new LoginPage()
                .openAndLoginWithError("johnsmith", "SuperSecretPassword!")
                .checkErrorLoginMessageIsPresent();
    }

    @Test
    public void testLoginWithIncorrectPassword(){
        new LoginPage()
                .openAndLoginWithError("tomsmith", "supersecretpassword!")
                .checkErrorLoginMessageIsPresent();
    }

    @Test
    public void testSuccesMessageAfterLoginIsCorect(){
        String successMessage = new LoginPage()
                .openAndLoginAs("tomsmith", "SuperSecretPassword!")
                .getSuccessMessageText();
        Assert.assertTrue(successMessage.contains(StringsEN.LOGGED_INTO_SECURE_AREA_MESSAGE.getString()));
    }

    @Test
    public void testLogout(){
        new LoginPage()
                .openAndLoginAs("tomsmith", "SuperSecretPassword!")
                .clickLogout()
                .checkMessageAfterLogoutIsPresent();
    }
}