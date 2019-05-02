package Person;

import java.util.Objects;

public class Person implements Comparable<Person>{
    private String Name;
    private int Age;

    public Person() {
    }

    public Person(String name, int age) {
        Name = name;
        Age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    @Override
    public String toString() {
        return "Person.Person{" +
                "Name='" + Name + '\'' +
                ", Age=" + Age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Age == person.Age &&
                Objects.equals(Name, person.Name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(Name, Age);
    }

    @Override
    public int compareTo(Person o) {
        return this.getName().compareTo(o.getName());
    }
}
