package com.test.dao;

import com.test.domain.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PersonDAO {

    @PersistenceContext(name="test")
    private EntityManager entityManager;


    public List<Person> readPersonByFirstName(String firstName) {

        Query q = entityManager.createNativeQuery("SELECT * FROM person WHERE firstname = :firstname", Person.class);
        q.setParameter("firstname", firstName);

        List<Person> result = q.getResultList();

        return result;

    }

}
