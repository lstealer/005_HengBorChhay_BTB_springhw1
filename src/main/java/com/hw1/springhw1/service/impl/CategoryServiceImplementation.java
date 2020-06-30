package com.hw1.springhw1.service.impl;

import  com.hw1.springhw1.repository.CategoryRepository;
import  com.hw1.springhw1.repository.dto.CategoryDto;
import  com.hw1.springhw1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImplementation implements CategoryService {

    CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

    @Override
    public CategoryDto getCategoryById(int id) {
        return categoryRepository.getCategoryById(id);
    }

    @Override
    public CategoryDto postCategory(CategoryDto category) {
        if (categoryRepository.postCategory(category)){
            int id = Integer.parseInt(categoryRepository.getCategoryIdByTitle(category.getTitle()));
            category.setId(id);
            return category;
        }else {
            return null;
        }
    }

    @Override
    public CategoryDto updateCategory(int id,CategoryDto category) {
        if (categoryRepository.updateCategory(id,category)){
            int idCategory = Integer.parseInt(categoryRepository.getCategoryIdByTitle(category.getTitle()));
            category.setId(idCategory);
            return category;
        }else {
            return null;
        }
    }

    @Override
    public String deleteCategory(int id) {
        if (categoryRepository.deleteCategory(id)){
            return "You have deleted a category successfully!";
        }else {
            return "You are failed to delete a category!";
        }
    }
}
