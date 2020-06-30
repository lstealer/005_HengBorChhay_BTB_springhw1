package com.hw1.springhw1.repository;

import  com.hw1.springhw1.repository.dto.BookDto;
import  com.hw1.springhw1.repository.dto.CategoryDto;
import  com.hw1.springhw1.repository.selectprovider.BookProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository {

    //Get Category
    @SelectProvider(value = BookProvider.class, method = "getCategoryById")
    CategoryDto getCategoryById(int categoryId);

    //Get Category Title
    @SelectProvider(value = BookProvider.class, method = "getCategoryTitleById")
    String getCategoryTitleById(int id);

    //Get All Books
    @SelectProvider(value = BookProvider.class, method = "getAllBooks")
    @Results({
            @Result(column = "category_id", property = "category", many = @Many(select = "getCategoryById")),
    })
    List<BookDto> getAllBooks();

//    @SelectProvider(value = BookProvider.class, method = "getPagedBooks")
    @Select("SELECT * FROM school.tb_books LIMIT #{limit} OFFSET #{offset} ;")
    @Results({
            @Result(column = "category_id", property = "category", many = @Many(select = "getCategoryById")),
    })
    List<BookDto> getPagedBooks(int offset,int limit);

    //Get Book By Id
    @SelectProvider(value = BookProvider.class, method = "getBookById")
    @Results({
            @Result(column = "category_id", property = "category", many = @Many(select = "getCategoryById")),
    })
    BookDto getBookById(int id);

    //Get Book By Category Id
    @SelectProvider(value = BookProvider.class, method = "getBooksByCategoryId")
    @Results({
            @Result(column = "category_id", property = "category", many = @Many(select = "getCategoryById")),
    })
    List<BookDto> getBooksByCategoryId(int id);

    @SelectProvider(value = BookProvider.class, method = "getBookByTitle")
    @Results({
            @Result(column = "category_id", property = "category", many = @Many(select = "getCategoryById")),
    })
    List<BookDto> getBookByTitle(String title);

    @SelectProvider(value = BookProvider.class, method = "getBookByCategoryIdAndTitle")
    @Results({
            @Result(column = "category_id", property = "category", many = @Many(select = "getCategoryById")),
    })
    List<BookDto> getBookByCategoryIdAndTitle(int id,String title);

    //Post New Book
    @InsertProvider(value = BookProvider.class, method = "postBook")
    Boolean postBook(BookDto bookDto);

    //Update New Book
    @UpdateProvider(value = BookProvider.class, method = "updateBook")
    Boolean updateBook(BookDto bookDto,int id);

    //Delete Book
    @DeleteProvider(value = BookProvider.class, method = "deleteBookById")
    Boolean deleteBook(int id);
}
