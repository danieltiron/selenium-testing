package org.framework.data;

import lombok.Getter;
import org.test.utils.TestBase;

import java.util.List;

public class User {

    public @Getter
    String id;
    public @Getter
    String lastName;
    public @Getter
    String firstName;
    public @Getter
    String phoneNumber;
    public @Getter
    String country;
    public @Getter
    String day;
    public @Getter
    String month;
    public @Getter
    String year;
    public @Getter
    String pass;
    public @Getter
    String confirmedPass;
    public @Getter
    List<String> maritalStatus;
    public @Getter
    List<String> hobby;
    public @Getter
    String photo;
    public @Getter
    String aboutYourself;
    private String email;
    private String username;

    public String getEmail() {
        return TestData.getRandomEmail(email);
    }

    public String getUsername() {
        return username + TestBase.randomSuffix;
    }
}
