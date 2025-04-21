package br.com.project_test.Models;

import java.util.List;
import java.util.UUID;

public class Host extends User{

    public Host() {}

    public Host(String name, String email, String password, List<Address> addresses) {
        super(name, email, password, 0, addresses);
    }
}
