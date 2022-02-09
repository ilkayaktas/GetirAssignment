package com.ilkayaktas.readingisgoodgetir.repository;

import com.ilkayaktas.readingisgoodgetir.model.db.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by ilkayaktas on 6.02.2022 at 23:11.
 */

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Optional<Customer> findByUsername(String username);
    Optional<Customer> findByUsernameOrEmail(String username, String email);
}
