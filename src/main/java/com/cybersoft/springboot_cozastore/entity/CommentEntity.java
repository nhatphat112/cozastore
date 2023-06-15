package com.cybersoft.springboot_cozastore.entity;

import javax.persistence.*;

@Entity(name = "comment")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
    private String name;
    private String email;
    private String website;
    @ManyToOne()
    @JoinColumn(name = "blog_id")
    private BlogEntity blogEntity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public BlogEntity getBlogEntity() {
        return blogEntity;
    }

    public void setBlogEntity(BlogEntity blogEntity) {
        this.blogEntity = blogEntity;
    }

    public CommentEntity() {
    }

    public CommentEntity(int id, String content, String name, String email, String website, BlogEntity blogEntity) {
        this.id = id;
        this.content = content;
        this.name = name;
        this.email = email;
        this.website = website;
        this.blogEntity = blogEntity;
    }
}
