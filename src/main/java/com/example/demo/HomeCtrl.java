package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeCtrl {

    @Autowired CategoryRepository categoryRepository;

    @Autowired CarRepository carRepository;

    @RequestMapping("/categorieslist")
    public String categorieslist(Model model) {
        model.addAttribute("allcategories", categoryRepository.findAll());
        return "categorieslist";
    }

    @RequestMapping("/newcategory")
    public String newCategory (Model model) {
        model.addAttribute("category", new Category());
        return "newcategory";
    }

    @RequestMapping("/updatecategory/{id}")
    public String updateCategory(@PathVariable("id") long id, Model model) {
        model.addAttribute("category", categoryRepository.findById(id).get());
        return "newcategory";
    }

    @RequestMapping("/deletecategory/{id}")
    public String deleteCategory(@PathVariable("id") long id) {
        Category category = categoryRepository.findById(id).get();
        categoryRepository.delete(category);
        return "redirect:/categorieslist";
    }

    @RequestMapping("/processcategory")
    public String processcategory(@ModelAttribute("category") Category category) {
        categoryRepository.save(category);
        return "redirect:/categorieslist";
    }

    @RequestMapping("/carslist")
    public String carslist(Model model) {
        model.addAttribute("allcars", carRepository.findAll());
        return "carslist";
    }

    @RequestMapping("/newcar")
    public String newCar(Model model){
        model.addAttribute("car", new Car());
        model.addAttribute("allcategories", categoryRepository.findAll());
        return "newcar";
    }

    @RequestMapping("/updatecar/{id}")
    public String updateCar(@PathVariable("id") long id, Model model){
        model.addAttribute("car", carRepository.findById(id).get());
        return "newcar";
    }

    @RequestMapping("/deletecar/{id}")
    public String deleteCar(@PathVariable("id") long id){
        Car car = carRepository.findById(id).get();
        carRepository.delete(car);
        return "redirect:/carslist";
    }

    @RequestMapping("/processcar")
    public String processcar(@ModelAttribute("car") Car car) {
        carRepository.save(car);
        return "redirect:/carslist";
    }
}
