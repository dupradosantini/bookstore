package com.dupradosantini.bookstore.services;

import com.dupradosantini.bookstore.domain.Category;
import com.dupradosantini.bookstore.repositories.CategoryRepository;
import com.dupradosantini.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category findById(Integer id){
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!! id: " + id + ", tipo: " + Category.class.getName()));
    }
}