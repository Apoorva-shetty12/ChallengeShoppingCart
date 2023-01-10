package com.shopping;

import java.util.List;

public class Discount {

    public void offerAppliedOnItem(List<Item> items, String item){
        double count=0;
        int freeItem=0;
        for (Item i: items) {
            if (i.getName().equalsIgnoreCase(item)) {
                count += i.getQuantity();
            }
        }
        if (count>=2) {
            freeItem = (int) (count/2);
            Item item4 = new Item("milk", freeItem, 0);
            items.add(item4);
        }
        System.out.println("Buy two get one offer applied on Milk, added " +freeItem+" to cart");

    }

    public double offerAppliedOnTotal(double total, int discountAmount, int discount){
        if (total>=discountAmount){
            System.out.println("Additional com.shopping.Discount of 5% Applied");
            total -= (total*discount)/100;
        }
        System.out.println("Total Amount to be paid "+total);
        return total;
    }

}
