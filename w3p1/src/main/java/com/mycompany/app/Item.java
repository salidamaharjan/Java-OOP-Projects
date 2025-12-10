package com.mycompany.app;

public class Item {
    private String itemName;
    private Double itemPrice;

    public Item(String name, Double price) {
        this.itemName = name;
        this.itemPrice = price;
    }
    public void setItemName(String name) {
        this.itemName = name;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemPrice(Double price) {
        this.itemPrice = price;
    }

    public Double getItemPrice() {
        return this.itemPrice;
    }
}
