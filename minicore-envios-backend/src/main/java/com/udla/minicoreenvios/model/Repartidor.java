package com.udla.minicoreenvios.model;

public class Repartidor {
    private int idRepartidor;
    private String nombre;
    private String email;

    public Repartidor(int idRepartidor, String nombre, String email) {
        this.idRepartidor = idRepartidor;
        this.nombre = nombre;
        this.email = email;
    }

    public int getIdRepartidor() {
        return idRepartidor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }
}
