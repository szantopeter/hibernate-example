package com.test.dao;

import com.test.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.inject.Inject;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:testContext.xml"})
public class PersonDAOTest {

    @Inject
    private PersonDAO personDAO;

    @Test
    public void testReadPersonByFirstName() throws Exception {
        List<Person> personList = personDAO.readPersonByFirstName("Peter");

        int peterCount = 0;
        for (Person person : personList) {
            if (person.getFirstName().equals("Peter")) {
                peterCount++;
            }
        }

        assertEquals("Number of Peters should be 2", 2, peterCount);

    }
}