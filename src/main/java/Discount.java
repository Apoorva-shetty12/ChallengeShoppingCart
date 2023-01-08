import java.util.List;

public class Discount {

    public void offerAppliedOnMilk(List<Item> items){
        double count=0;
        int noOfMilk=0;
        for (Item i: items) {
            if (i.getName().equalsIgnoreCase("milk")) {
                count += i.getQuantity();
            }
        }
        if (count>=2) {
            noOfMilk = (int) (count/2);
            Item item4 = new Item("milk", noOfMilk, 0);
            items.add(item4);
        }
        System.out.println("Buy two get one offer applied on Milk, added " +noOfMilk+" to cart");

    }

    public double offerAppliedOnTotal(double total){
        if (total>=100){
            System.out.println("Additional Discount of 5% Applied");
            total -= (total*5)/100;
        }
        System.out.println("Total Amount to be paid "+total);
        return total;
    }

}
