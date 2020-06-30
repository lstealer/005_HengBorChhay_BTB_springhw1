package com.hw1.springhw1.repository;

import  com.hw1.springhw1.repository.dto.CategoryDto;
import  com.hw1.springhw1.repository.selectprovider.CategoryProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository {

    @SelectProvider(value = CategoryProvider.class, method = "getAllCategories")
    List<CategoryDto> getAllCategories();

    @SelectProvider(value = CategoryProvider.class, method = "getCategoryById")
    CategoryDto getCategoryById(int id);

    @InsertProvider(value = CategoryProvider.class, method = "postCategory")
    Boolean postCategory(CategoryDto category);

    @SelectProvider(value = CategoryProvider.class, method = "getCategoryIdByTitle")
    String getCategoryIdByTitle(String title);

    @UpdateProvider(value = CategoryProvider.class, method = "updateCategory")
    Boolean updateCategory(int id,CategoryDto categoryDto);

    @DeleteProvider(value = CategoryProvider.class, method = "deleteCategory")
    Boolean deleteCategory(int id);
}
