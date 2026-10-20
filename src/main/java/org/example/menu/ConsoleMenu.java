package org.example.menu;

import org.example.model.AdoptionStatus;
import org.example.model.Animal;
import org.example.model.AnimalId;
import org.example.model.Dog;
import org.example.shelter.Shelter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {
    private final Shelter<Animal> shelter;
    private final Scanner scanner = new Scanner(System.in);
    public ConsoleMenu(Shelter<Animal> shelter) {
        this.shelter = shelter;
    }
    public void start(){
        int choose;
        while (true){
            printMenu();
            choose = scanner.nextInt();
            if (choose == 1){
                AnimalId id = new AnimalId();
                Animal a1 = new Dog(id, "Barsyk", 1);
                shelter.addAnimal(a1);
            }
            else if (choose == 2){
                List<Animal> animals = shelter.getAllAnimals();
                for (Animal animal : animals){
                    System.out.println(animal);
                }
            }
            else if (choose == 3){
                System.out.print("Type the animal species: ");
                String species = scanner.next();
                List<Animal> animals = shelter.findBySpecies(species);
                for (Animal animal : animals){
                    System.out.println(animal);
                }
            }
            else if (choose == 4){
                List<Animal> animals = shelter.findAvailableAnimals();
                for (Animal animal : animals){
                    System.out.println(animal);
                }
            }
            else if (choose == 5){
                System.out.print("Write the animal id: ");
                String targId = scanner.next();
                for (Animal animal : shelter.getAllAnimals()){
                    if (targId.equals(animal.getId().toString())){
                        animal.markAsAdopted();
                    }
                }
            }
            else break;
        }

    }

    private void printMenu(){
        System.out.println("""
                1. Add animal
                2. List all animals
                3. Find animals by species
                4. List available animals
                5. Mark animal as adopted
                0. Exit
                """);
    }
}
