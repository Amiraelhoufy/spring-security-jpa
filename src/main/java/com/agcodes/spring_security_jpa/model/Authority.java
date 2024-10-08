package com.agcodes.spring_security_jpa.model;

import static jakarta.persistence.GenerationType.SEQUENCE;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity(name= "Authority")
@Table(name= "authorities"
    ,uniqueConstraints = {
    @UniqueConstraint(name = "unique_username_authority",columnNames = {"user_name", "authority"})
}
)
public class Authority {
  @Id
  @SequenceGenerator(
      name = "authority_sequence",
      sequenceName = "authority_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = SEQUENCE,
      generator = "authority_sequence"
  )
  @Column(
      name = "id",
      updatable = false
  )
  private Long id;

  @Column(
      name = "authority",
      nullable = false
  )
  private String authority;

  @ManyToOne
  @JoinColumn(
      name = "user_name", // this is the fk column in the "authorities" table
      referencedColumnName = "user_name", // this is the column in the "user" table
      foreignKey = @ForeignKey(name = "user_username_fk") // Renaming foreign key constraint
  )
  @JsonBackReference // Prevents circular reference (child side)
  private User user;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getUser() {
    return this.user;
  }
  public String getAuthority() {
    return authority;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "Authority{" +
        "id=" + id +
        ", authority='" + authority + '\'' +
        '}';
  }
}
