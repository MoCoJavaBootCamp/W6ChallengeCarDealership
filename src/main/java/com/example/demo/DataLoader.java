package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
//    @Autowired
//    DealershipRepository dealershipRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CarRepository carRepository;

    @Override
    public void run(String... strings) throws Exception {
//        Dealership dealership = new Dealership();
        Category category = new Category();
        category.setName("Sedan");

        Car car = new Car();
        car.setMake("Volkswagen");
        car.setModel("Jetta");
        car.setYear(2019);
        car.setQty(3);
        car.setImg("https://www.tflcar.com/wp-content/uploads/2019/04/2019_vw_jetta_04.jpg");
        car.setCategory(category);

        Set<Car> cars = new HashSet<Car>();
        cars.add(car); // add car to cars hashset

        Set<Category> categories = new HashSet<Category>();
        categories.add(category); // add category to categories hashset

//        dealership.setName("Andrew's Dealership");
//        dealership.setCategories(categories); // set categories hashset to dealership

        // why do I have to save category before car?
        categoryRepository.save(category);
        carRepository.save(car);

    }

}
