package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Pet;

public interface PetDao {
	int addPet(Pet pet) throws SQLException;
	int deletePetById(int petId) throws SQLException;
	List<Pet> getAllPets() throws SQLException;
	List<Pet> getAvailablePets() throws SQLException;
}
