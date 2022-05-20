package com.dupradosantini.bookstore.services;

import com.dupradosantini.bookstore.domain.Book;
import com.dupradosantini.bookstore.repositories.BookRepository;
import com.dupradosantini.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookService {

    private final BookRepository bookRepository;
    private final CategoryService categoryService;

    @Autowired
    public BookService(BookRepository bookRepository, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.categoryService = categoryService;
    }

    public Book findById(Integer id){
        Optional<Book> obj = bookRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " +id + " ,Tipo: " + Book.class.getName()));
    }

    public List<Book> findAll(Integer id_cat){
        categoryService.findById(id_cat);
        return bookRepository.findAllByCategory(id_cat);
    }
}
