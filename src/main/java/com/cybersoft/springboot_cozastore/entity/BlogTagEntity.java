package com.cybersoft.springboot_cozastore.entity;

import com.cybersoft.springboot_cozastore.entity.Ids.BlogTagIds;

import javax.persistence.*;

@Entity(name = "blog_tag")
public class BlogTagEntity {
    @EmbeddedId
    private BlogTagIds blogTagIds;
    @ManyToOne()
    @JoinColumn(name = "tag_id",insertable = false,updatable = false)
    private TagEntity tagEntity;
    @ManyToOne()
    @JoinColumn(name = "blog_id",insertable = false,updatable = false)
    private BlogEntity blogEntity;

    public BlogTagEntity() {
    }

    public BlogTagIds getBlogTagIds() {
        return blogTagIds;
    }

    public void setBlogTagIds(BlogTagIds blogTagIds) {
        this.blogTagIds = blogTagIds;
    }

    public TagEntity getTagEntity() {
        return tagEntity;
    }

    public void setTagEntity(TagEntity tagEntity) {
        this.tagEntity = tagEntity;
    }

    public BlogEntity getBlogEntity() {
        return blogEntity;
    }

    public void setBlogEntity(BlogEntity blogEntity) {
        this.blogEntity = blogEntity;
    }
}
