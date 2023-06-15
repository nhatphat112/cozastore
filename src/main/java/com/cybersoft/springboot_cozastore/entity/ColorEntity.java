package com.cybersoft.springboot_cozastore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "color")
public class ColorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "colorEntity")
    @JsonIgnore
    private Set<ProductEntity> productEntities;

    public ColorEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ProductEntity> getProductEntities() {
        return productEntities;
    }

    public void setProductEntities(Set<ProductEntity> productEntities) {
        this.productEntities = productEntities;
    }

    public ColorEntity(int id, String name, Set<ProductEntity> productEntities) {
        this.id = id;
        this.name = name;
        this.productEntities = productEntities;
    }
}
