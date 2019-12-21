package com.example.controller;

import com.example.models.Product;
import com.example.models.ProductType;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/getAll")
    public Object getAllProducts() {
        return this.productService.getAllProduct();
    }

    @RequestMapping("/getById/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addProduct")
    public void addProduct(@RequestBody Product product) {
//        product.setProductType(new ProductType(typeId, ""));
        productService.addProduct(product);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/productType/{typeId}/product/{productId}")
    public void updateProduct(@RequestBody Product product, @PathVariable Integer typeId, @PathVariable Integer productId) {
        product.setProductType(new ProductType(typeId, ""));
        productService.updateProduct(product, productId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteProduct/{productId}")
    public void deleteProduct(@PathVariable Integer productId) {
        productService.deleteProduct(productId);
    }

}
