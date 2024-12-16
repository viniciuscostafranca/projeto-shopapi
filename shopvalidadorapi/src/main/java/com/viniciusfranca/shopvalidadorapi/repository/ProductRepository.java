package com.viniciusfranca.shopvalidadorapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import	org.springframework.stereotype.Repository;

import com.viniciusfranca.shopvalidadorapi.model.Product;
@Repository
public interface ProductRepository
extends JpaRepository<Product, Long> {
    Product findByIdentifier(String identifier);
}
