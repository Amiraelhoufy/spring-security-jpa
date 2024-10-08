package com.agcodes.spring_security_jpa.controller;

import com.agcodes.spring_security_jpa.model.User;
import com.agcodes.spring_security_jpa.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping
  public ResponseEntity<String> createUser(@RequestBody User user){
    userService.saveUser(user);

    // Prevent login if the user is disabled
    if (user == null || !user.isEnabled()) {
      throw new UsernameNotFoundException("User not found or not enabled");
    }

    return new ResponseEntity<>("User created successfully!", HttpStatus.CREATED);
  }

  @GetMapping
  public List<User> getAllUsers(){
    return userService.getAllUsers();
  }

}
