package com.agcodes.spring_security_jpa.repository;

import com.agcodes.spring_security_jpa.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

  Optional<User> findByUsername(String username);

}
