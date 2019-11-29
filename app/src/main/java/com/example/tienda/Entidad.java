package com.example.tienda;

public class Entidad {
    private int prod, camion;
    private String nombre,proveedor;
    private float precio, entrega;

    public Entidad(int prod, int camion, String nombre, String proveedor, float precio, float entrega) {
        this.prod = prod;
        this.camion = camion;
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.precio = precio;
        this.entrega = entrega;
    }

    public int getProd() {
        return prod;
    }

    public void setProd(int prod) {
        this.prod = prod;
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getEntrega() {
        return entrega;
    }

    public void setEntrega(float entrega) {
        this.entrega = entrega;
    }
}

