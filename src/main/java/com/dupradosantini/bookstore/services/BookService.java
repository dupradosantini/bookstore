package com.dupradosantini.bookstore.services;

import com.dupradosantini.bookstore.domain.Book;
import com.dupradosantini.bookstore.repositories.BookRepository;
import com.dupradosantini.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findById(Integer id){
        Optional<Book> obj = bookRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " +id + " ,Tipo: " + Book.class.getName()));
    }
}
