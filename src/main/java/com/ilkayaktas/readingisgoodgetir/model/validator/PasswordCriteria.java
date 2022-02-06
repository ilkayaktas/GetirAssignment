package com.ilkayaktas.readingisgoodgetir.model.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ilkayaktas on 06.02.2022 at 16:28.
 * Password verification annotation
 */

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordCriteriaValidator.class)
public @interface PasswordCriteria {
   String message() default "";
   Class<?>[] groups() default {};
   Class<? extends Payload>[] payload() default {};
}