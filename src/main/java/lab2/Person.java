package lab2;

import java.util.Objects;

public class Person {
    public Person(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }
    private String name;
    private int age;
    private String phone;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Person)) return false;
        Person otherPerson = (Person) other;

        return this.getName().equals(otherPerson.getName())
                && this.getAge() == otherPerson.getAge()
                && this.getPhone().equals(otherPerson.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, phone);
    }
}
