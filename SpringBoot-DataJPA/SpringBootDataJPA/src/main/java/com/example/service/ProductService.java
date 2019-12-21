package com.example.service;

import com.example.models.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Object getAllProduct() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll()
                .forEach(products::add);

        return products;
    }

    public Object getAllProductByType(Integer productTypeId) {
        List<Product> products = new ArrayList<>();
        productRepository.findByProductTypeId(productTypeId)
                .forEach(products::add);

        return products;
    }

    public Product getProductById(Integer id) {
        return productRepository.findOne(id);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void updateProduct(Product product, Integer id) {
        productRepository.save(product);
    }

    public void deleteProduct(Integer id) {
        productRepository.delete(id);
    }

}
