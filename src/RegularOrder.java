import java.time.LocalDateTime;
import java.util.ArrayList;

public class RegularOrder extends Order{
    private Double totalPrice;

    public RegularOrder(int id, String name, String deliveryAddress, ArrayList<Item> itemList, Customer customer, PaymentType paymentType, LocalDateTime orderDate) {
        super(id, name, deliveryAddress, itemList, customer, paymentType, orderDate);
        this.totalPrice = this.calculateTotalPrice();
    }

    public Double getTotalPrice(){
        return  totalPrice;
    }

    public Double calculateTotalPrice(){
        Double totalPrice = 0D;
        for(Item item : this.getItemlist()){
            totalPrice += item.getPrice();
        }
        return  totalPrice;
    }


}
