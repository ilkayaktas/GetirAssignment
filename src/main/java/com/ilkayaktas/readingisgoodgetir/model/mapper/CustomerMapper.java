package com.ilkayaktas.readingisgoodgetir.model.mapper;

import com.ilkayaktas.readingisgoodgetir.model.db.Customer;
import com.ilkayaktas.readingisgoodgetir.model.rest.RestCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Created by ilkayaktas on 6.02.2022 at 17:56.
 */

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source = "hashedPassword", target = "password")
    RestCustomer toRestCustomer(Customer customer);

    @Mapping(expression = "java(new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().encode(restCustomer.getPassword()))", target = "hashedPassword")
    Customer toCustomer(RestCustomer restCustomer);
}
