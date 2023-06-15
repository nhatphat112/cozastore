package com.cybersoft.springboot_cozastore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.awt.dnd.InvalidDnDOperationException;
import java.util.Set;

@Entity(name = "sizes")
public class SizeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "sizeEntity")
    @JsonIgnore
    private Set<ProductEntity> productEntities;

    public SizeEntity() {
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

    public SizeEntity(int id, String name, Set<ProductEntity> productEntities) {
        this.id = id;
        this.name = name;
        this.productEntities = productEntities;
    }
}
