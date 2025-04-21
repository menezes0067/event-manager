package br.com.project_test.Models;

import java.util.List;

public class Client extends User{

    public Client() {}

    public Client(String name, String email, String password, List<Address> addresses) {
        super(name, email, password, 1, addresses);
    }
}
