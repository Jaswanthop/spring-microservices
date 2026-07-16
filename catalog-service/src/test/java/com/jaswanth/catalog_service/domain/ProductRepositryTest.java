package com.jaswanth.catalog_service.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest(
        properties = {
                "spring.test.database.replace=none",
                "spring.datasource.url=jdbc:tc:postgresql:17-alpine:///db",
        })
class ProductRepositryTest {

    @Autowired
    private ProductRepositry productRepositry;

    @Test
    void shouldGetAllProducts() {
        List<ProductEntity> products = productRepositry.findAll();
        assertThat(products).hasSize(15);
    }
}