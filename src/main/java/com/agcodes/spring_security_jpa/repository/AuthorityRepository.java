package com.agcodes.spring_security_jpa.repository;

import com.agcodes.spring_security_jpa.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority,Long> {

}
