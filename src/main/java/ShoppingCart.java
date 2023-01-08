import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {
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
            switch (input.toUpperCase()) { // better implementation lookup 
                case "APPLE" -> {
                    System.out.println("Enter quantity of Apple, eg:1");
                    double quantity1 = scanner.nextDouble();
                    Item apple = new Item("APPLE", quantity1, 100);
                    items.add(apple);
                }
                case "MILK" -> {
                    System.out.println("Enter quantity of Milk\n Milk has buy2get1 offer, eg:1");
                    double quantity2 = scanner.nextDouble();
                    Item milk = new Item("MILK", quantity2, 50);
                    items.add(milk);
                }
                case "NEWSPAPER" -> {
                    System.out.println("Enter quantity of Newspaper, eg:1");
                    double quantity3 = scanner.nextDouble();
                    Item newspaper = new Item("NEWSPAPER", quantity3, 10);
                    items.add(newspaper);
                }
                case "EXIT" -> System.out.println("Exit to checkout");
                default -> System.out.println("Enter valid input");
            }

        }while(!input.equalsIgnoreCase("EXIT"));

        CheckoutCart checkoutCart = new CheckoutCart(items);
        checkoutCart.checkout();

    }
}
