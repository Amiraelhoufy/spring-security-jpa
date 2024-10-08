package com.agcodes.spring_security_jpa.service;

import com.agcodes.spring_security_jpa.model.User;
import com.agcodes.spring_security_jpa.repository.AuthorityRepository;
import com.agcodes.spring_security_jpa.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public void saveUser(User user){
    userRepository.save(user);
  }

  public List<User> getAllUsers(){
    return userRepository.findAll();
  }

  public Optional<User> getUserByUsername(String username){
    return userRepository.findByUsername(username);

  }

  public void deleteUser(long id){
     userRepository.deleteById(id);
  }

}
