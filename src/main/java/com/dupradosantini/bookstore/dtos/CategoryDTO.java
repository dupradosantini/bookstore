package com.dupradosantini.bookstore.dtos;

import com.dupradosantini.bookstore.domain.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDTO /*implements Serializable security concern?*/ {
    private Integer id;
    private String name;
    private String description;

    public CategoryDTO(Category obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.description = obj.getDescription();
    }
}
