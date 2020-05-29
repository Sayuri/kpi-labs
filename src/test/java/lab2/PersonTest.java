package lab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    @Test
    void equals() {
        Person person1 = new Person("Julia", 30, "+380964412728");
        Person person2 = new Person("Julia", 30, "+380964412728");
        Person person3 = new Person("Sergey", 30, "+380964412728");
        Person person4 = new Person("Julia", 60, "+380964412728");
        Person person5 = new Person("Julia", 30, "+111111111111");

        assertTrue(person1.equals(person2));
        assertFalse(person1.equals(person3));
        assertFalse(person1.equals(person4));
        assertFalse(person1.equals(person5));
    }
}
