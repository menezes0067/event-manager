package br.com.project_test.Models;

public class Address {
    private String state;
    private String city;
    private String street;
    private int number_house;
    private String complement;
    private String district;

    public Address() {}

    public Address(String state, String city, String street, int number_house, String complement, String district) {
        this.state = state;
        this.city = city;
        this.street = street;
        this.number_house = number_house;
        this.complement = complement;
        this.district = district;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setNumber_house(int number_house) {
        this.number_house = number_house;
    }

    public int getNumber_house() {
        return number_house;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getComplement() {
        return complement;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDistrict() {
        return district;
    }
}


