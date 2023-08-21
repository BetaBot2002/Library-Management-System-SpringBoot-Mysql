package com.lms.librarymanagementsystem.Handlers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptionHandlers {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String encodePassword(String password) {
        return encoder.encode(password);
    }

    public static boolean matches(String password, String encodedPassword) {
        return encoder.matches(password, encodedPassword);
    }
}
