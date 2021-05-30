package com.surya.crud.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.surya.crud.example.entity.Product;
import com.surya.crud.example.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products) {
		return productService.saveProducts(products);
	}
	
	@GetMapping("/products")
	public List<Product> findAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/product/{id}")
	public Product getProductbyId(@PathVariable int id){
		return productService.geProductById(id);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id){
		return productService.deleteProduct(id);
	}

	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product product){
		return productService.updateProduct(product);
	}
}
