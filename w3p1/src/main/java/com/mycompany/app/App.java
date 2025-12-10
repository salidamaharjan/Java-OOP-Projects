package com.mycompany.app;

public class App {
    public static void main(String[] args) {
        ItemMenu menu = new ItemMenu();
        Item item1 = new Item("MoMo", 15.00);
        Item item2 = new Item("Chowmein", 12.00);
        menu.addItemToMenu(item1);
        menu.addItemToMenu(item2);
        menu.removeItemFromMenu("Momo");
     }
}
