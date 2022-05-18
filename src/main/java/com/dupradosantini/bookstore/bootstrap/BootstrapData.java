package com.dupradosantini.bookstore.bootstrap;

import com.dupradosantini.bookstore.domain.Book;
import com.dupradosantini.bookstore.domain.Category;
import com.dupradosantini.bookstore.repositories.BookRepository;
import com.dupradosantini.bookstore.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BootstrapData {


    private  CategoryRepository categoryRepository;

    private  BookRepository bookRepository;

    @Autowired
    public BootstrapData(CategoryRepository categoryRepository, BookRepository bookRepository) {
        this.categoryRepository = categoryRepository;
        this.bookRepository = bookRepository;
    }

    public void BootstrapDataInit(){
        Category cat1 = new Category(null,"Informatica","Livros de TI");
        Category cat2 = new Category(null,"Ficção Científica","Ficção Científica");
        Category cat3 = new Category(null,"Biografias","Livros de Biografias");

        Book book1 = new Book(null, "Clean Code","Uncle Bob", "Lorem ipsum", cat1);
        Book book2 = new Book(null, "Engenharia de Software","Louis V. Gerstner", "Lorem ipsum", cat1);
        Book book3 = new Book(null, "The time machine","H.G. Wells", "Lorem ipsum", cat2);
        Book book4 = new Book(null, "War of Worlds","H.G. Wells", "Lorem ipsum", cat2);
        Book book5 = new Book(null, "I, Robot","Isaac Asimov", "Lorem ipsum", cat2);

        cat1.setBooks(Arrays.asList(book1,book2));
        cat2.setBooks(Arrays.asList(book3,book4,book5));
        this.categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        this.bookRepository.saveAll(Arrays.asList(book1,book2,book3,book4,book5));
    }
}
