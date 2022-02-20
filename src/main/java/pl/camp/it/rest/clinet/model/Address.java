package pl.camp.it.rest.clinet.model;

public class Address {
    private String street;
    private String code;
    private String city;

    public Address(String street, String code, String city) {
        this.street = street;
        this.code = code;
        this.city = city;
    }

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
