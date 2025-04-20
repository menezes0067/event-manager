package br.com.project_test.Models;

import java.util.List;

public class Client extends User{
    private List<Address> addresses;

    public Client() {}

    public Client(String name, String email, String password, List<Address> addresses) {
        super(name, email, password, 1);
        this.addresses = addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Address> getAddresses() {
        return addresses;
    }
}
