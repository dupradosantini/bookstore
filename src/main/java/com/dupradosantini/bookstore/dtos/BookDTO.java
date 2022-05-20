package com.dupradosantini.bookstore.dtos;

import com.dupradosantini.bookstore.domain.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
public class BookDTO implements Serializable {
    private Integer id;
    private String title;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
    }
}
