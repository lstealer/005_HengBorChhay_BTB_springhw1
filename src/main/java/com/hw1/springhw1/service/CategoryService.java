package com.hw1.springhw1.service;

import  com.hw1.springhw1.repository.dto.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    List<CategoryDto> getAllCategories();
    CategoryDto getCategoryById(int id);
    CategoryDto postCategory(CategoryDto category);
    CategoryDto updateCategory(int id,CategoryDto category);
    String deleteCategory(int id);

}
