package com.softedge.urbantrend.productservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softedge.urbantrend.productservice.exception.ProductNotFoundException;
import com.softedge.urbantrend.productservice.model.Product;
import com.softedge.urbantrend.productservice.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductResource {

	@Autowired
	private ProductService productService;

	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(productService.addNewProduct(product), HttpStatus.OK);
	}
	
	@GetMapping("/products/{productId}")
	public ResponseEntity<Product> findProductById(@PathVariable long productId) {
		ResponseEntity<Product> response = null;
		try {
			response = new ResponseEntity<Product>(productService.findProductById(productId), HttpStatus.OK);
		}
		catch(ProductNotFoundException ex) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> findAllProducts() {
		return new ResponseEntity<List<Product>>(productService.findAllProducts(), HttpStatus.OK);
	}
	
	@PutMapping("/products")
	public ResponseEntity<Product> updateProductInformation(@RequestBody Product product) {
		return new ResponseEntity<Product>(productService.updateProductInformation(product), HttpStatus.OK);
	}
	
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<Void> deleteProductById(@PathVariable long productId) {
		ResponseEntity<Void> response = null;
		try {
			productService.deleteProductById(productId);
			response = new ResponseEntity<>(HttpStatus.OK);
		}
		catch(ProductNotFoundException ex) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return response;
	}
}




