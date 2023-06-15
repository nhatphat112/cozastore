package com.cybersoft.springboot_cozastore.entity.Ids;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BlogTagIds implements Serializable {
    @Column(name = "blog_id",insertable = false,updatable = false)
    private int blogId;
    @Column(name = "tag_id",insertable = false,updatable = false)
    private int tagId;

    public BlogTagIds(int blogId, int tagId) {
        this.blogId = blogId;
        this.tagId = tagId;
    }

    public BlogTagIds() {
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }
}
