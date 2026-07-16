package com.jaswanth.catalog_service.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface ProductRepositry extends JpaRepository<ProductEntity,Long> {
   Optional<ProductEntity> findBycode(String code);
}
