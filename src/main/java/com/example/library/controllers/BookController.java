package com.example.library.controllers;

import com.example.library.Services.BookService;
import com.example.library.entities.Book;
import com.example.library.exception.NoSuchBookException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService=bookService;
    }

    @GetMapping
    public List<Book> getAll(){
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id){
        Book book=bookService.findOne(id);
        if(book==null){
            throw  new NoSuchBookException("Book not found");
        }
        return book;
    }

    @PostMapping
    public Book save(@RequestBody Book book){
      return   bookService.save(book);
    }

    @PutMapping
    public void update(Book book){
        bookService.update(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        Book book=bookService.findOne(id);
        if(book==null){
            throw new NoSuchBookException("There is no book with ID= "+id+" in Database");
        }
        bookService.delete(id);
    }
}
