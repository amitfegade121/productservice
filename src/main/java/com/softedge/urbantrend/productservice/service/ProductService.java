package com.softedge.urbantrend.productservice.service;

import java.util.List;

import com.softedge.urbantrend.productservice.exception.ProductNotFoundException;
import com.softedge.urbantrend.productservice.model.Product;

public interface ProductService {

	public Product addNewProduct(Product product);

	public Product findProductById(long productId) throws ProductNotFoundException;

	public Product updateProductInformation(Product product);

	public void deleteProductById(long productId) throws ProductNotFoundException;

	public List<Product> findAllProducts();
}
