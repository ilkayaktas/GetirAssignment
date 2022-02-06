package com.ilkayaktas.readingisgoodgetir.model.validator;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * Created by ilkayaktas on 06.02.2022 at 16:28.
 * This validation is used to check if an email is valid or not
 */

public class EmailCriteriaValidator implements ConstraintValidator<EmailCriteria, String> {
    private static final int PASSWORD_LENGTH = 4;
    private String message;
    public String emailValidationPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public void initialize(EmailCriteria constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {

        if ( !Pattern.compile(emailValidationPattern)
                .matcher(email)
                .matches()){
            System.out.println("Email is not valid");
            return false;
        }

        return true;
    }


}