import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Order{

    private int id;
    private String name;
    private String deliveryAddress;
    private ArrayList<Item> itemList;
    private Customer customer;
    private PaymentType paymentType;
    private LocalDateTime orderDate;

    public Order(int id, String name, String deliveryAddress, ArrayList<Item> itemList, Customer customer, PaymentType paymentType, LocalDateTime orderDate) {
        this.id = id;
        this.name = name;
        this.deliveryAddress = deliveryAddress;
        this.itemList = itemList;
        this.customer = customer;
        this.paymentType = paymentType;
        this.orderDate = orderDate;
        listCustomerFavorite();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public ArrayList<Item> getItemlist() {
        return itemList;
    }

    public void setItemlist(ArrayList<Item> itemlist) {
        this.itemList = itemlist;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    private void listCustomerFavorite(){
        boolean addtion = true;
        for (Item orderItem : this.getItemlist()){
            for(Item customerFavoriteItem : this.getCustomer().getFavoriteItems()){
                if (customerFavoriteItem.getName() != orderItem.getName()){
                    continue;
                }else{
                    addtion = false;
                }
            }
            if (addtion){
                this.getCustomer().getFavoriteItems().add(orderItem);
            }
            addtion = true;
        }
    }


}
