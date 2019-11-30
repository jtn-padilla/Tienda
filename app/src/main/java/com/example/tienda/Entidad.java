package com.example.tienda;

public class Entidad {
    private int camion;
    int id;
    private String thumb;
    private String nombre,proveedor;
    private double precio, entrega;

    public Entidad(int id, String thumb, int camion, String nombre, String proveedor, double precio, double entrega) {
        this.id = id;
        this.thumb = thumb;
        this.camion = camion;
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.precio = precio;
        this.entrega = entrega;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public int getCamion() {
        return camion;
    }

    public void setCamion(int camion) {
        this.camion = camion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public double getEntrega() {
        return entrega;
    }

    public void setEntrega(float entrega) {
        this.entrega = entrega;
    }
}

