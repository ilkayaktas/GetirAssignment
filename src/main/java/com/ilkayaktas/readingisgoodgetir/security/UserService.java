package com.ilkayaktas.readingisgoodgetir.security;

import com.ilkayaktas.readingisgoodgetir.model.db.Customer;
import com.ilkayaktas.readingisgoodgetir.service.customer.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * This class is used for user provider for authentication process.
 */

@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {
   @Autowired
   private final CustomerService customerService;

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Customer customer = customerService.findByUsername(username);

      if (customer == null){
         throw new UsernameNotFoundException("User not found!");
      } else{
         return customer;
      }
   }
}
