package com.example.sena.model;

public class Product {
    private int id;
    private String nombre;
    private double precio;
    private int stock;

    public Product(int id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // --- Getters --- (Necesarios para el Adapter)
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
    // No necesitamos Setters ya que los datos son estáticos
}
