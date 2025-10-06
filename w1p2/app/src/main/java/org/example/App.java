package org.example;

public class App {

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.viewMenuItem();
        menu.menuItemByName("Chicken Momo");
        menu.menuItemByName("Veg Momo");

        menu.menuByCategory(Category.VEG);
        menu.menuByCategory(Category.NON_VEG);
    }
}
