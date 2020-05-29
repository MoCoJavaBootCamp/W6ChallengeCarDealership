package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeCtrl {
//    @Autowired DealershipRepository dealershipRepository;

    @Autowired CategoryRepository categoryRepository;

    @Autowired CarRepository carRepository;

    @RequestMapping("/categorieslist")
    public String index(Model model) {
        model.addAttribute("allcategories", categoryRepository.findAll());
        return "categorieslist";
    }

    @RequestMapping("/newcategory")
    public String newCategory (Model model) {
        model.addAttribute("category", new Category());
        return "newcategory";
    }

    @RequestMapping("/processcategory")
    public String process(@ModelAttribute("category") Category category) {
        categoryRepository.save(category);
        return "redirect:/categorieslist";
    }

    @RequestMapping("/carslist")
    public String index(Model model) {
        model.addAttribute("allcars", carRepository.findAll());
        return "carslist";
    }

    @RequestMapping("/newcar")
    public String newCategory (Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("allcategories", categoryRepository.findAll());
        return "newcar";
    }

    @RequestMapping("/processcar")
    public String process(@ModelAttribute("car") Car car) {
        carRepository.save(car);
        return "redirect:/carslist";
    }
}
