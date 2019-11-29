package com.example.tienda;

public class Producto {
    int id;
    String name, thumbnail_url, provider;
    double price, delivery;

    public Producto(int id, String name, String thumbnail_url, String provider, double price, double delivery) {
        this.id = id;
        this.name = name;
        this.thumbnail_url = thumbnail_url;
        this.provider = provider;
        this.price = price;
        this.delivery = delivery;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public double getDelivery() {
        return delivery;
    }

    public void setDelivery(float delivery) {
        this.delivery = delivery;
    }
}
