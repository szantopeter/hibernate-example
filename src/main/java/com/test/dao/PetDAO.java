package com.test.dao;

import com.test.domain.Person;
import com.test.domain.Pet;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class PetDAO {

    @PersistenceContext(name="test")
    private EntityManager entityManager;

    @Transactional
    public void storePet(List<Pet> pets) {
        for (Pet pet : pets) {
            entityManager.persist(pet);
        }
    }

    public List<Pet> readPetByName(String name) {

        Query q = entityManager.createQuery("from Pet p where p.name = :name", Pet.class);
        q.setParameter("name", name);

        return q.getResultList();



    }

    public List<Pet> readPetByOwner(Person owner) {
        Query q = entityManager.createQuery("from Pet p where p.owner = :owner", Pet.class);
        q.setParameter("owner", owner);

        return q.getResultList();
    }

    @Transactional
    public void deletePet(Pet pet) {
        entityManager.createQuery("delete Pet where id=:id").setParameter("id", pet.getId()).executeUpdate();
    }
}
