package com.dupradosantini.bookstore.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Category implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Campo nome é obrigatório.")
    @Length(min = 3, max = 100, message = "O campo nome deve ter entre 3 e 100 caracteres.")
    private String name;

    @NotEmpty(message = "Campo descrição é obrigatório.")
    @Length(min = 3, max = 200, message = "O campo descrição deve ter entre 3 e 200 caracteres.")
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Book> books = new ArrayList<>();

    public Category(Integer id, String name, String description){
        super();
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category category)) return false;
        return getId().equals(category.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
