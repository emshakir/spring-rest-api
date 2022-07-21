package com.spring.restapi.bootstrap;

import com.spring.restapi.Domain.*;
import com.spring.restapi.repositories.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;
    private final VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCategoryData();
        loadCustomerData();
        loadVendors();
    }

    private void loadCategoryData() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        System.out.println("Data Loaded = " + categoryRepository.count());
    }

    private void loadCustomerData() {
        Customer customer1 = new Customer();
        customer1.setFirstname("Mohammad");
        customer1.setLastname("Shakir");

        Customer customer2 = new Customer();
        customer2.setFirstname("Kalvagadda");
        customer2.setLastname("Chandrashekar");

        Customer customer3 = new Customer();
        customer3.setFirstname("Dasari");
        customer3.setLastname("Anil");

        Customer customer4 = new Customer();
        customer4.setFirstname("Banaram");
        customer4.setLastname("Charan");

        Customer customer5 = new Customer();
        customer5.setFirstname("Mohammad");
        customer5.setLastname("Arif");

        Customer customer6 = new Customer();
        customer6.setFirstname("Eslavath");
        customer6.setLastname("Krishna Naik");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);
        customerRepository.save(customer5);
        customerRepository.save(customer6);

        System.out.println("Customer Data Loaded :::::::: " + customerRepository.count());
    }

    private void loadVendors() {
        Vendor vendor1 = new Vendor();
        vendor1.setName("Vendor 1");
        vendorRepository.save(vendor1);

        Vendor vendor2 = new Vendor();
        vendor2.setName("Vendor 2");
        vendorRepository.save(vendor2);

    }

}
