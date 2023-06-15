package com.cybersoft.springboot_cozastore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "coupon")
public class CouponEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String type;
    private String promotion;
    @OneToMany(mappedBy = "couponEntity")
    @JsonIgnore

    private Set<OrderEntity> orderEntities;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public Set<OrderEntity> getOrderEntities() {
        return orderEntities;
    }

    public void setOrderEntities(Set<OrderEntity> orderEntities) {
        this.orderEntities = orderEntities;
    }

    public CouponEntity() {
    }

    public CouponEntity(int id, String code, String type, String promotion, Set<OrderEntity> orderEntities) {
        this.id = id;
        this.code = code;
        this.type = type;
        this.promotion = promotion;
        this.orderEntities = orderEntities;
    }
}
