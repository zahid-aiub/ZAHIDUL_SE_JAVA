package com.example.repository;

import com.example.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    public List<Product> findByProductTypeId(Integer productTypeId);
}
