package com.wladek.pension.validator;

/**
 * Created by george on 12/8/15.
 */

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.springframework.stereotype.Component;

@Component("emailValidator")

public class EmailValidator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public EmailValidator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    public boolean valid(final String email) {

        matcher = pattern.matcher(email);
        return matcher.matches();

    }
}
