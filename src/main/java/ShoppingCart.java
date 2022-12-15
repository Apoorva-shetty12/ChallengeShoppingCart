import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {
    public static void main(String args[]){
        List<Item> items = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Wallet wallet = new Wallet();
        wallet.addMoney(500);
        System.out.println("Welcome to Shopping\n");
        int input;
        do
        {
            System.out.println("Available Items in shop\n 1. Apple\n 2. Milk\n 3. Newspaper \n " +
                    "4. Exit and Calculate total \n enter your option");
            input = scanner.nextInt();
            switch (input){
                case 1: Item item1 = new Item("Apple",2,100);
                        items.add(item1);
                        break;
                case 2: Item item2 = new Item("Milk",2,50);
                        items.add(item2);
                        break;
                case 3: Item item3 = new Item("Newspaper",2,10);
                        items.add(item3);
                        break;
                case 4: System.out.println("Exit to checkout");
                        break;
                default:
                    System.out.println("Enter valid input");

            }

        }while(input!= 4);

        CheckoutCart checkoutCart = new CheckoutCart(items);
        checkoutCart.offerAppliedOnMilk();
        checkoutCart.calculateTotal();
        double amountToPay= checkoutCart.offerAppliedOnTotal();

        double amountInWallet=wallet.spendMoney(amountToPay);
        if(amountInWallet==-1){
            System.out.println("Insufficient balance");
        }
        else System.out.println("Wallet balance after checkout"+amountInWallet);

    }
}
