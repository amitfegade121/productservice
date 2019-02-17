package com.softedge.urbantrend.productservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softedge.urbantrend.productservice.exception.ProductNotFoundException;
import com.softedge.urbantrend.productservice.model.Product;
import com.softedge.urbantrend.productservice.repository.ProductRepository;
import com.softedge.urbantrend.productservice.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addNewProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product findProductById(long productId) throws ProductNotFoundException {
		Optional<Product> productData = productRepository.findById(productId);
		if (productData.isPresent())
			return productData.get();
		throw new ProductNotFoundException("Product not found.");
	}

	@Override
	public Product updateProductInformation(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteProductById(long productId) throws ProductNotFoundException {
		Optional<Product> productData = productRepository.findById(productId);
		if (productData.isPresent())
			productRepository.deleteById(productId);
		throw new ProductNotFoundException("Product not found.");
	}

	@Override
	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}

}
