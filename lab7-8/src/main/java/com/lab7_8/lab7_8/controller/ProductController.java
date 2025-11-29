package com.lab7_8.lab7_8.controller;

import com.lab7_8.lab7_8.model.Product;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {

    private Product product;

    @QueryMapping
    public Product product(@Argument String productId) {

        if (product != null && product.getProductId().equals(productId)) return product;
        return null;
    }

    @MutationMapping
    public Product createProduct(@Argument String productId,
                                 @Argument String productName,
                                 @Argument String productPrice) {
        this.product = new Product(productId, productName, productPrice);
        return this.product;
    }

    @MutationMapping
    public Product updateProduct(@Argument String productId,
                                 @Argument String productName,
                                 @Argument String productPrice) {
        if (product != null && product.getProductId().equals(productId)) {
            if (productName != null) product.setProductName(productName);
            if (productPrice != null) product.setProductPrice(productPrice);
            return product;
        }
        return null;
    }

    @MutationMapping
    public Boolean deleteProduct(@Argument String productId) {
        if (product != null && product.getProductId().equals(productId)) {
            product = null;
            return true;
        }
        return false;
    }
}