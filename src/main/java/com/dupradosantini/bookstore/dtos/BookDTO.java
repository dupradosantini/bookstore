package com.dupradosantini.bookstore.dtos;

import com.dupradosantini.bookstore.domain.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class BookDTO implements Serializable {
    private Integer id;

    @NotEmpty(message = "Campo título é obrigatório.")
    @Length(min = 3, max = 50, message = "O campo título deve ter entre 3 e 50 caracteres.")
    private String title;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
    }
}
