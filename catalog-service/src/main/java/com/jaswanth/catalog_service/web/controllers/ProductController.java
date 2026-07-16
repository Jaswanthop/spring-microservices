package com.jaswanth.catalog_service.web.controllers;


import com.jaswanth.catalog_service.domain.PagedResult;
import com.jaswanth.catalog_service.domain.Product;
import com.jaswanth.catalog_service.domain.ProductNotFoundException;
import com.jaswanth.catalog_service.domain.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
 class ProductController {

    private ProductService productService;

     ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    PagedResult<Product> getProducts(@RequestParam(name="page",defaultValue = "1")int pageNo){
         return productService.getProducts(pageNo);
    }



     @GetMapping("/{code}")
    ResponseEntity<Product> getProductByCode(@PathVariable String code){
         return productService.getProductByCode(code)
                 .map(ResponseEntity::ok)
                 .orElseThrow(()-> ProductNotFoundException.forCode("Product not found with code" + code));
    }
}
