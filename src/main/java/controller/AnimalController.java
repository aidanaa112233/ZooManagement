package com.example.zoo.zoomanagement.controller;

import com.example.zoo.zoomanagement.dao.AnimalDAO;
import com.example.zoo.zoomanagement.model.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @PostMapping
    public String addAnimal(@RequestBody Animal animal) {
        AnimalDAO.addAnimal(
                animal.name,
                animal.species,
                animal.age,
                animal.enclosure
        );
        return "Animal added successfully";
    }

    @GetMapping
    public List<Animal> getAllAnimals() {
        return AnimalDAO.getAnimalsList();
    }
}
