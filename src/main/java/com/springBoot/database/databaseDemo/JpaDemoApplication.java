package com.springBoot.database.databaseDemo;

import com.springBoot.database.databaseDemo.jpaDemo.entity.PersonJpa;
import com.springBoot.database.databaseDemo.jpaDemo.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("\nAll users -> {}",repository.findAll());
		logger.info("\nuser Id 102 -> {}",repository.findById(102));
		repository.deleteById(102);
		logger.info("\nInserting Id 104 -> {} row inserted",repository.insert(new PersonJpa("ABC","MP",new Date())));
		logger.info("\nUpdating 102 -> {} row updated",repository.update(new PersonJpa(101,"Swati","MP",new Date())));
	}
}
