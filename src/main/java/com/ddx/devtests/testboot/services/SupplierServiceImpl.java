package com.ddx.devtests.testboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddx.devtests.testboot.domain.Supplier;
import com.ddx.devtests.testboot.repositories.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService {
    private SupplierRepository supplierRepository;

    @Autowired
    public void setSupplierRepository(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Iterable<Supplier> listAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier getSupplierById(Integer id) {
        return supplierRepository.findOne(id);
    }

    @Override
    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public void deleteSupplier(Integer id) {
        supplierRepository.delete(id);
    }
}
