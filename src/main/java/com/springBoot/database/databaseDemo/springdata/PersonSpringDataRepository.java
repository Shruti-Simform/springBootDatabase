package com.springBoot.database.databaseDemo.springdata;

import com.springBoot.database.databaseDemo.jpaDemo.entity.PersonJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonSpringDataRepository extends JpaRepository<PersonJpa,Integer> {
}
