package com.ddx.devtests.testboot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ddx.devtests.testboot.domain.Supplier;

public interface SupplierRepository extends CrudRepository<Supplier, Integer>{
}