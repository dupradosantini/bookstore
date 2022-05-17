package com.dupradosantini.bookstore;

import com.dupradosantini.bookstore.domain.Book;
import com.dupradosantini.bookstore.domain.Category;
import com.dupradosantini.bookstore.repositories.BookRepository;
import com.dupradosantini.bookstore.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    //Bootstraping data.
    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null,"Informatica","Livros de TI");

        Book book1 = new Book(null, "Clean Code","Uncle Bob", "Lorem ipsum", cat1);

        cat1.setBooks(Arrays.asList(book1));

        this.categoryRepository.saveAll(Arrays.asList(cat1));
        this.bookRepository.saveAll(Arrays.asList(book1));
    }
}
