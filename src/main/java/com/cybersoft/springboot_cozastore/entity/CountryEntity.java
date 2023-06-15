package com.cybersoft.springboot_cozastore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "country")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "countryEntity")
    @JsonIgnore

    private Set<OrderEntity> orderEntities;

    public CountryEntity() {
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

    public Set<OrderEntity> getOrderEntities() {
        return orderEntities;
    }

    public void setOrderEntities(Set<OrderEntity> orderEntities) {
        this.orderEntities = orderEntities;
    }

    public CountryEntity(int id, String name, Set<OrderEntity> orderEntities) {
        this.id = id;
        this.name = name;
        this.orderEntities = orderEntities;
    }
}
