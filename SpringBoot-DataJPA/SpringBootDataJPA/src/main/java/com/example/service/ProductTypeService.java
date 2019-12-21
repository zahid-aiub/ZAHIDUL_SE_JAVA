package com.example.service;

import com.example.models.Product;
import com.example.models.ProductType;
import com.example.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    public Object getAllProductType() {
        List<ProductType> productTypes = new ArrayList<>();
        productTypeRepository.findAll().forEach(productTypes::add);

        return productTypes;
    }

    public ProductType getProductTypeById(Integer id) {
        return productTypeRepository.findOne(id);
    }

    public void addProductType(ProductType productType) {
        productTypeRepository.save(productType);
    }

    public void updateProductType(ProductType productType, Integer id) {
        productTypeRepository.save(productType);
    }

    public void deleteProductType(Integer id) {
        productTypeRepository.delete(id);

    }
}
