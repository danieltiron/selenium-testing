package org.test;

import org.framework.data.TestData;
import org.framework.data.User;
import org.framework.pages.NewAccountPage;
import org.test.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestRegisterPage extends TestBase{
    private User validUser = TestData.getUserById("validUser", "users.json");
    private User userWithExistingEmail = TestData.getUserById("userWithExistingEmail", "users.json");

    @Test
    public void testCreateNewAccount() {
        new NewAccountPage.AccountBuilder()
                .open()
                .fillFirstNameInput(validUser.firstName)
                .fillLastNameInput(validUser.lastName)
                .fillPhoneInput(validUser.phoneNumber)
                .fillUsernameInput(validUser.getUsername())
                .fillEmailInput(validUser.getEmail())
                .selectCountry(validUser.country)
                .selectDay(validUser.day)
                .selectMonth(validUser.month)
                .selectYear(validUser.year)
                .fillPassInput(validUser.pass)
                .fillConfirmPassInput(validUser.confirmedPass)
                .selectMaritalStatus(validUser.maritalStatus)
                .selectHobby(validUser.hobby)
                .uploadPhoto(validUser.photo)
                .fillAboutYourselfInput(validUser.aboutYourself)
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

    @Test(dependsOnMethods = "testCreateNewAccount")
    public void testCantCreateAccountWithSameEmail() {
        String errorMessage = new NewAccountPage.AccountBuilder()
                .open()
                .fillFirstNameInput(userWithExistingEmail.firstName)
                .fillLastNameInput(userWithExistingEmail.lastName)
                .selectHobby(userWithExistingEmail.hobby)
                .fillPhoneInput(userWithExistingEmail.phoneNumber)
                .fillUsernameInput(userWithExistingEmail.getUsername())
                .fillEmailInput(validUser.getEmail())
                .fillPassInput(userWithExistingEmail.pass)
                .fillConfirmPassInput(userWithExistingEmail.confirmedPass)
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
