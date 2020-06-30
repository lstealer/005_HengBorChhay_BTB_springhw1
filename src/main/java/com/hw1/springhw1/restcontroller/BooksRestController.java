package com.hw1.springhw1.restcontroller;

import  com.hw1.springhw1.repository.dto.BookDto;
import  com.hw1.springhw1.restcontroller.request.BookRequestModel;
import  com.hw1.springhw1.restcontroller.response.BaseApiResponse;
import  com.hw1.springhw1.service.impl.BookServiceImplement;
import  com.hw1.springhw1.utitl.MethodContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/BM/v1/")
public class BooksRestController {

    private BookServiceImplement bookServiceImplement;
    MethodContainer methods;

    @Autowired
    public void setMethods(MethodContainer methods) {
        this.methods = methods;
    }

    @Autowired
    public void setBookServiceImplement(BookServiceImplement bookServiceImplement) {
        this.bookServiceImplement = bookServiceImplement;
    }


    //Get all books
    @GetMapping("/bookspage")
    public ResponseEntity<BaseApiResponse<List<BookRequestModel>>> getAllBooks(){
        BaseApiResponse<List<BookRequestModel>> response = new BaseApiResponse<>();

        List<BookDto> bookDtoList = bookServiceImplement.getPagedBooks(3,4);
        List<BookRequestModel> books =new ArrayList<>();

        for (BookDto book : bookDtoList){
            books.add(methods.getMapper().map(book,BookRequestModel.class));
        }

        response.setMessage("You have got all datas successfully!");
        response.setData(books);
        response.setStatus(HttpStatus.OK);
        response.setTime(methods.getTime());
        System.out.println("hi");
        return ResponseEntity.ok(response);
    }

    //Get book by id
    @GetMapping("/books/{id}")
    public ResponseEntity<BaseApiResponse<BookRequestModel>> getBookById(@PathVariable int id){
        BaseApiResponse<BookRequestModel> response = new BaseApiResponse<>();

        BookDto bookDto = bookServiceImplement.getBookById(id);
        BookRequestModel book = methods.getMapper().map(bookDto,BookRequestModel.class);

        response.setMessage("You have found book!");
        response.setData(book);
        response.setStatus(HttpStatus.OK);
        response.setTime(methods.getTime());

        return ResponseEntity.ok(response);
    }

    //paging
    @GetMapping("/books")
    public ResponseEntity<BaseApiResponse<List<BookRequestModel>>> select(
            @RequestParam(value = "page", required = false,defaultValue = "1")int page,
            @RequestParam(value = "limit",required = false,defaultValue = "3")int limit
    ){

        BaseApiResponse<List<BookRequestModel>> response = new BaseApiResponse<>();

        List<BookDto> bookDtoList = bookServiceImplement.getPagedBooks((page-1)*limit,limit);
        List<BookRequestModel> books =new ArrayList<>();

        for (BookDto book : bookDtoList){
            books.add(methods.getMapper().map(book,BookRequestModel.class));
        }

        response.setMessage("You have got all datas successfully!");
        response.setData(books);
        response.setStatus(HttpStatus.OK);
        response.setTime(methods.getTime());

        return ResponseEntity.ok(response);
    }

    //Post a book
    @PostMapping("/books")
    public ResponseEntity<BaseApiResponse<BookRequestModel>> postBook(@RequestBody BookRequestModel newBook){
        BaseApiResponse<BookRequestModel> response = new BaseApiResponse<>();

        BookDto book = methods.getMapper().map(newBook,BookDto.class);
        BookDto bookDto = bookServiceImplement.postBook(book);

        BookRequestModel bookRequest = methods.getMapper().map(bookDto,BookRequestModel.class);

        response.setMessage("You have posted a new book!");
        response.setData(bookRequest);
        response.setStatus(HttpStatus.OK);
        response.setTime(methods.getTime());

        return ResponseEntity.ok(response);
    }

    //Update a book
    @PutMapping("/books/{id}")
    public ResponseEntity<BaseApiResponse<BookRequestModel>> updateBook(@PathVariable int id,@RequestBody BookRequestModel newBook){
        BaseApiResponse<BookRequestModel> response = new BaseApiResponse<>();

        BookDto book = methods.getMapper().map(newBook,BookDto.class);
        BookDto bookDto = bookServiceImplement.updateBook(book,id);

        BookRequestModel bookRequest = methods.getMapper().map(bookDto,BookRequestModel.class);

        response.setMessage("You have updated a book!");
        response.setData(bookRequest);
        response.setStatus(HttpStatus.OK);
        response.setTime(methods.getTime());

        return ResponseEntity.ok(response);
    }

    //Delete a Book
    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id){

        String message = bookServiceImplement.deleteBook(id);

        return ResponseEntity.ok(message);
    }

    //Get Book by filtering category
    @RequestMapping(value = "/books",method = RequestMethod.GET,params = {"category"})
    public ResponseEntity<BaseApiResponse<List<BookRequestModel>>> getBookByFilterCategory(@RequestParam("category") int id){

        System.out.println(id);
        BaseApiResponse<List<BookRequestModel>> response = new BaseApiResponse<>();

        List<BookDto> bookDtoList;
            bookDtoList = bookServiceImplement.getBooksByCategoryId(id);
        List<BookRequestModel> books =new ArrayList<>();

        for (BookDto book : bookDtoList){
            books.add(methods.getMapper().map(book,BookRequestModel.class));
        }

        response.setMessage("You have got all data successfully!");
        response.setData(books);
        response.setStatus(HttpStatus.OK);
        response.setTime(methods.getTime());

        return ResponseEntity.ok(response);
    }


    //Get Book By Title
    @RequestMapping(value = "/books",method = RequestMethod.GET,params = {"title"})
    public ResponseEntity<BaseApiResponse<List<BookRequestModel>>> getBookByTitle(@RequestParam("title") String title){

        System.out.println(" "+title);
        BaseApiResponse<List<BookRequestModel>> response = new BaseApiResponse<>();

        List<BookDto> bookDtoList;
        bookDtoList = bookServiceImplement.getBookByTitle(title);
        List<BookRequestModel> books =new ArrayList<>();

        for (BookDto book : bookDtoList){
            books.add(methods.getMapper().map(book,BookRequestModel.class));
        }

        response.setMessage("You have got all data successfully!");
        response.setData(books);
        response.setStatus(HttpStatus.OK);
        response.setTime(methods.getTime());

        return ResponseEntity.ok(response);
    }

    //Get Book by Category and Title
    @RequestMapping(value = "/books",method = RequestMethod.GET,params = {"categoryId","title"})
    public ResponseEntity<BaseApiResponse<List<BookRequestModel>>> getBookByCategoryIdAndTitle(@RequestParam("categoryId") int id, @RequestParam("title") String title){

        BaseApiResponse<List<BookRequestModel>> response = new BaseApiResponse<>();

        List<BookDto> bookDtoList;
        bookDtoList = bookServiceImplement.getBookByCategoryIdAndTitle(id,title);
        List<BookRequestModel> books =new ArrayList<>();

        for (BookDto book : bookDtoList){
            books.add(methods.getMapper().map(book,BookRequestModel.class));
        }

        response.setMessage("You have got all data successfully!");
        response.setData(books);
        response.setStatus(HttpStatus.OK);
        response.setTime(methods.getTime());

        return ResponseEntity.ok(response);
    }

}
