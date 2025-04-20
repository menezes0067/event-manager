package br.com.project_test.Models;

import java.util.UUID;


public abstract class User {
    private UUID id;
    private String name;
    private String email;
    private String password;
    private Integer type_user;

    // Aparentemente precisa ter um construtor vazio para desserialização
    public User() {}

    public User(String name, String email, String password,Integer type_user) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.password = password;
        this.type_user = type_user;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setType_user(Integer type_user) {
        this.type_user = type_user;
    }

    public Integer getType_user() {
        return type_user;
    }


}
