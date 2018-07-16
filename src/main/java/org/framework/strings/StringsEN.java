package org.framework.strings;

public enum StringsEN {

    //strings for resistration page
    EMAIL_ALREADY_EXISTS_ERROR("E-mail address already exists"),
    MINIMUM_8_CHARACTERS_PASS_ERROR("Minimum 8 characters required"),
    PASS_VERY_WEEK("pass_v_week"),

    //strings for login page
    LOGGED_INTO_SECURE_AREA_MESSAGE("You logged into a secure area!");

    private String string;

    StringsEN(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
