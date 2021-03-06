package com.ilkayaktas.readingisgoodgetir.model.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by ilkayaktas on 9.02.2022 at 14:36.
 */

public class StockCountCriteriaValidator implements ConstraintValidator<StockCountCriteria, Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null ) return false;
        return value >= 0;
    }
}
