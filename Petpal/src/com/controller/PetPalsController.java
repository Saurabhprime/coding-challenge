package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.exception.InvalidPetAgeException;
import com.model.Cat;
import com.model.Dog;
import com.model.Pet;
import com.service.CatService;
import com.service.DogService;
import com.service.PetService;

public class PetPalsController {
	public static void main(String[] args) {
		PetService petService = new PetService();
		CatService catService = new CatService();
		DogService dogService = new DogService();
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println();
			System.out.println("=========Petpal========");
			System.out.println();
			System.out.println("Press 1. Add Pet");
			System.out.println("Press 2. Remove Pet");
			System.out.println("Press 3. Show All Available Pets");
			System.out.println("Press 4. Show All Pets");
			System.out.println("Press 0. To Exit");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting..");
				break;
			}
			switch (input) {
			case 1:
				System.out.println();
				System.out.println("=====Insert Pet=====");
				Random random = new Random();
				int randomNumber = random.nextInt();
				int petId = randomNumber < 0 ? randomNumber * -1 : randomNumber;
				sc.nextLine();
				System.out.print("Enter pet name : ");
				String petName = sc.nextLine();
				System.out.print("Enter pet age : ");
				int petAge = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter pet type (Dog/Cat): ");
				String petType = sc.nextLine();
				int isAvailable = 1;
				Pet pet = new Pet(petId, petName, petAge, petType, isAvailable);

				random = new Random();
				randomNumber = random.nextInt();
				int id = randomNumber < 0 ? randomNumber * -1 : randomNumber;

				try {
					if (petType.equalsIgnoreCase("dog")) {
						System.out.print("Enter dog breed : ");
						String dogBreed = sc.nextLine();
						Dog dog = new Dog(id, dogBreed);
						int petStatus = petService.insert(pet);
						int dogStatus = dogService.insert(dog);
						if (petStatus == 1 && dogStatus == 1)
							System.out.println("Pet added");
						else
							System.out.println("Op failed");
					} else if (petType.equalsIgnoreCase("cat")) {
						System.out.print("Enter cat color : ");
						String catColor = sc.nextLine().trim();
						Cat cat = new Cat(id, catColor);
						int petStatus = petService.insert(pet);
						int catStatus = catService.insert(cat);
						if (petStatus == 1 && catStatus == 1)
							System.out.println("Pet added");
						else
							System.out.println("Op failed");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} catch (InvalidPetAgeException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 2:
				System.out.println();
				try {
					System.out.println("Enter pet_id to delete");
					int petId1 = sc.nextInt();
					int status = petService.deletePetById(petId1);
					if (status == 1)
						System.out.println("Pet Records Deleted");
					else
						System.out.println("OP failed");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 3:
				System.out.println("==========Available Pets=============");
				try {
					List<Pet> list = petService.getAvailablePets();
					for (Pet a : list)
						System.out.println(a);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 4:
				System.out.println("==========All Pets=============");
				try {
					List<Pet> list = petService.getAllPets();
					for (Pet a : list)
						System.out.println(a);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			default:
				System.out.println();
				System.out.println("Invalid Choice");
			}
		}
		sc.close();
	}
}
