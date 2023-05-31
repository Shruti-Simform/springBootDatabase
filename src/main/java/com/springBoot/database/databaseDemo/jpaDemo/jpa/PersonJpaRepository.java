package com.springBoot.database.databaseDemo.jpaDemo.jpa;

import com.springBoot.database.databaseDemo.jpaDemo.entity.PersonJpa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {
    @PersistenceContext
    EntityManager entityManager;

    public List<PersonJpa> findAll(){
        TypedQuery<PersonJpa> namedQuery = entityManager.createNamedQuery("find_all",PersonJpa.class);
        return namedQuery.getResultList();
    }
    public PersonJpa findById(int id) {
        return entityManager.find(PersonJpa.class, id);
    }
    public PersonJpa update(PersonJpa personJpa) {
        return entityManager.merge(personJpa);
    }
    public PersonJpa insert(PersonJpa personJpa) {
        return entityManager.merge(personJpa);
    }
    public void deleteById(int id) {
        PersonJpa personJpa = findById(id);
        entityManager.remove(personJpa);
    }
}
