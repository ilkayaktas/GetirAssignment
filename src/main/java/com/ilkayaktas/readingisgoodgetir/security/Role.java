package com.ilkayaktas.readingisgoodgetir.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

/**
 * This class is used for spring security role data. ADMIN and USER roles are created in code
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements GrantedAuthority {
   private String role;

   @Override
   public String getAuthority() {
      return role;
   }
}
