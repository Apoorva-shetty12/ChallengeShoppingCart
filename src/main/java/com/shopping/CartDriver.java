package com.shopping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CartDriver {
    public static void main(String[] args){
        List<Item> items = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        //wallet.addMoney(500);

        //1. separate checkout cart, 2. lombok lib
        System.out.println("Welcome to Shopping\n");
        String input;
        do{
            System.out.println("""
                    Available Items in shop
                     1. Apple
                     2. Milk
                     3. Newspaper\s
                     4. Type "exit" to exit and calculate total\s
                     enter your option""");
            input = scanner.nextLine();
            switch (input.toUpperCase()) {
                case "APPLE" -> {
                    System.out.println("Enter quantity of Apple, eg:1");
                    double quantity1 = scanner.nextDouble();
                    Item apple = new Item("APPLE", quantity1, 100);
                    items.add(apple);
                }
                case "MILK" -> {
                    System.out.println("Enter quantity of Milk\n Milk has buy2get1 offer, eg:1");
                    double quantity2 = scanner.nextDouble();
                    Item milk = new Item("MILK", quantity2, 50.00);
                    items.add(milk);
                }
                case "NEWSPAPER" -> {
                    System.out.println("Enter quantity of Newspaper, eg:1");
                    double quantity3 = scanner.nextDouble();
                    Item newspaper = new Item("NEWSPAPER", quantity3, 10.00);
                    items.add(newspaper);
                }
                case "UPDATE" -> {
                    System.out.println("Enter item to be updated");
                    String name= scanner.nextLine();
                    System.out.println("Enter Quantity");
                    int quantity= scanner.nextInt();
                    UpdateCart(items, name, quantity);
                }

                case "EXIT" -> {
                    System.out.println("Exit to checkout");
                    System.out.println("Summary of items");
                    new Checkout().printItems(items);
                }
                default -> System.out.println("Enter valid input");
            }

        }while(!input.equalsIgnoreCase("EXIT"));

        Checkout checkout = new Checkout(items);
        checkout.checkout();

    }

     static void UpdateCart(List<Item> items, String name, int quantity) {
        for (Item i: items)
        {
            if (i.getName().equals(name)) {

                i.setQuantity(quantity);
            }else System.out.println("Added Item first to update");
        }
    }
}
