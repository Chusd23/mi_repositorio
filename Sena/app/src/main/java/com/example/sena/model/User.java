package com.example.sena.model;

public class User {
    private String email;
    private String documento;
    private String nombre;

    public User(String email, String documento, String nombre) {
        this.email = email;
        this.documento = documento;
        this.nombre = nombre;
    }

    // --- Getters ---
    public String getEmail() { return email; }
    public String getDocumento() { return documento; }
    public String getNombre() { return nombre; }
}
