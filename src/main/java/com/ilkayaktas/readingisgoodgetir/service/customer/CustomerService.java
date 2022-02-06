package com.ilkayaktas.readingisgoodgetir.service.customer;

import com.ilkayaktas.readingisgoodgetir.model.db.Customer;

/**
 * Created by ilkayaktas on 6.02.2022 at 00:40.
 */

public interface CustomerService {
    Customer findByUsername(String username);
}
