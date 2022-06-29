package com.sales.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sales.entity.Product;
import com.sales.repository.ProductRepository;

import io.swagger.annotations.ApiOperation;




@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductRepository repository;
	
	@PostMapping("/product")
	@ApiOperation(value = "Save a new product")
	public Product save(@RequestBody Product product ) {
		return repository.save(product);
	}
	
	@GetMapping("/products")
	@ApiOperation(value = "Lists all registered products")
	public List<Product> list() {
		return repository.findAll();
	}
	
	@GetMapping("/product/{id}")
	@ApiOperation(value = "Returns a product by id")
	public Optional<Product> getProduct(@PathVariable(value = "id") Long id) {
		return repository.findById(id);
	}
	
	@PutMapping("/product")
	@ApiOperation(value = "Update a registered product")
	public Product change(@RequestBody Product product) {
		return repository.save(product);
	}

	@DeleteMapping("/product")
	@ApiOperation(value = "Delete a product from the system ")
	public void delete(@RequestBody Product product) {
		repository.delete(product);
	}
}













