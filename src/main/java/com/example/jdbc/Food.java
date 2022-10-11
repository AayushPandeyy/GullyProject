/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package com.example.jdbc;

public class Food {
	private int quantity;
	private String name;

	private float price;



    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Food{" + "quantity=" + quantity + ", name=" + name + ", price=" + price + '}';
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Food(int quantity, String name, float price) {
        this.quantity = quantity;
        this.name = name;
        this.price = price;
    }



    public Food() {
    }

    public Food(String name, float price) {
        this.name = name;
        this.price = price;
    }


	
}

 
