package com.example.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Dealership {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany(mappedBy = "dealership",
        cascade = CascadeType.ALL,
        fetch = FetchType.EAGER)
    private Set<Car> cars;

    public Dealership(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
