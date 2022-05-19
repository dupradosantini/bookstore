package com.dupradosantini.bookstore.controllers;

import com.dupradosantini.bookstore.domain.Category;
import com.dupradosantini.bookstore.dtos.CategoryDTO;
import com.dupradosantini.bookstore.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id){
        Category obj = categoryService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll(){
        List<Category> list = categoryService.findAll();
        List<CategoryDTO> listDTO = list.stream().map(CategoryDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
}
