package com.example.drugaparcijala.utils;

import java.util.regex.Pattern;

public class Validators {
    public static void checkRequiredField(String content, String fieldName) {
        if (content.isBlank()) throw new IllegalStateException(fieldName + " is required");
    }

    public static void checkMaxLength(String content, int length, String fieldName) {
        if (content.length() > length) throw new IllegalStateException(fieldName + " cannot be longer than " + length + " characters");
    }

    public static void checkNumber(String content, String fieldName) {
        Float broj = Float.parseFloat(content);
        if (broj <= 0) throw new IllegalStateException(fieldName + " must be positive");
    }
}
