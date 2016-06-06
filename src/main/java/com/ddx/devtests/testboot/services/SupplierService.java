package com.ddx.devtests.testboot.services;

import com.ddx.devtests.testboot.domain.Supplier;

public interface SupplierService {
    Iterable<Supplier> listAllSuppliers();

    Supplier getSupplierById(Integer id);

    Supplier saveSupplier(Supplier supplier);

    void deleteSupplier(Integer id);
}