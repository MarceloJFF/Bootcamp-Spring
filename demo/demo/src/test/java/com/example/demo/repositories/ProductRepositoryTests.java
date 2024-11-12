package com.example.demo.repositories;
import java.time.Instant;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException; 
import com.example.demo.Factory;
import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;

@DataJpaTest
public class ProductRepositoryTests {
    
    @Autowired
    private ProductRepository repository;
    private long countTotalProducts;
    private long existingId = 1L;
    private long nonExistingId = 10000L;
    


    @BeforeEach
    void setUp() throws Exception{
        existingId= 1L;
        nonExistingId= 1000L;
        countTotalProducts = 25L;
    }

    @Test
    public void deleteShouldDeleteObjectWhenIdExists(){
       
        repository.deleteById(existingId);

        Optional<Product> result =  repository.findById(existingId); 
        
        assertFalse(result.isPresent());
    }


    @Test
    public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExist() {
        // Agora, chame deleteById e espere a exceção
        assertThrows(EmptyResultDataAccessException.class, () -> {
            repository.deleteById(nonExistingId);
        });
    }

    @Test
    public void saveShouldPersistWithAutoIncrementWhenIdIsNull(){
        Product product = Factory.createProduct();
        product.setId(null);
        product = repository.save(product);

        assertNotNull(product.getId());
        assertEquals(countTotalProducts + 1, product.getId());
    }

    @Test 
    public void findByIdShouldReturnOptionWhenIdExists(){
        Optional<Product> prod = repository.findById(existingId);
        assertTrue(prod.isPresent());
    }
    
    @Test
    public void findByIdShouldReturnEmptyOptionalProductWhenIdNotExists(){
        Optional<Product> prod = repository.findById(nonExistingId);
        assertFalse(prod.isPresent());

    }
}
