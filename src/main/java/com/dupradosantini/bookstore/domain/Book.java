package com.dupradosantini.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Book implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Campo título é obrigatório.")
    @Length(min = 3, max = 50, message = "O campo título deve ter entre 3 e 50 caracteres.")
    private String title;

    @NotEmpty(message = "Campo autor é obrigatório.")
    @Length(min = 3, max = 80, message = "O campo autor deve ter entre 3 e 80 caracteres.")
    private String author;

    @NotEmpty(message = "Campo descrição é obrigatório.")
    @Length(min = 3, max = 2000000, message = "O campo descrição deve ter entre 3 e 2.000.000 caracteres.")
    private String text;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Book(Integer id, String title, String author, String text, Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.text = text;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return getId().equals(book.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
