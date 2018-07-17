package org.framework.pages;

import org.framework.data.TestData;
import org.framework.strings.StringsEN;
import org.framework.utils.PageBase;
import org.framework.utils.UIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class NewAccountPage {
    private final String firstName;
    private final String lastname;
    private final String username;
    private final String password;
    private final String confirmedPassword;
    private final String email;
    private final String month;
    private final String country;
    private final String day;
    private final String year;
    private final String phone;
    private final List<String> maritalStatus;
    private final List<String> hobby;
    private final String photoPath;

    NewAccountPage(AccountBuilder builder) {
        this.firstName = builder.firstname;
        this.lastname = builder.lastname;
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;
        this.country = builder.country;
        this.confirmedPassword = builder.confirmedPassword;
        this.month = builder.month;
        this.day = builder.day;
        this.year = builder.year;
        this.phone = builder.phone;
        this.maritalStatus = builder.maritalStatus;
        this.hobby = builder.hobby;
        this.photoPath = builder.photoPath;

    }

    @SuppressWarnings("UnusedReturnValue")
    public static class AccountBuilder extends PageBase{
        private String firstname;
        private String lastname;
        private String username;
        private String email;
        private String password;
        private String confirmedPassword;
        private String country;
        private String month;
        private String day;
        private String year;
        private String phone;
        private String aboutYoureself;
        private List<String> maritalStatus;
        private List<String> hobby;
        private String photoPath;

        @FindBy(id = "name_3_firstname")
        private WebElement firstNameInput;
        @FindBy(id = "name_3_lastname")
        private WebElement lastNameInput;
        @FindBy(id = "phone_9")
        private WebElement phoneInput;
        @FindBy(id = "username")
        private WebElement usernameInput;
        @FindBy(id = "email_1")
        private WebElement emailInput;
        @FindBy(id = "description")
        private WebElement aboutYourselfInput;
        @FindBy(id = "password_2")
        private WebElement passInput;
        @FindBy(id = "confirm_password_password_2")
        private WebElement confimPassInput;
        @FindBy(id = "dropdown_7")
        private WebElement countryDropbdown;
        @FindBy(id = "mm_date_8")
        private WebElement monthDropdown;
        @FindBy(id = "dd_date_8")
        private WebElement dayDropdown;
        @FindBy(id = "yy_date_8")
        private WebElement yearDropdown;
        @FindBy(name = "pie_submit")
        private WebElement button;

        By maritalStatusRadios = By.name("radio_4[]");
        By hobbyCheckboxes = By.name("checkbox_5[]");

        @FindBy(css = "label[for='checkbox_5']")
        private WebElement hobbyLabel;
        @FindBy(css = "label[for='radio_4']")
        private WebElement maritalStatusLabel;

        @FindBy(className = "piereg_message")
        private WebElement submitConfirmationMessage;
        @FindBy(css = "div[class='piereg_time date_format_field']")
        private WebElement dateOfBirthInput;

        @FindBy(id = "profile_pic_10")
        private WebElement profilePictureInput;

        @FindBy(className = "piereg_login_error")
        private WebElement submitErrorMessage;

        @FindBy(id = "piereg_passwordStrength")
        private WebElement passStreghtnessIndicator;


        public AccountBuilder(){
            super();
            baseUrl = "";
        }

        @Override
        public AccountBuilder open() {
            super.open();
            return this;
        }

        public AccountBuilder fillFirstNameInput(String firstName) {
            this.firstname = firstName;
            UIActions.setValue(firstNameInput, firstName);
            return this;
        }

        public AccountBuilder fillLastNameInput(String lastname) {
            this.lastname = lastname;
            UIActions.setValue(lastNameInput, lastname);
            return this;
        }

        public AccountBuilder fillPhoneInput(String phone){
            this.phone = phone;
            UIActions.setValue(phoneInput, phone);
            return this;
        }

        public AccountBuilder fillUsernameInput(String username) {
            this.username = username;
            UIActions.setValue(usernameInput, username);
            return this;
        }

        public AccountBuilder fillEmailInput(String email) {
            this.email = email;
            UIActions.setValue(emailInput, email);
            return this;
        }

        public AccountBuilder fillPassInput(String pass) {
            this.password = pass;
            UIActions.setValue(passInput, pass);
            return new AccountBuilder();
        }

        public AccountBuilder fillConfirmPassInput(String confirmedPassword) {
            this.confirmedPassword = confirmedPassword;
            UIActions.setValue(confimPassInput, confirmedPassword);
            return new AccountBuilder();
        }

        public AccountBuilder selectCountry(String country) {
            this.country = country;
            UIActions.selectFromDropdownByValue(countryDropbdown, country);
            return this;
        }

        public AccountBuilder selectMonth(String month) {
            this.month = month;
            UIActions.selectFromDropdownByValue(monthDropdown, month);
            return this;
        }

        public AccountBuilder selectDay(String day) {
            this.day = day;
            UIActions.selectFromDropdownByValue(dayDropdown, day);
            return this;
        }

        public AccountBuilder fillAboutYourselfInput(String text) {
            this.aboutYoureself = text;
            UIActions.setValue(aboutYourselfInput, text);
            return this;
        }

        public AccountBuilder selectYear(String year) {
            this.year = year;
            UIActions.selectFromDropdownByValue(yearDropdown, year);
            return this;
        }

        public AccountBuilder selectMaritalStatus(List<String> maritalStatus) {
            this.maritalStatus = maritalStatus;
            UIActions.selectRadioAndCheckoxByValue(maritalStatusRadios, maritalStatus);
            return this;
        }

        public AccountBuilder selectHobby(List<String> hobby) {
            this.hobby = hobby;
            UIActions.selectRadioAndCheckoxByValue(hobbyCheckboxes, hobby);
            return this;
        }

        public AccountBuilder checkSubmitConfirmationMessageIsDisplayed() {
            UIActions.waitForElement(submitConfirmationMessage);
            return this;

        }

        public AccountBuilder uploadPhoto(String photoName) {
            this.photoPath = photoName;
            String filePath = TestData.getAbsolutePath(photoName);
            UIActions.setValue(profilePictureInput, filePath);
            return this;
        }

        public AccountBuilder checkUsernameIsMandatory(Boolean isMandatory){
            Boolean status = UIActions.getElementParent(usernameInput).getAttribute("class").equals(StringsEN.ERROR_CLASS_NAME_FOR_FIELDS.getString());
            if (!isMandatory.equals(status)) {
                throw new IllegalStateException("Mandatory should be " + isMandatory + " but is: " + status + "");
            }
            return this;
        }

        public AccountBuilder checkPasswordIsMandatory(Boolean isMandatory){
            Boolean status = UIActions.getElementParent(passInput).getAttribute("class").equals(StringsEN.ERROR_CLASS_NAME_FOR_FIELDS.getString());
            if (!isMandatory.equals(status)) {
                throw new IllegalStateException("Mandatory should be " + isMandatory + " but is: " + status + "");
            }
            return this;
        }

        public String getPasswordFieldValidationMessage() {
            return UIActions.getElementParent(passInput).getText();
        }

        public AccountBuilder checkHobbyIsMandatory(Boolean isMandatory){
            Boolean status = UIActions.getElementParent(hobbyLabel).getAttribute("class").equals(StringsEN.ERROR_CLASS_NAME_FOR_FIELDS.getString());
            if (!isMandatory.equals(status)) {
                throw new IllegalStateException("Mandatory should be " + isMandatory + " but is: " + status + "");
            }
            return this;
        }

        public AccountBuilder checkMaritalStatusIsMandatory(Boolean isMandatory) {
            Boolean status = UIActions.getElementParent(maritalStatusLabel).getAttribute("class").equals(StringsEN.ERROR_CLASS_NAME_FOR_FIELDS.getString());
            if (!isMandatory.equals(status)) {
                throw new IllegalStateException("Mandatory should be " + isMandatory + " but is: " + status + "");
            }
            return this;
        }

        public AccountBuilder checkCountryIsMandatory(Boolean isMandatory) {
            Boolean status = UIActions.getElementParent(countryDropbdown).getAttribute("class").equals(StringsEN.ERROR_CLASS_NAME_FOR_FIELDS.getString());
            if (!isMandatory.equals(status)) {
                throw new IllegalStateException("Mandatory should be " + isMandatory + " but is: " + status + "");
            }
            return this;
        }

        public AccountBuilder checkDateOfBirthIsMandatory(Boolean isMandatory) {
            Boolean status = UIActions.getElementParent(dateOfBirthInput).getAttribute("class").equals(StringsEN.ERROR_CLASS_NAME_FOR_FIELDS.getString());
            if (!isMandatory.equals(status)) {
                throw new IllegalStateException("Mandatory should be " + isMandatory + " but is: " + status + "");
            }
            return this;
        }

        public AccountBuilder checkPhoneIsMandatory(Boolean isMandatory) {
            Boolean status = UIActions.getElementParent(phoneInput).getAttribute("class").equals(StringsEN.ERROR_CLASS_NAME_FOR_FIELDS.getString());
            if (!isMandatory.equals(status)) {
                throw new IllegalStateException("Mandatory should be " + isMandatory + " but is: " + status + "");
            }
            return this;
        }

        public AccountBuilder checkFirstnameIsMandatory(Boolean isMandatory) {
            Boolean status = UIActions.getElementParent(firstNameInput).getAttribute("class").equals(StringsEN.ERROR_CLASS_NAME_FOR_FIELDS.getString());
            if (!isMandatory.equals(status)) {
                throw new IllegalStateException("Mandatory should be: " + isMandatory + ", but is: " + status + "");
            }
            return this;
        }

        public AccountBuilder checkLastnameIsMandatory(Boolean isMandatory) {
            Boolean status = UIActions.getElementParent(lastNameInput).findElement(By.xpath("..")).getAttribute("class").equals(StringsEN.ERROR_CLASS_NAME_FOR_FIELDS.getString());
            if (!isMandatory.equals(status)) {
                throw new IllegalStateException("Mandatory should be " + isMandatory + " but is: " + status + "");
            }
            return this;
        }

        public AccountBuilder checkEmailIsMandatory(Boolean isMandatory) {
            Boolean status = UIActions.getElementParent(emailInput).getAttribute("class").equals(StringsEN.ERROR_CLASS_NAME_FOR_FIELDS.getString());
            if (!isMandatory.equals(status)) {
                throw new IllegalStateException("Mandatory should be " + isMandatory + " but is: " + status + "");
            }
            return this;
        }

        public AccountBuilder checkAboutYourselfIsMandatory(Boolean isMandatory) {
            Boolean status = UIActions.getElementParent(aboutYourselfInput).getAttribute("class").equals(StringsEN.ERROR_CLASS_NAME_FOR_FIELDS.getString());
            if (!isMandatory.equals(status)) {
                throw new IllegalStateException("Mandatory should be " + isMandatory + " but is: " + status + "");
            }
            return this;
        }

        public AccountBuilder checkConfirmPasswordIsMandatory(Boolean isMandatory) {
            Boolean status = UIActions.getElementParent(confimPassInput).getAttribute("class").equals(StringsEN.ERROR_CLASS_NAME_FOR_FIELDS.getString());
            if (!isMandatory.equals(status)) {
                throw new IllegalStateException("Mandatory should be " + isMandatory + " but is: " + status + "");
            }
            return this;
        }

        public AccountBuilder checkProfilePictureIsMandatory(Boolean isMandatory) {
            Boolean status = UIActions.getElementParent(profilePictureInput).getAttribute("class").equals(StringsEN.ERROR_CLASS_NAME_FOR_FIELDS.getString());
            if (!isMandatory.equals(status)) {
                throw new IllegalStateException("Mandatory should be " + isMandatory + " but is: " + status + "");
            }
            return this;
        }

        public String getSubmitErrorMessage(){
            UIActions.waitForElement(submitErrorMessage);
            return submitErrorMessage.getText();
        }

        public String getPasswordStrenghtness() {
            UIActions.click(confimPassInput);
            UIActions.waitForElement(passStreghtnessIndicator);
            return passStreghtnessIndicator.getAttribute("class");
        }

        public AccountBuilder submit() {
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].scrollIntoView()", button);
            UIActions.click(button);
            return new AccountBuilder();
        }
    }
}
