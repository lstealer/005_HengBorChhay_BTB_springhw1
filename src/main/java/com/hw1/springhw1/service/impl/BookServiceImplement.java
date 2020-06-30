package com.hw1.springhw1.service.impl;

import  com.hw1.springhw1.repository.BookRepository;
import  com.hw1.springhw1.repository.dto.BookDto;
import  com.hw1.springhw1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplement implements BookService {

    BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDto> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    @Override
    public List<BookDto> getPagedBooks(int offset, int limit) {
        return bookRepository.getPagedBooks(offset,limit);
    }

    @Override
    public List<BookDto> getBookByTitle(String title) {
        return bookRepository.getBookByTitle(title);
    }

    @Override
    public List<BookDto> getBooksByCategoryId(int id) {
        return bookRepository.getBooksByCategoryId(id);
    }

    @Override
    public List<BookDto> getBookByCategoryIdAndTitle(int id, String title) {
        return bookRepository.getBookByCategoryIdAndTitle(id,title);
    }

    @Override
    public BookDto getBookById(int id) {
        return bookRepository.getBookById(id);
    }

    @Override
    public BookDto postBook(BookDto newBook) {
        Boolean isPosted = bookRepository.postBook(newBook);
        if (isPosted){
            String title = bookRepository.getCategoryTitleById(newBook.getCategory().getId());
            newBook.getCategory().setTitle(title);
            return newBook;
        }else {
            return null;
        }
    }

    @Override
    public BookDto updateBook(BookDto updateBook,int id) {
        Boolean isUpdated = bookRepository.updateBook(updateBook,id);
        if (isUpdated){
            String title=bookRepository.getCategoryTitleById(updateBook.getCategory().getId());
            updateBook.getCategory().setTitle(title);
            return updateBook;
        }else {
            return null;
        }

    }

    @Override
    public String deleteBook(int id) {
        Boolean isDeleted = bookRepository.deleteBook(id);
        if (isDeleted) {
            return "Book is deleted successfully!";
        }else {
            return "Book is failed to delete!";
        }
    }
}
