package com.cybersoft.springboot_cozastore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.engine.jdbc.Size;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String image;
    private String name;
    private double price;
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;
    private String description;
    @ManyToOne()
    @JoinColumn(name = "size_id")
    private SizeEntity sizeEntity;
    @ManyToOne()
    @JoinColumn(name = "color_id")
    private ColorEntity colorEntity;
    private int quantity;
    @Column(name = "list_image")
    private String listImage;
    @OneToMany(mappedBy = "productEntity")
    @JsonIgnore

    private Set<OrderProductEntity> orderProductEntities;

    public ProductEntity() {
    }

    public ProductEntity(int id, String image, String name, double price, CategoryEntity categoryEntity, String description, SizeEntity sizeEntity, ColorEntity colorEntity, int quantity, String listImage, Set<OrderProductEntity> orderProductEntities) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.price = price;
        this.categoryEntity = categoryEntity;
        this.description = description;
        this.sizeEntity = sizeEntity;
        this.colorEntity = colorEntity;
        this.quantity = quantity;
        this.listImage = listImage;
        this.orderProductEntities = orderProductEntities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SizeEntity getSizeEntity() {
        return sizeEntity;
    }

    public void setSizeEntity(SizeEntity sizeEntity) {
        this.sizeEntity = sizeEntity;
    }

    public ColorEntity getColorEntity() {
        return colorEntity;
    }

    public void setColorEntity(ColorEntity colorEntity) {
        this.colorEntity = colorEntity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getListImage() {
        return listImage;
    }

    public void setListImage(String listImage) {
        this.listImage = listImage;
    }

    public Set<OrderProductEntity> getOrderProductEntities() {
        return orderProductEntities;
    }

    public void setOrderProductEntities(Set<OrderProductEntity> orderProductEntities) {
        this.orderProductEntities = orderProductEntities;
    }
}
