package com.hw1.springhw1.restcontroller;

import  com.hw1.springhw1.repository.dto.CategoryDto;
import  com.hw1.springhw1.restcontroller.response.BaseApiResponse;
import  com.hw1.springhw1.service.impl.CategoryServiceImplementation;
import  com.hw1.springhw1.utitl.MethodContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/BM/v1")
public class CategoryRestController {

    private CategoryServiceImplementation categoryServiceImplementation;
    MethodContainer methods;

    @Autowired
    public void setMethods(MethodContainer methods) {
        this.methods = methods;
    }

    @Autowired
    public void setCategoryServiceImplementation(CategoryServiceImplementation categoryServiceImplementation) {
        this.categoryServiceImplementation = categoryServiceImplementation;
    }

    @GetMapping("/categories")
    public ResponseEntity<BaseApiResponse<List<CategoryDto>>> getAllCategories(){
        BaseApiResponse<List<CategoryDto>> response= new BaseApiResponse<>();

        List<CategoryDto> categoryDtoList = categoryServiceImplementation.getAllCategories();

        response.setMessage("You have got all datas successfully!");
        response.setData(categoryDtoList);
        response.setStatus(HttpStatus.OK);
        response.setTime(methods.getTime());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<BaseApiResponse<CategoryDto>> getCategoryById(@PathVariable int id){
        BaseApiResponse<CategoryDto> response= new BaseApiResponse<>();

        CategoryDto category = categoryServiceImplementation.getCategoryById(id);

        response.setMessage("You have got all data successfully!");
        response.setData(category);
        response.setStatus(HttpStatus.OK);
        response.setTime(methods.getTime());

        return ResponseEntity.ok(response);
    }

    //Post New Category
    @PostMapping("/categories")
    public ResponseEntity<BaseApiResponse<CategoryDto>> postCategory(@RequestBody CategoryDto category){
        BaseApiResponse<CategoryDto> response= new BaseApiResponse<>();

        CategoryDto categoryDto = categoryServiceImplementation.postCategory(category);

        response.setMessage("You have posted a new category successfully!");
        response.setData(categoryDto);
        response.setStatus(HttpStatus.OK);
        response.setTime(methods.getTime());

        return ResponseEntity.ok(response);
    }

    //Update Category
    @PutMapping("/categories/{id}")
    public ResponseEntity<BaseApiResponse<CategoryDto>> postCategory(@PathVariable int id,@RequestBody CategoryDto category){
        BaseApiResponse<CategoryDto> response= new BaseApiResponse<>();

        CategoryDto categoryDto = categoryServiceImplementation.updateCategory(id,category);

        response.setMessage("You have update a category successfully!");
        response.setData(categoryDto);
        response.setStatus(HttpStatus.OK);
        response.setTime(methods.getTime());

        return ResponseEntity.ok(response);
    }

    //Delete a category
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable int id){

        String message = categoryServiceImplementation.deleteCategory(id);

        return ResponseEntity.ok(message);
    }

}
