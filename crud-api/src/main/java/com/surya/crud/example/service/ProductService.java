package com.surya.crud.example.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surya.crud.example.entity.Product;
import com.surya.crud.example.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}
	
	public List<Product> getAllProducts() {
		return repository.findAll();
	}
	
	public Product geProductById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public String deleteProduct(int id) {
		repository.deleteById(id);
		return "product removed!!"+id;
	}
	
	public Product updateProduct(Product updatedProduct) {
		Product existingProduct = repository.findById(updatedProduct.getId()).orElse(null);
		existingProduct.setName(updatedProduct.getName());
		existingProduct.setQuantity(updatedProduct.getQuantity());
		existingProduct.setPrice(updatedProduct.getPrice());
		return repository.save(existingProduct);
	}
}
