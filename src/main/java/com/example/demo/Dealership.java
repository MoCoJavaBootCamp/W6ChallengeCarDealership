//package com.example.demo;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//public class Dealership {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;
//
//    private String name;
//
//    @OneToMany(mappedBy = "dealership",
//        cascade = CascadeType.ALL,
//        fetch = FetchType.EAGER)
//    private Set<Category> categories;
//
//    public Dealership(){
//        this.categories = null;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Set<Category> getCategories() {
//        return categories;
//    }
//
//    public void setCategories(Set<Category> categories) {
//        this.categories = categories;
//    }
//}
