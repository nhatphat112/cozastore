package com.cybersoft.springboot_cozastore.entity;

import com.cybersoft.springboot_cozastore.entity.Ids.OrderProductIds;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "order_product")
public class OrderProductEntity {
    @EmbeddedId
    private OrderProductIds ids;
    private int quantity;
    @ManyToOne()
    @JoinColumn(name = "order_id",insertable = false,updatable = false)
    private OrderEntity orderEntity;
    @ManyToOne()
    @JoinColumn(name = "product_id",insertable = false,updatable = false)
    private ProductEntity productEntity;

    public OrderProductEntity() {
    }

    public OrderProductEntity(OrderProductIds ids, int quantity, OrderEntity orderEntity, ProductEntity productEntity) {
        this.ids = ids;
        this.quantity = quantity;
        this.orderEntity = orderEntity;
        this.productEntity = productEntity;
    }

    public OrderProductIds getIds() {
        return ids;
    }

    public void setIds(OrderProductIds ids) {
        this.ids = ids;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}
