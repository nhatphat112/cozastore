package com.cybersoft.springboot_cozastore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "total_price")
    private double totalPrice;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryEntity countryEntity;
    private String status;
    @Column(name = "postcode")
    private int postCode;
    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private CouponEntity couponEntity;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
    @OneToMany(mappedBy = "orderEntity")
    @JsonIgnore

    private Set<OrderProductEntity> orderProductEntities;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public CountryEntity getCountryEntity() {
        return countryEntity;
    }

    public void setCountryEntity(CountryEntity countryEntity) {
        this.countryEntity = countryEntity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public CouponEntity getCouponEntity() {
        return couponEntity;
    }

    public void setCouponEntity(CouponEntity couponEntity) {
        this.couponEntity = couponEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Set<OrderProductEntity> getOrderProductEntities() {
        return orderProductEntities;
    }

    public void setOrderProductEntities(Set<OrderProductEntity> orderProductEntities) {
        this.orderProductEntities = orderProductEntities;
    }

    public OrderEntity() {

    }

    public OrderEntity(int id, double totalPrice, CountryEntity countryEntity, String status, int postCode, CouponEntity couponEntity, UserEntity userEntity, Set<OrderProductEntity> orderProductEntities) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.countryEntity = countryEntity;
        this.status = status;
        this.postCode = postCode;
        this.couponEntity = couponEntity;
        this.userEntity = userEntity;
        this.orderProductEntities = orderProductEntities;
    }
}
