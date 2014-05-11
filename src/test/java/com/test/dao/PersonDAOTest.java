package com.test.dao;

import com.test.domain.Person;
import com.test.domain.util.GENDER;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.inject.Inject;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:testContext.xml"})
public class PersonDAOTest {

    @Inject
    private PersonDAO personDAO;
    private static boolean dbInitialized = false;

    @Before
    public void testSetUp() {

        if (!dbInitialized) {
            Person person = new Person();
            person.setLastName("Last");
            person.setFirstName("First");
            person.setGender(GENDER.MALE);
            person.setDateOfBirth(new Date());

            personDAO.storePerson(person);

            person = new Person();
            person.setLastName("Last");
            person.setFirstName("Peter");
            person.setGender(GENDER.MALE);
            person.setDateOfBirth(new Date());

            personDAO.storePerson(person);

            person = new Person();
            person.setLastName("Last");
            person.setFirstName("Peter");
            person.setGender(GENDER.MALE);
            person.setDateOfBirth(new Date());

            personDAO.storePerson(person);

            person = new Person();
            person.setLastName("Last");
            person.setFirstName("First");
            person.setGender(GENDER.MALE);
            person.setDateOfBirth(new Date());

            personDAO.storePerson(person);

            dbInitialized = true;
        }

    }

    @Test
    public void testReadPersonByFirstNameUsingNativeQuery() throws Exception {
        List<Person> personList = personDAO.readPersonByFirstNameUsingNativeQuery("Peter");

        assertCorrectNumberOfPeter(personList);

    }

    @Test
    public void testReadPersonByFirstNameUsingHQL() {
        List<Person> personList = personDAO.readPersonByFirstNameUsingHQL("Peter");

        assertCorrectNumberOfPeter(personList);

    }

    private void assertCorrectNumberOfPeter(List<Person> personList) {
        int peterCount = 0;
        for (Person person : personList) {
            if (person.getFirstName().equals("Peter")) {
                peterCount++;
            }
        }

        assertEquals("Number of Peters should be 2", 2, peterCount);
    }

}