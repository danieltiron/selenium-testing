package org.test;

import org.framework.pages.NewAccountPage;

import org.test.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;


public class TestRegisterPage extends TestBase{

    @Test
    public void testCreateNewAccount() {
        new NewAccountPage.AccountBuilder()
                .open()
                .fillFirstNameInput("gogu")
                .fillLastNameInput("gigi")
                .fillPhoneInput("0765555544")
                .fillUsernameInput("testuser" + randomSuffix)
                .fillEmailInput("testEmail" + randomSuffix + "@gmail.com")
                .selectCountry("Algeria")
                .selectDay("22")
                .selectMonth("7")
                .selectYear("1984")
                .fillPassInput("test123!@#")
                .fillConfirmPassInput("test123!@#")
                .selectMaritalStatus("Married")
                .selectHobby("Dance")
                .selectHobby("Reading")
                .uploadPhoto("logo_packer.png")
                .fillAboutYourselfInput("dasd as dsad dsa sad sad das asd sa ")
                .submit()
                .checkSubmitConfirmationMessageIsDisplayed();

    }

    @Test
    public void testMandatoryFieldsAreCorrect() {
        new NewAccountPage.AccountBuilder()
                .open()
                .submit()
                .checkFirstnameIsMandatory(true)
                .checkLastnameIsMandatory(true)
                .checkMaritalStatusIsMandatory(false)
                .checkHobbyIsMandatory(true)
                .checkCountryIsMandatory(false)
                .checkDateOfBirthIsMandatory(false)
                .checkPhoneIsMandatory(true)
                .checkUsernameIsMandatory(true)
                .checkEmailIsMandatory(true)
                .checkProfilePictureIsMandatory(false)
                .checkAboutYourselfIsMandatory(false)
                .checkPasswordIsMandatory(true)
                .checkConfirmPasswordIsMandatory(true);
    }


    @Test(dependsOnMethods={"testCreateNewAccount"})
    public void testCantCreateAccountWithSameEmail() {
        String errorMessage = new NewAccountPage.AccountBuilder()
                .open()
                .fillFirstNameInput("gogu")
                .fillLastNameInput("gigi")
                .selectHobby("Dance")
                .fillPhoneInput("0765555544")
                .fillUsernameInput("anothertestuser" + randomSuffix)
                .fillEmailInput("testEmail" + randomSuffix + "@gmail.com")
                .fillPassInput("test123!@#")
                .fillConfirmPassInput("test123!@#")
                .submit()
                .getSubmitErrorMessage();
        Assert.assertTrue(errorMessage.contains("E-mail address already exists"));
    }

    @Test
    public void testPasswordUnder8Characters(){
        String errorMessage = new NewAccountPage.AccountBuilder()
                .open()
                .fillPassInput("1234567")
                .submit()
                .getPasswordFieldValidationMessage();
        Assert.assertTrue(errorMessage.contains("Minimum 8 characters required"));
    }

    @Test
    public void testPasswordIsVeryWeek() {
        String passStr = new NewAccountPage.AccountBuilder()
                .open()
                .fillPassInput("12345678")
                .getPasswordStrenghtness();
        Assert.assertTrue(passStr.contains("pass_v_week"));
    }
}
