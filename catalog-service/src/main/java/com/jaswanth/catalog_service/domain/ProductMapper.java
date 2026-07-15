package com.jaswanth.catalog_service.domain;

public class ProductMapper {

    public static Product toProduct(ProductEntity productEntity){
        return new Product(
                productEntity.getCode(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getImageUrl(),
                productEntity.getPrice());
    }
}
