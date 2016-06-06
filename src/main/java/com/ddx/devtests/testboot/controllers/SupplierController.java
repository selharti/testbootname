package com.ddx.devtests.testboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ddx.devtests.testboot.domain.Supplier;
import com.ddx.devtests.testboot.services.SupplierService;

@Controller
public class SupplierController {

    private SupplierService supplierService;

    @Autowired
    public void setSupplierService(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @RequestMapping(value = "/suppliers", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("suppliers", supplierService.listAllSuppliers());
        return "suppliers";
    }

    @RequestMapping("supplier/{id}")
    public String showSupplier(@PathVariable Integer id, Model model){
        model.addAttribute("supplier", supplierService.getSupplierById(id));
        return "suppliershow";
    }

    @RequestMapping("supplier/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("supplier", supplierService.getSupplierById(id));
        return "supplierform";
    }

    @RequestMapping("supplier/new")
    public String newSupplier(Model model){
        model.addAttribute("supplier", new Supplier());
        return "supplierform";
    }

    @RequestMapping(value = "supplier", method = RequestMethod.POST)
    public String saveSupplier(Supplier supplier){
        supplierService.saveSupplier(supplier);
        return "redirect:/supplier/" + supplier.getId();
    }

    @RequestMapping("supplier/delete/{id}")
    public String delete(@PathVariable Integer id){
        supplierService.deleteSupplier(id);
        return "redirect:/suppliers";
    }

}
