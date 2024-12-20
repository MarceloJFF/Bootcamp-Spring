package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
