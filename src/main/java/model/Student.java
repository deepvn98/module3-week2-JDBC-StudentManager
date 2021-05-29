package model;

public class Student {
    private int id;
    private String name;
    private int age;
    private Country country;

    public Student() {
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student(int id, String name, int age, Country country) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public Student(String name, int age, Country country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
