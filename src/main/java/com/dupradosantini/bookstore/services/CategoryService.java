package com.dupradosantini.bookstore.services;

import com.dupradosantini.bookstore.domain.Category;
import com.dupradosantini.bookstore.dtos.CategoryDTO;
import com.dupradosantini.bookstore.repositories.CategoryRepository;
import com.dupradosantini.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category findById(Integer id){
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!! id: " + id + ", tipo: " + Category.class.getName()));
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category create(Category obj){
        obj.setId(null);
        return categoryRepository.save(obj);
    }

    public Category update(Integer id, CategoryDTO objDto) {
        Category obj = findById(id);
        obj.setName(objDto.getName());
        obj.setDescription(objDto.getDescription());
        return categoryRepository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try{
            categoryRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new com.dupradosantini.bookstore.services.exceptions.DataIntegrityViolationException("Categoria não pode ser deletada! Possui livros associados");
        }
    }
}
