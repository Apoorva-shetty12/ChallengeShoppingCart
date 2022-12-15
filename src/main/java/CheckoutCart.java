
import java.util.List;

public class CheckoutCart {
    List<Item> items;
    double total;

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

    
}

