package com.ilkayaktas.readingisgoodgetir.model.validator;

import com.ilkayaktas.readingisgoodgetir.model.db.Customer;
import com.ilkayaktas.readingisgoodgetir.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

/**
 * Created by ilkayaktas on 9.02.2022 at 13:48.
 */

public class UsernameAndEmailUniqueCriteriaValidator implements ConstraintValidator<UsernameAndEmailUniqueCriteria, String> {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Optional<Customer> byUsername =  customerRepository.findByUsernameOrEmail(value, value);
        return byUsername.isEmpty();
    }
}
