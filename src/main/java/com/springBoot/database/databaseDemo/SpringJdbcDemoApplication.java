package com.springBoot.database.databaseDemo;

import com.springBoot.database.databaseDemo.springjdbc.entity.Person;
import com.springBoot.database.databaseDemo.springjdbc.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("\nAll users -> {}", dao.findAll());
		logger.info("\nuser Id 102 -> {}",dao.findById(102));
		logger.info("\nuser Id 102 Name 'Swati' -> {}",dao.findByIdName(102,"Swati"));
		logger.info("\nDeleting Id 102 -> No of rows affected - {}",dao.deleteById(102));
		logger.info("\nInserting Id 102 -> {} row inserted",dao.insertData(new Person(102,"Swati","MP",new Date())));
		logger.info("\nUpdating 102 -> {} row updated",dao.updateData("Pandey",102));
	}
}
