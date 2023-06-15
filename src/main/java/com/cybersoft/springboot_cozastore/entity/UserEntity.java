package com.cybersoft.springboot_cozastore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String email;
    @OneToMany(mappedBy = "userEntity")
    @JsonIgnore
    private Set<BlogEntity> blogEntities;

    public UserEntity() {
    }

    public UserEntity(int id, String username, String password, String email, Set<BlogEntity> blogEntities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.blogEntities = blogEntities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<BlogEntity> getBlogEntities() {
        return blogEntities;
    }

    public void setBlogEntities(Set<BlogEntity> blogEntities) {
        this.blogEntities = blogEntities;
    }
}
