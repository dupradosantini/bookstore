package com.dupradosantini.bookstore.controllers;


import com.dupradosantini.bookstore.domain.Book;
import com.dupradosantini.bookstore.dtos.BookDTO;
import com.dupradosantini.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
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
    public ResponseEntity<Book> update(@PathVariable Integer id,@Valid @RequestBody Book obj){
        Book newObj = bookService.update(id,obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Book> patch(@PathVariable Integer id,@Valid @RequestBody Book obj){
        Book newObj = bookService.update(id,obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PostMapping
    public ResponseEntity<Book> create(
            @RequestParam(value = "categoria", defaultValue = "0") Integer id_cat,
            @Valid @RequestBody Book obj){
        Book newObj = bookService.create(id_cat,obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(newObj.getId()).toUri();
        return  ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
