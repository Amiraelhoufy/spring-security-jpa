package com.agcodes.spring_security_jpa.service;

import com.agcodes.spring_security_jpa.model.AppUserDetails;
import com.agcodes.spring_security_jpa.model.User;
import com.agcodes.spring_security_jpa.repository.UserRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

  private static final Logger logger = LoggerFactory.getLogger(AppUserDetailsService.class);

  @Autowired
  private UserRepository userRepository;
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    logger.info("Attempting to load user by username: {}", username);

    User user = userRepository.findByUsername(username)
        .orElseThrow(()-> new UsernameNotFoundException("User not found: " + username));

    // Prevent login if the user is disabled
    if (!user.isEnabled()) {
      throw new UsernameNotFoundException("User is not enabled " + username);
    }

    // You can log in with any username and static password: pass
//    return new AppUserDetails(username);

    return new AppUserDetails(user);

  }
}
