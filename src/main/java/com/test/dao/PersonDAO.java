package com.test.dao;

import com.test.domain.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class PersonDAO {

    @PersistenceContext(name="test")
    private EntityManager entityManager;


    public List<Person> readPersonByFirstNameUsingNativeQuery(String firstName) {

        Query q = entityManager.createNativeQuery("SELECT * FROM person WHERE firstname = :firstname", Person.class);
        q.setParameter("firstname", firstName);

        List<Person> result = q.getResultList();

        return result;

    }

    public List<Person> readPersonByFirstNameUsingHQL(String firstName) {

        Query q = entityManager.createQuery("from Person p where p.firstName = :firstName", Person.class);
        q.setParameter("firstName", firstName);

        List<Person> result = q.getResultList();

        return result;

    }

    @Transactional
    public void storePerson(Person person) {
        entityManager.persist(person);
    }

}
