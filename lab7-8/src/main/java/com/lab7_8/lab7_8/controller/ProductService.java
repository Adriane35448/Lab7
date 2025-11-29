package com.lab7_8.lab7_8.controller;

import com.lab7_8.lab7_8.model.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductService
{
    Product product;

    @GetMapping("{productId}")
    public Product getProductDetails(String productId)
    {
        return product;
        //new Product("G1","Laptop","50000");
    }

    @PostMapping
    public String createProductDetails(@RequestBody Product product)
    {
        this.product = product;
        return "Product Created Successfully";
    }

    @PutMapping
    public String updateProductDetails(@RequestBody Product product)
    {
        this.product = product;
        return "Product Updated Successfully";
    }

    @DeleteMapping("{productId}")
    public String deleteProductDetails(String productId)
    {
        this.product = null;
        return "Product Deleted Successfully";
    }
}