package com.agcodes.spring_security_jpa.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// Hardcoded user details
public class AppUserDetails implements UserDetails {

  private String username;
  private String password;
  private Boolean enabled;
  private List<GrantedAuthority> authorities;

  public AppUserDetails(){
  }

  /*
    // used for testing with static password and any username
    public AppUserDetails(String username){
      this.username= username;
    }
  */

  public AppUserDetails(User user){
    this.username = user.getUsername();
    this.password = user.getPassword();
    this.enabled = user.isEnabled();
    this.authorities = user
        .getAuthorities()
        .stream()
        .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
        .collect(Collectors.toList());
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
//    return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    return this.authorities;
  }

  @Override
  public String getPassword() {
//    return "pass";
    return this.password;
  }

  @Override
  public String getUsername() {
    return this.username;
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
    return this.enabled;
  }
}
