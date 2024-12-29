package com.ecommerce.admin.utils;

import com.common.entity.User;

import java.util.HashSet;
import java.util.Random;

public final class TestUtils {
    public static String generateText(int length) {
        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            result.append(CHARACTERS.charAt(index));
        }
        return result.toString();
    }

    public static User mockUser() {
        String firstName = TestUtils.generateText(5);
        String lastName = TestUtils.generateText(5);
        String mockEmail = TestUtils.generateText(5) + "@gmail.com";
        String password = TestUtils.generateText(10);
        return User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(mockEmail)
                .password(password)
                .roles(new HashSet<>())
                .build();
    }
}
