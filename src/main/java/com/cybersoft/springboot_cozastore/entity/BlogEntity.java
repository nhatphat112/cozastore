package com.cybersoft.springboot_cozastore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "blog")
public class BlogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String image;
    private String content;
    @OneToMany(mappedBy = "blogEntity")
    @JsonIgnore

    private Set<BlogTagEntity> blogTagEntities;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
    @OneToMany(mappedBy = "blogEntity")
    @JsonIgnore

    private Set<CommentEntity> commentEntities;
}
