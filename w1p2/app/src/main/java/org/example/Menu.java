package org.example;

import java.sql.SQLOutput;
import java.util.*;

public class Menu {
    private Map<String, MenuItem> menu;

    public Menu() {
        menu = new HashMap<>();
        MenuItem menuItem2 = new MenuItem("Veg Momo", "Nepalese Food", 11.99, Category.VEG);
        MenuItem menuItem3 = new MenuItem("Chowmein", "Nepalese Food", 12.99, Category.VEG);
        MenuItem menuItem1 = new MenuItem("Chicken Momo", "Nepalese Food", 13.99, Category.NON_VEG);

        addMenu(menuItem1);
        addMenu(menuItem2);
        addMenu(menuItem3);

    }

    public void addMenu(MenuItem menuItem) {
        menu.put(menuItem.getName(), menuItem);
    }

    public void viewMenuItem() {
        List<Map.Entry<String, MenuItem>> entryList = new ArrayList<>(menu.entrySet());
        if (menu.size() >= 1) {
            System.out.println("\n Menu Items: ⬇️");
        }

        for (int i = 0; i < menu.size(); i++) {
            Map.Entry<String, MenuItem> entry = entryList.get(i);
            System.out.println(i + 1 + ". " + entry.getValue());
        }
    }

    public void menuItemByName(String itemName) {
        if (menu.containsKey(itemName)) {
            System.out.println("\nItem By Name: " + itemName + " Found");
            System.out.println(menu.get(itemName));
        } else {
            System.out.println("\nItem By Name: " + itemName + " Not Found");
        }
    }

    public void menuByCategory(Category category) {
        List<Map.Entry<String, MenuItem>> entryList = new ArrayList<>(menu.entrySet());
        List<MenuItem> filteredItem = new ArrayList<>();

        for (int i = 0; i < entryList.size(); i++) {
            MenuItem item = entryList.get(i).getValue();
            if (item.getCategory().equals(category)) {
                filteredItem.add(item);
            }
        }

        if (filteredItem.isEmpty()) {
            System.out.println("\nNo items found for category: " + category);
        } else {
            System.out.println("\nMenu Items in Category: " + category);
            for (int i = 0; i < filteredItem.size(); i++) {
                System.out.println((i + 1) + ". " + filteredItem.get(i));
            }
        }
    }
}
