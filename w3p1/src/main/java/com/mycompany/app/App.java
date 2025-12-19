package com.mycompany.app;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
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

    public static class CustomFileNotFoundException extends Exception {
        public CustomFileNotFoundException(String errorMessage) {
            super(errorMessage);
        }
    }

    public static void loadMenuFile() {
        ItemMenu itemMenu = ItemMenu.getInstance();

        try {
            List<String> lines = Files.readAllLines(Path.of("menu.csv"));
            for (String line : lines) {
                String[] parts = line.split(",");
                Item item = new Item(parts[1], Double.parseDouble(parts[2]));
                itemMenu.addItemToMenu(
                        item
                );
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void saveToMenuFile() {
        ItemMenu itemMenu = ItemMenu.getInstance();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("menu.csv", false))) {
            for (int i = 0; i < itemMenu.getItemList().size(); i++) {
                Item item = itemMenu.getItemList().get(i);
                writer.write((i + 1) + "," + item.getItemName() + "," + item.getItemPrice());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("-->Could not save to the file<--");
        }
    }

    public static void readItemsFromMenuFile() throws CustomFileNotFoundException {
        try {
            List<String> lines = Files.readAllLines(Path.of("menu.csv"));
            System.out.println("\n---Menu from CSV ---");
            if (lines.isEmpty()) {
                System.out.println("-->Nothing in the Menu<--");
            }
            for (String line : lines) {
                String[] valueReadFromFile = line.split(",");
                System.out.println(valueReadFromFile[0] + ". " + "Item Name: " + valueReadFromFile[1] + ", Item Price: " + valueReadFromFile[2]);
            }
        } catch (java.nio.file.NoSuchFileException e) {
            throw new CustomFileNotFoundException("File not found. Check file.");
        } catch (IOException e) {
            System.out.println("Could not read task file.");
        }
    }

    public static void main(String[] args) throws CustomFileNotFoundException {

        Scanner scnr = new Scanner(System.in);
        ItemMenu menu = ItemMenu.getInstance();

        loadMenuFile();

        Integer userChoiceTodo = whatToDo();

        while (userChoiceTodo != 5) {

            switch (userChoiceTodo) {

                case 1:
                    readItemsFromMenuFile();
                    userChoiceTodo = whatToDo();
                    break;

                case 2:
                    System.out.print("Enter name of Item to add: ");
                    String nameForItem = scnr.next();
                    System.out.print("Enter price of the Item(as 1.00): ");
                    Double priceForItem = scnr.nextDouble();
                    Item item = new Item(nameForItem, priceForItem);
                    menu.addItemToMenu(item);
                    System.out.println("\n-->Item: " + item.getItemName().toUpperCase() + " added to menu<--");
                    saveToMenuFile();
                    userChoiceTodo = whatToDo();
                    break;

                case 3:
                    readItemsFromMenuFile();
                    System.out.print("\nEnter the name of the item to remove: ");
                    String nameOfItem = scnr.next();
                    menu.removeItemFromMenu(nameOfItem);
                    System.out.println("\n-->Item: " + nameOfItem.toUpperCase() + " removed from menu<--");
                    saveToMenuFile();
                    userChoiceTodo = whatToDo();
                    break;

                case 4:
                    readItemsFromMenuFile();
                    System.out.print("\nWhich Item you want to update the price?: ");
                    String itemToModify = scnr.next();
                    System.out.print("Change price: ");
                    Double changedPrice = scnr.nextDouble();
                    menu.changePrice(itemToModify, changedPrice);
                    System.out.println("\n-->Price for " + itemToModify.toUpperCase() + " changed to $" + changedPrice + "<--");
                    saveToMenuFile();
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
