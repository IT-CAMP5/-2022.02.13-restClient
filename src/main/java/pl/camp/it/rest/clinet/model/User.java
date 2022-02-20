package pl.camp.it.rest.clinet.model;

public class User {
    private int id;
    private String name;
    private String surname;
    private int age;
    private Address address;

    public User(int id, String name, String surname, int age, Address address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public User() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
