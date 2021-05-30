package com.surya.crud.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surya.crud.example.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
