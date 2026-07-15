package com.jaswanth.catalog_service.domain;

import org.springframework.data.jpa.repository.JpaRepository;

interface ProductRepositry extends JpaRepository<ProductEntity,Long> {

}
