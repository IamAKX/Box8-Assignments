package com.application.akash.assignment1.utilities;

public class Constants {
    public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    public static final String PASSWORD_PATTERN = "^(?=.*?\\p{Lu})(?=.*?[\\p{L}&&[^\\p{Lu}]])(?=.*?\\d)(?=.*?[`~!@#$%^&*()\\-_=+\\\\\\|\\[{\\]};:'\",<.>/?]).*$";

    public static final String PHONE_PATTERN = "[0-9]+";
}
