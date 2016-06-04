package com.ddx.devtests.testboot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ddx.devtests.testboot.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
}