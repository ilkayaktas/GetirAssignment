package com.ilkayaktas.readingisgoodgetir.model.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by ilkayaktas on 06.02.2022 at 16:28.
 * According to this validation, password size should be minimum 4 characters.
 */

public class PasswordCriteriaValidator implements ConstraintValidator<PasswordCriteria, String> {
   private static final int PASSWORD_LENGTH = 4;
   private String message;

   @Override
   public void initialize(PasswordCriteria constraintAnnotation) {
      message = constraintAnnotation.message();
   }

   @Override
   public boolean isValid(String password, ConstraintValidatorContext context) {

      if (password.length() < PASSWORD_LENGTH) return false;
      return true;
   }

}