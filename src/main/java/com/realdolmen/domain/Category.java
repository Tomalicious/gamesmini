package com.realdolmen.domain;

import lombok.Data;

@Data
public class Category extends BaseEntity{
    private String categoryName;

    public Category(int id , String categoryName) {
        super(id);
        this.categoryName = categoryName;
    }
}
