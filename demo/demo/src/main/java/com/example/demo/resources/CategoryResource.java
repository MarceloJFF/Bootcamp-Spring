package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Category;
import com.example.demo.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
    @Autowired
    private CategoryService service;

    @GetMapping()
    public ResponseEntity<List<Category>> findAll(){
        //Ok automaticamente responde com codigo 200 a requisicao e corpo sao as informacoes
        return ResponseEntity.ok().body(service.findAll());
    }
    
}
