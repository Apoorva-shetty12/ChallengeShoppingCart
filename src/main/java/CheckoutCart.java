
import java.util.List;
import java.util.Scanner;

public class CheckoutCart {
    List<Item> items;
    double total;
    double amountInWallet;
    double amountToPay;

    public CheckoutCart(List<Item> items) {
        this.items = items;
    }
    
    public void offerAppliedOnMilk(){
        for (Item i: items) {
            if (i.name.equalsIgnoreCase("milk") && i.quantity == 2) {
                System.out.println("Buy two get one offer applied on Milk");
                Item item4= new Item("milk",1,0);
                items.add(item4);
                break;
            }
        }

    }
    public void calculateTotal(){
        for (Item i: items) {
            total+=(i.getPrice()*i.getQuantity());
        }
    }
    public double offerAppliedOnTotal(){
        if (total>=100){
            System.out.println("Additional Discount of 5% Applied");
            total -= (total*5)/100;
        }
        System.out.println("Total Amount to be paid "+total);
        return total;


    }
    
    public void checkout(){
        offerAppliedOnMilk();
        calculateTotal();
        amountToPay=offerAppliedOnTotal();
        Wallet wallet = new Wallet(500);
        amountInWallet=wallet.spendMoney(amountToPay);
        if(amountInWallet==-1){
            System.out.println("Insufficient balance");
            checkoutFailForInsufficientBalance();
        }
        else checkoutSuccessful();
    }
    
    public void checkoutSuccessful(){
        Wallet wallet = new Wallet();
        double amountInWallet=wallet.spendMoney(amountToPay);
        System.out.println("Checkout success, Wallet balance after checkout "+amountInWallet);
    }
    
    public void checkoutFailForInsufficientBalance(){
        System.out.println("Add Rs.500 to wallet?Y/N");
        Scanner scanner = new Scanner(System.in);
        String input=scanner.nextLine();
        Wallet wallet = new Wallet();
        if (input.equalsIgnoreCase("y")||input.equalsIgnoreCase("yes"))
            wallet.addMoney(500);
    }

    
}

