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
        Category category2 = new Category();
        Category category3 = new Category();

        category.setName("Sedans");
        category2.setName("Trucks");
        category2.setName("Vans");


        Car car = new Car();
        car.setMake("Volkswagen");
        car.setModel("Jetta");
        car.setYear(2019);
        car.setQty(3);
        car.setImg("https://www.tflcar.com/wp-content/uploads/2019/04/2019_vw_jetta_04.jpg");
        car.setCategory(category);

        Car car2 = new Car();
        car2.setMake("Ford");
        car2.setModel("F-150");
        car2.setYear(2008);
        car2.setQty(10);
        car2.setImg("https://www.tflcar.com/wp-content/uploads/2019/04/2019_vw_jetta_04.jpg");
        car2.setCategory(category2);

        Car car3 = new Car();
        car3.setMake("Honda");
        car3.setModel("Odyssey");
        car3.setYear(2020);
        car3.setQty(6);
        car3.setImg("https://www.tflcar.com/wp-content/uploads/2019/04/2019_vw_jetta_04.jpg");
        car3.setCategory(category3);

        Set<Car> cars = new HashSet<Car>();
        cars.add(car); // add car to cars hashset
        cars.add(car2); // add car to cars hashset
        cars.add(car3); // add car to cars hashset

        Set<Category> categories = new HashSet<Category>();
        categories.add(category); // add category to categories hashset
        categories.add(category2); // add category to categories hashset
        categories.add(category3); // add category to categories hashset

//        dealership.setName("Andrew's Dealership");
//        dealership.setCategories(categories); // set categories hashset to dealership

        // why do I have to save category before car?
        categoryRepository.save(category);
        categoryRepository.save(category2);
        categoryRepository.save(category3);
        carRepository.save(car);
        carRepository.save(car2);
        carRepository.save(car3);

    }

}
