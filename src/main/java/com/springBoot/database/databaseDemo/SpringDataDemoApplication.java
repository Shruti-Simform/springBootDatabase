package com.springBoot.database.databaseDemo;

import com.springBoot.database.databaseDemo.jpaDemo.entity.PersonJpa;
import com.springBoot.database.databaseDemo.springdata.PersonSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;

//@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonSpringDataRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("\nAll users -> {}",repository.findAll());
		logger.info("\nuser Id 102 -> {}",repository.findById(102));
		repository.deleteById(102);
		logger.info("\nInserting Id 104 -> {} row inserted",repository.save(new PersonJpa("ABC","MP",new Date())));
		logger.info("\nUpdating 102 -> {} row updated",repository.save(new PersonJpa(101,"Swati","MP",new Date())));
	}
}
