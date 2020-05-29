package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    DealershipRepository dealershipRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CarRepository carRepository;

    @Override
    public void run(String... strings) throws Exception {
        Dealership dealership = new Dealership();
        Category sedanCategory = new Category();
        Set<Category> categoriesSet = new HashSet<Category>();
        Car jettaCar = new Car();
        Set<Car> carsSet = new HashSet<Car>();

        jettaCar.setMake("Volkswagen");
        jettaCar.setModel("Jetta");
        jettaCar.setYear(2019);
        jettaCar.setQty(3);
        jettaCar.setCategory(sedanCategory);

        carsSet.add(jettaCar); // add jettaCar to carsSet hashset
        sedanCategory.setName("Sedan");
        categoriesSet.add(sedanCategory); // add sedanCategory to categoriesSet hashset

        dealership.setName("Andrew's Dealership");
        dealership.setCategories(categoriesSet); // set categoriesSet hashset to dealership

        carRepository.save(jettaCar);
        categoryRepository.save(sedanCategory);

    }

}
