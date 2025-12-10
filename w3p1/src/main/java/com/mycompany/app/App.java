package com.mycompany.app;

import org.w3c.dom.ls.LSOutput;

import java.util.Iterator;
import java.util.Scanner;

public class App {
    public static Integer whatToDo() {

        Scanner scnr = new Scanner(System.in);

        System.out.println("\nYou can ⬇️");
        System.out.println("1. View Menu");
        System.out.println("2. Add Item");
        System.out.println("3. Remove Item");
        System.out.println("4. Update Price of an Item");
        System.out.println("5. Exit");
        System.out.print("What do you want to do (enter number as 1)?: ");

        return scnr.nextInt();
    }

    public static void main(String[] args) {
        
        Scanner scnr = new Scanner(System.in);
        ItemMenu menu = new ItemMenu();
        Integer userChoiceTodo = whatToDo();

        while (userChoiceTodo != 5) {

            switch (userChoiceTodo) {

                case 1:
                    menu.viewMenu();
                    userChoiceTodo = whatToDo();
                    break;

                case 2:
                    System.out.print("Enter name of Item to add: ");
                    String nameForItem = scnr.next();
                    System.out.print("Enter price of the Item(as 1.00): ");
                    Double priceForItem = scnr.nextDouble();
                    Item item = new Item(nameForItem, priceForItem);
                    menu.addItemToMenu(item);
                    userChoiceTodo = whatToDo();
                    break;

                case 3:
                    menu.viewMenu();
                    System.out.print("\nEnter the name of the item to remove: ");
                    String nameOfItem = scnr.next();
                    menu.removeItemFromMenu(nameOfItem);
                    userChoiceTodo = whatToDo();
                    break;

                case 4:
                    menu.viewMenu();
                    System.out.print("Which Item you want to update the price?: ");
                    String itemToModify = scnr.next();
                    System.out.print("Change price: ");
                    Double changedPrice = scnr.nextDouble();
                    menu.changePrice(itemToModify, changedPrice);
                    userChoiceTodo = whatToDo();
                    break;

                default:
                    System.out.println("\n --> Enter valid number<-- ");
                    userChoiceTodo = whatToDo();

            }

            if (userChoiceTodo.equals(5)) {

                System.out.println("\n-->Bye See You Again<--");

            }
        }
    }
}
