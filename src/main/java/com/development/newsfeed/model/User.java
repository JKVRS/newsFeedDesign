package com.development.newsfeed.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseModel {

  private   String name;
  private   String email;
  private   String password;
  @OneToOne(mappedBy = "user")
  private  Session session;
  @ManyToMany
  private   List<User> followingUser;

}
