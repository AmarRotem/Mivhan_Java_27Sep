import java.time.LocalDateTime;
import java.util.ArrayList;

public class VipOrder extends Order {

    private Double totalPrice;

    public VipOrder(int id, String name, String deliveryAddress, ArrayList<Item> itemList, Customer customer, PaymentType paymentType, LocalDateTime orderDate) throws Exception {
        super(id, name, deliveryAddress, itemList, customer, paymentType, orderDate);
        if (customer.getCustomerType() != CustomerType.VIP) {
            throw new Exception("The order is a VIP order, but the customer is not a VIP customer.");
        }
        this.totalPrice = calculateTotalPrice();
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Double calculateTotalPrice() {
        Double totalPrice = 0D;
        for (Item item : getItemlist()) {
            totalPrice += item.getPrice();
        }
        totalPrice -= getCustomer().getCustomerDiscount();
        return totalPrice;
    }
}
