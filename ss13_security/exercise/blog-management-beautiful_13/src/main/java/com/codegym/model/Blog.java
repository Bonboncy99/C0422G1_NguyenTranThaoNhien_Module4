package com.codegym.model;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "blog_name")
    private String blogName;
    private String authority;
    private String content;

    @ManyToOne
    private Category categories;

    public Blog() {
    }

    public Blog(Integer id, String blogName, String authority, String content, Category categories) {
        this.id = id;
        this.blogName = blogName;
        this.authority = authority;
        this.content = content;
        this.categories = categories;
    }

    public Blog(String blogName, String authority, String content, Category categories) {
        this.blogName = blogName;
        this.authority = authority;
        this.content = content;
        this.categories = categories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Category getCategories() {
        return categories;
    }

    public void setCategories(Category categories) {
        this.categories = categories;
    }
}
