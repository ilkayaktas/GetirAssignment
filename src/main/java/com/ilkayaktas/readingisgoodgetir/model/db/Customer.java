package com.ilkayaktas.readingisgoodgetir.model.db;

import com.ilkayaktas.readingisgoodgetir.security.Role;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Customer implements Serializable, UserDetails {

  private static final long serialVersionUID = 432154291451321L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(name = "name")
  String name;

  @NotNull
  @Email
  @Column(name = "email")
  String email;

  @NotNull
  @Column(name = "password")
  String hashedPassword;

  @NotNull
  @Column(name = "username")
  String username;

  @NotNull
  @Column(name = "address")
  String address;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((address == null) ? 0 : address.hashCode());
    result = prime * result + ((username == null) ? 0 : username.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Customer other = (Customer) obj;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (address == null) {
      if (other.address != null)
        return false;
    } else if (!address.equals(other.address))
      return false;
    if (username == null) {
      if (other.username != null)
        return false;
    } else if (!username.equals(other.username))
      return false;
    if (hashedPassword == null) {
      if (other.hashedPassword != null)
        return false;
    } else if (!hashedPassword.equals(other.hashedPassword))
      return false;
    return true;
  }


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    // All customers have USER role, admin user has ADMIN role additionally.
    Set<Role> roles = new HashSet<>();
    if (username.equals("admin")){
      roles.add(new Role("ADMIN"));
    }
    roles.add(new Role("USER"));
    return roles;
  }

  @Override
  public String getPassword() {
    return hashedPassword;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
