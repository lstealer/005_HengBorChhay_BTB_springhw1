package com.hw1.springhw1.service;

import  com.hw1.springhw1.repository.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    List<BookDto> getAllBooks();
    List<BookDto> getPagedBooks(int offset,int limit);
    List<BookDto> getBookByTitle(String title);
    List<BookDto> getBooksByCategoryId(int id);
    List<BookDto> getBookByCategoryIdAndTitle(int id, String title);
    BookDto getBookById(int id);
    BookDto postBook(BookDto newBook);
    BookDto updateBook(BookDto updateBook,int id);
    String deleteBook(int id);

}
