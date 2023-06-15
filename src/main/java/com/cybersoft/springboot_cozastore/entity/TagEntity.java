package com.cybersoft.springboot_cozastore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "tag")
public class TagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "tagEntity")
    @JsonIgnore

    Set<BlogTagEntity> blogTagEntities;

    public TagEntity() {
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

    public Set<BlogTagEntity> getBlogTagEntities() {
        return blogTagEntities;
    }

    public void setBlogTagEntities(Set<BlogTagEntity> blogTagEntities) {
        this.blogTagEntities = blogTagEntities;
    }
}
