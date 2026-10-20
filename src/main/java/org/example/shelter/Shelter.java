package org.example.shelter;

import org.example.model.AdoptionStatus;
import org.example.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class Shelter <T extends Animal>{
    private final List<T> animals = new ArrayList<>();

    public void addAnimal(T animal){
        animals.add(animal);
    }

    public List<T> getAllAnimals(){
        return this.animals;
    }

    public List<T> findBySpecies(String species){
        List <T> res = new ArrayList<>();
        for (T animal : animals){
            if (animal.getSpecies().equals(species)) {
                res.add(animal);
            }
        }
        return res;
    }

    public List<T> findAvailableAnimals(){
        List <T> res = new ArrayList<>();
        for (T animal : animals) {
            if (animal.getAdoptionStatus() == AdoptionStatus.AVAILABLE){
                res.add(animal);
            }
        }
        return res;
    }

    public void markAsAdopted(String id){
        for (T animal : animals){
            if (animal.getId().equals(id)) {
                animal.markAsAdopted();
                break;
            }
        }
    }
}
