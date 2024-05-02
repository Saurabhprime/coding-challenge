package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.PetDao;
import com.dao.PetDaoImpl;
import com.exception.InvalidPetAgeException;
import com.model.Pet;

public class PetService {
	PetDao petDao = new PetDaoImpl();

	public int insert(Pet pet) throws SQLException, InvalidPetAgeException {
		if (pet.getAge() <= 0)
			throw new InvalidPetAgeException("Invalid age, Please enter a valid age");
		return petDao.addPet(pet);
	}
	
	public int deletePetById(int petId) throws SQLException {
		return petDao.deletePetById(petId);
	}
	
	public List<Pet> getAvailablePets() throws SQLException {
		return petDao.getAvailablePets();
	}

	public List<Pet> getAllPets() throws SQLException {
		return petDao.getAllPets();
	}

	

	
}
