package com.lms.librarymanagementsystem.Handlers;

import java.util.Random;

public class OtpHandler {
    public static String generateOTP(int length) {
        Random rand = new Random();
        int min = (int) Math.pow(10, length - 1);
        int max = (int) Math.pow(10, length) - 1;
        Integer otp=rand.nextInt(max - min + 1) + min;
        return Integer.toString(otp);
    }
}
