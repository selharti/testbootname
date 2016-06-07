package com.ddx.devtests.testboot.bootstartup;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.ddx.devtests.testboot.domain.Product;
import com.ddx.devtests.testboot.domain.Supplier;
import com.ddx.devtests.testboot.repositories.ProductRepository;
import com.ddx.devtests.testboot.repositories.SupplierRepository;

import java.math.BigDecimal;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

	private ProductRepository productRepository;
	
	private SupplierRepository supplierRepository;

	private Logger log = Logger.getLogger(ProductLoader.class);

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	@Autowired
	public void setSupplierRepository(SupplierRepository supplierRepository) {
		this.supplierRepository = supplierRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		// SE - add some data only if the database is empty
		Iterable<Product> products = productRepository.findAll();

		int count = 0;

		for (Product p : products) {
			count++;
		}
		if (count == 0) {
			try {
				
				Supplier supplierA = new Supplier();
				
				supplierA.setName("Ddefault Supplier A");
				supplierA.setAddress("Living here : Address");
				supplierRepository.save(supplierA);
				log.info("Saved supplier - id: " + supplierA.getId());
				
				
				Product shirt = new Product();
				shirt.setDescription("Spring Framework Guru Shirt");
				shirt.setPrice(new BigDecimal("18.95"));
				shirt.setImageUrl(
						"https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg");
				shirt.setProductId("235268845711068308");
				shirt.setProductSupplier(supplierA);
				
				productRepository.save(shirt);

				log.info("Saved Shirt - id: " + shirt.getId());

				Product mug = new Product();
				mug.setDescription("Spring Framework Guru Mug");
				mug.setImageUrl(
						"https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_coffee_mug-r11e7694903c348e1a667dfd2f1474d95_x7j54_8byvr_512.jpg");
				mug.setProductId("168639393495335947");

				mug.setProductSupplier(supplierA);

				
				productRepository.save(mug);

				log.info("Saved Mug - id:" + mug.getId());
			} catch (Exception ex) {
				log.error(" ========== ========= ======= On init catched maybe already created...");
log.error(ex.getStackTrace());
			}
		}
	}
}