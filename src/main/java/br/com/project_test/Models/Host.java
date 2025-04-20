package br.com.project_test.Models;

import java.util.UUID;

public class Host extends User{

    public Host() {}

    public Host(String name, String email, String password) {
        super(name, email, password, 0);
    }
}
