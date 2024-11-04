package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.entities.Category;

import lombok.Data;


@Data
public class CategoryDTO implements Serializable {
    private static final long serialVersionUID= 1L; 
    private Long id;
    private String name;

    public CategoryDTO() {}

    public CategoryDTO(Category category){
        this.id = category.getId();
        this.name = category.getName();
    }
}
