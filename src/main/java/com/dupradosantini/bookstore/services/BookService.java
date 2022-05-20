package com.dupradosantini.bookstore.services;

import com.dupradosantini.bookstore.domain.Book;
import com.dupradosantini.bookstore.domain.Category;
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

    public Book update(Integer id, Book obj) {
        Book newObj = findById(id);
        updateData(newObj,obj);
        return bookRepository.save(newObj);
    }

    private void updateData(Book newObj, Book obj) {
        newObj.setAuthor(obj.getAuthor());
        newObj.setTitle(obj.getTitle());
        newObj.setText(obj.getText());
    }

    public Book create(Integer id_cat, Book obj) {
        obj.setId(null);
        Category cat = categoryService.findById(id_cat);
        obj.setCategory(cat);
        return bookRepository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        bookRepository.deleteById(id);
    }
}
