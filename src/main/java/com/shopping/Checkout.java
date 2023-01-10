package com.shopping;

import java.util.List;
import java.util.Scanner;


public class Checkout {
    List<Item> items;
    double total;
    double amountInWallet;
    double amountToPay;
    Discount discount=new Discount();
    final int discountPercentage=5;
    int discountAmount=100;

    public Checkout(List<Item> items) {
        this.items = items;
    }

    public Checkout() {

    }


    public void calculateTotal(){
        for (Item i: items) {
            total=total+(i.getPrice()*i.getQuantity());
        }
    }
    
    public void checkout(){
        discount.offerAppliedOnItem(items, "milk");
        calculateTotal();
        amountToPay=discount.offerAppliedOnTotal(total, discountAmount, discountPercentage);
        Wallet wallet = new Wallet(500);
        amountInWallet=wallet.spendMoney(amountToPay);
        if(amountInWallet==-1){
            System.out.println("Insufficient balance");
            checkoutFailForInsufficientBalance();
        }
        else checkoutSuccessful();
    }
    
    public void checkoutSuccessful(){
        System.out.println("Checkout success, com.shopping.Wallet balance after checkout "+amountInWallet);
    }
    
    public void checkoutFailForInsufficientBalance(){
        System.out.println("Add Rs.500 to wallet?Y/N");
        Scanner scanner = new Scanner(System.in);
        String input=scanner.nextLine();
        Wallet wallet = new Wallet();
        if (input.equalsIgnoreCase("y")||input.equalsIgnoreCase("yes"))
            wallet.addMoney(500);
    }

    public void printItems(List<Item> items) {
        for(Item i: items){
            System.out.println("Item Name: "+i.getName());
            System.out.println("Item Quantity: "+i.getQuantity());
            System.out.println("Item Price: "+i.getPrice());

        }
    }
}

