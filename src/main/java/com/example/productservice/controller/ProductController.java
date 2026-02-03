package com.example.productservice.controller;

import com.example.productservice.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;

@RestController
public class ProductController {
    private final List<Product> products = new ArrayList<>();

    //http://localhost:8080/products
    @GetMapping("/products")
    public List<Product> getProducts(){
        return products;
    }

    //http://localhost:8080/addProduct
    @PostMapping("/addProduct")
    public ResponseEntity<Object> addProduct(@RequestBody Product product){
        if (product.getName().isEmpty() || product.getSellingPrice()==0
                || product.getName().toLowerCase().contains("test")){
            return ResponseEntity.badRequest().body("Invalid input");
        }

        products.add(product);
        return ResponseEntity.ok(product);
    }

    //to view products with more than 50% discount
    //http://localhost:8080/products/discount
    @GetMapping("/products/morethanfiftyplusdiscount")
    public List<Product> getMoreThanFiftyPlusDiscountedProducts(){
        List<Product> discountedProducts = new ArrayList<>();
        for (Product product: products){
            if (product.getDiscount() >=50) {
                discountedProducts.add(product);
            }
        }
        return discountedProducts;
    }

}
