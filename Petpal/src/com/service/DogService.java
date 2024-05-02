package com.service;

import java.sql.SQLException;

import com.dao.DogDao;
import com.dao.DogDaoImpl;
import com.model.Dog;

public class DogService {
	DogDao dogDao=new DogDaoImpl();
	public int insert(Dog dog) throws SQLException {
		return dogDao.addDog(dog);
	}

}
