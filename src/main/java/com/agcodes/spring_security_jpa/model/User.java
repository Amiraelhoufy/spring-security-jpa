package com.agcodes.spring_security_jpa.model;

import static jakarta.persistence.GenerationType.SEQUENCE;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.util.List;

@Entity(name = "User")
@Table(name = "user",
    uniqueConstraints =
    @UniqueConstraint(name = "unique_username",columnNames = "user_name"))
public class User {
  @Id
  @SequenceGenerator(
      name = "user_sequence",
      sequenceName = "user_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = SEQUENCE,
      generator = "user_sequence"
  )
  @Column(
      name = "id",
      updatable = false
  )
  private Long id;


  @Column(
      name = "user_name",
      nullable = false,
      unique = true
  )
  private String username;

  @Column(
      name = "password",
      nullable = false
  )
  private String password;

  @Column(
      name = "enabled",
      nullable = false
  )
  private boolean enabled;

@OneToMany(
    mappedBy = "user", // this refers to the 'user' field in the Authority entity
    cascade = CascadeType.ALL,
    fetch = FetchType.EAGER)
@JsonManagedReference // Prevents infinite recursion and handles bidirectional relationship (parent side of the relationship)
private List<Authority> authorities;

  public User() {
  }

  public User(String username, String password, boolean enabled) {
    this.username = username;
    this.password = password;
    this.enabled = enabled;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public List<Authority> getAuthorities() {
    return authorities;
  }
  public void setAuthorities(List<Authority> authorities) {
    this.authorities = authorities;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", enabled=" + enabled +
        '}';
  }
}
