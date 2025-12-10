package com.mycompany.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ItemMenu {
    private List<Item> itemList;

    public ItemMenu() {
        this.itemList = new ArrayList<>();
    }

    public void addItemToMenu(Item item) {
        itemList.add(item);
        System.out.println("Item " + item.getItemName() + " added to menu.");
    }

    public void removeItemFromMenu(String itemName) {
        Iterator<Item> iteratorList = itemList.iterator();

        while(iteratorList.hasNext()){
           Item nextItem = iteratorList.next();
           if(nextItem.getItemName().equalsIgnoreCase(itemName)){
               iteratorList.remove();
               System.out.println("Item: " + nextItem.getItemName() + " removed from menu.");
           }
        }
    }
}
