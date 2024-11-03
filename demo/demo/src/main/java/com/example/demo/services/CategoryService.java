
package com.example.demo.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.entities.Category;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.services.exceptions.EntityNotFoundException;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;
    
    //Garante integridade do BD
    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll(){
        List<Category> list = repository.findAll();
        return list.stream().map(x -> new CategoryDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
       Optional<Category> obj =  repository.findById(id);
       Category entity = obj.orElseThrow(()-> new EntityNotFoundException("Entity not found"));
         return new CategoryDTO(entity);
    }
}
