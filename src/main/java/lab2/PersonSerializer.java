package lab2;

import com.google.gson.*;

public class PersonSerializer {

    public static String toJson(Person person) {
        Gson gson = new Gson();
        return gson.toJson(person);
    }

    public static Person fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Person.class);
    }
}
