package com.ilkayaktas.readingisgoodgetir.model.rest;

import com.ilkayaktas.readingisgoodgetir.model.validator.EmailCriteria;
import com.ilkayaktas.readingisgoodgetir.model.validator.PasswordCriteria;
import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * Created by ilkayaktas on 06.02.2022 at 16:28.
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RestCustomer {
   private Long id;
   @NotBlank(message = "Name can't be empty!")
   private String name;
   @EmailCriteria(message = "Email is not valid!")
   @NotBlank(message = "Email can't be empty!")
   private String email;
   @PasswordCriteria(message = "Password is not valid. It should be minimum 4 characters")
   @NotBlank(message = "Password can't be empty!")
   private String password;
   @NotBlank(message = "Username can't be empty!")
   private String username;
   @NotBlank(message = "Address can't be empty!")
   private String address;
}
