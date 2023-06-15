package com.cybersoft.springboot_cozastore.entity.Ids;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderProductIds implements Serializable {
    @Column(name = "order_id",insertable = false,updatable = false)
    private int orderId;
    @Column(name = "product_id",insertable = false,updatable = false)


    private int productId;



    public OrderProductIds(int orderId, int productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public OrderProductIds() {
    }


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
