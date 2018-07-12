package org.framework.data;

import java.util.Random;

public class TestData {
    private static String randomSuffix = "";

    public static String getRandomSuffix(){
        return randomSuffix = String.format("_%d%s", System.currentTimeMillis(), getRandomString(4));
    }


    public static String getRandomString(int stringLength) {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < stringLength; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }
}