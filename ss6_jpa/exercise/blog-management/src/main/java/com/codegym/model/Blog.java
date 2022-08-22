package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "blog_name")
    private String blogName;
    private String authority;
    private String content;

    public Blog() {
    }

    public Blog(int id, String blogName, String authority, String content) {
        this.id = id;
        this.blogName = blogName;
        this.authority = authority;
        this.content = content;
    }

    public Blog(String blogName, String authority, String content) {
        this.blogName = blogName;
        this.authority = authority;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
