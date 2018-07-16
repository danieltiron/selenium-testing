package org.framework.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.test.utils.TestBase;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;


public class TestData {

    public static String getRandomSuffix(){
        return String.format("_%d%s", System.currentTimeMillis(), getRandomString(4));
    }

    private static String getRandomString(int stringLength) {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < stringLength; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    public static String getAbsolutePath(String fileName) {
        String workingDir = System.getProperty("user.dir");
        return workingDir + "/src/main/resources/" + fileName;
    }

    public static User getUserById(String userId, String file) {
        ObjectMapper mapper = new ObjectMapper();
        User userObj = null;
        try {
            User[] user = mapper.readValue(new File(getAbsolutePath(file)), User[].class);
            for (User anUser : user) {
                if (Objects.equals(anUser.id, userId)) {
                    userObj = anUser;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userObj;
    }

    public static String getRandomEmail(String email) {
        String randomizedEmail = "";
        if (email.contains("@")) {
            randomizedEmail = email.replace("@", TestBase.randomSuffix + "@");
        }
        return randomizedEmail;
    }
}