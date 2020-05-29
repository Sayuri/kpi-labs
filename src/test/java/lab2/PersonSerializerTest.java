package lab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonSerializerTest {
    @Test
    void toJson() {
        Person person = new Person("Julia", 30, "+380964412728");
        assertTrue(PersonSerializer.toJson(person)
                .equals("{\"name\":\"Julia\",\"age\":30,\"phone\":\"+380964412728\"}"));
    }

    @Test
    void fromJson() {
        Person person = new Person("Julia", 30, "+380964412728");
        String json = "{\"name\":\"Julia\",\"age\":30,\"phone\":\"+380964412728\"}";

        Person personFromJson = PersonSerializer.fromJson(json);
        assertEquals(person, personFromJson);
    }
}
