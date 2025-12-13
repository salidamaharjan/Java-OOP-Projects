package com.mycompany.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ItemMenu {
    private List<Item> itemList;
    private static ItemMenu itemMenu = null;

    public ItemMenu() {
        this.itemList = new ArrayList<>();
    }

    public static ItemMenu getInstance() {

        if (itemMenu == null)
            itemMenu = new ItemMenu();

        return itemMenu;
    }

    public List<Item> getItemList() {
        return this.itemList;
    }

    public void viewMenu() {

        System.out.println("\nMenu Items⬇️");

        if (itemList.isEmpty()) {
            System.out.println("-->Nothing in the Menu<--");
        }

        for (int i = 0; i < itemList.size(); i++) {
            System.out.println((i + 1) + ". " + itemList.get(i).getItemName().toUpperCase() + " $" + itemList.get(i).getItemPrice());
        }
    }

    public void changePrice(String itemName, Double changedPrice) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getItemName().equalsIgnoreCase(itemName)) {
                itemList.get(i).setItemPrice(changedPrice);
                System.out.println("\n-->Price for " + itemName.toUpperCase() + " changed to $" + changedPrice + "<--");
            } else {
                System.out.println("\n-->Invalid Item, Enter the name of Item<--");
                return;
            }

        }
    }

    public void addItemToMenu(Item item) {

        itemList.add(item);
    }

    public void removeItemFromMenu(String itemName) {
        Iterator<Item> iteratorList = itemList.iterator();

        while (iteratorList.hasNext()) {
            Item nextItem = iteratorList.next();

            if (nextItem.getItemName().equalsIgnoreCase(itemName)) {
                iteratorList.remove();
                System.out.println("\n-->Item: " + nextItem.getItemName().toUpperCase() + " removed from menu<--");
            }
        }
    }
}
