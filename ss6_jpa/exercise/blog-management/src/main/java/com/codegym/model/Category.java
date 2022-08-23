package com.codegym.model;

import javax.persistence.OneToMany;

public class Category {
    private Integer id;
    private String CategoryName;

    @OneToMany (mappedBy = id)

}
