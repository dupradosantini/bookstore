package com.dupradosantini.bookstore.dtos;

import com.dupradosantini.bookstore.domain.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDTO /*implements Serializable security concern?*/ {
    private Integer id;

    @NotEmpty(message = "Campo nome é obrigatório.")
    @Length(min = 3, max = 100, message = "O campo nome deve ter entre 3 e 100 caracteres.")
    private String name;

    @NotEmpty(message = "Campo descrição é obrigatório.")
    @Length(min = 3, max = 200, message = "O campo descrição deve ter entre 3 e 200 caracteres.")
    private String description;

    public CategoryDTO(Category obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.description = obj.getDescription();
    }
}
