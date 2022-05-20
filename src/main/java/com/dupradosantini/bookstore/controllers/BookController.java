package com.dupradosantini.bookstore.controllers;


import com.dupradosantini.bookstore.domain.Book;
import com.dupradosantini.bookstore.dtos.BookDTO;
import com.dupradosantini.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/livros")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> findById(@PathVariable Integer id){
        Book obj = bookService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat){
        List<Book> list = bookService.findAll(id_cat);
        List<BookDTO> listDTO = list.stream().map(BookDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Book> update(@PathVariable Integer id, @RequestBody Book obj){
        Book newObj = bookService.update(id,obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Book> patch(@PathVariable Integer id, @RequestBody Book obj){
        Book newObj = bookService.update(id,obj);
        return ResponseEntity.ok().body(newObj);
    }
}
