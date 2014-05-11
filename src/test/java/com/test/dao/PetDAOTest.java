package com.test.dao;

import com.test.domain.Cat;
import com.test.domain.Dog;
import com.test.domain.Person;
import com.test.domain.Pet;
import com.test.domain.util.GENDER;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:testContext.xml"})
public class PetDAOTest {

    private List<Pet> originalPets = new LinkedList<>();

    @Inject
    private PetDAO petDAO;

    @Inject
    private PersonDAO personDAO;

    @Before
    public void setUp() {

        Person owner = new Person();
        owner.setDateOfBirth(new Date());
        owner.setFirstName("Joe");
        owner.setGender(GENDER.MALE);
        owner.setLastName("Big");

        Cat cat = new Cat();
        cat.setOwner(owner);
        cat.setName("kitty");

        originalPets.add(cat);

        Dog dog = new Dog();
        dog.setOwner(owner);
        dog.setFriendly(true);

        originalPets.add(dog);

        petDAO.storePet(originalPets);

    }

    @After
    public void tearDown() {

        for (Pet pet : originalPets) {
            petDAO.deletePet(pet);
        }

    }

    @Test
    public void testNumberOfPetsPerOwner() {

        List<Person> owners = personDAO.readPersonByFirstNameUsingHQL(originalPets.get(0).getOwner().getFirstName());
        assertEquals(2, owners.get(0).getPets().size());

    }

    @Test
    public void testReadPetByName() throws Exception {

        Pet cat = originalPets.get(0);
        List<Pet> pets = petDAO.readPetByName(cat.getName());

        assertEquals(1, pets.size());
        assertEquals(pets.get(0), cat);

    }

    @Test
    public void testReadByOwner() {
        Person owner = originalPets.get(0).getOwner();
        List<Pet> pets = petDAO.readPetByOwner(owner);

        assertEquals(2, pets.size());
        assertEquals(owner, pets.get(0).getOwner());

    }

}