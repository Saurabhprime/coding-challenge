package com.service;

import java.sql.SQLException;

import com.dao.CatDao;
import com.dao.CatDaoImpl;
import com.model.Cat;

public class CatService {
	CatDao catDao=new CatDaoImpl();
	public int insert(Cat cat) throws SQLException {
		return catDao.addCat(cat);
	}

}
