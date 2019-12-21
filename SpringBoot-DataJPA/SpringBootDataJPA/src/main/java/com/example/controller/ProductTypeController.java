package com.example.controller;

import com.example.models.ProductType;
import com.example.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @RequestMapping("/getProductType")
    public Object getAllProductType(){
        return this.productTypeService.getAllProductType();
    }

    @RequestMapping("/getProductType/{id}")
    public ProductType getProductTypeById(@PathVariable Integer id) {
        return productTypeService.getProductTypeById(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/addProductType")
    public void addProductType(@RequestBody ProductType productType) {
        productTypeService.addProductType(productType);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/updateProductType/{id}")
    public void updateProductType(@RequestBody ProductType productType, @PathVariable Integer id) {
        productTypeService.updateProductType(productType, id);
    }

    @RequestMapping("/deleteProductType/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productTypeService.deleteProductType(id);
    }

}
