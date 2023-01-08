
import java.util.List;
import java.util.Scanner;

public class CheckoutCart {
    List<Item> items;
    double total;
    double amountInWallet;
    double amountToPay;
    Discount discount=new Discount();

    public CheckoutCart(List<Item> items) {
        this.items = items;
    }
    
    public void calculateTotal(){
        for (Item i: items) {
            total+=(i.getPrice()*i.getQuantity());
        }
    }
    
    public void checkout(){
        discount.offerAppliedOnMilk(items);
        calculateTotal();
        amountToPay=discount.offerAppliedOnTotal(total);
        Wallet wallet = new Wallet(500);
        amountInWallet=wallet.spendMoney(amountToPay);
        if(amountInWallet==-1){
            System.out.println("Insufficient balance");
            checkoutFailForInsufficientBalance();
        }
        else checkoutSuccessful();
    }
    
    public void checkoutSuccessful(){
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

