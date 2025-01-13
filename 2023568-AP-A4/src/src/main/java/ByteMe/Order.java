package ByteMe;

public class Order {
    private String customerId;
    private String item;
    private double price;
    private String status;
    private boolean isVip;
    private String specialRequest;
    private int quantity;

    public Order(String customerId, String item, double price, int quantity, boolean isVip, String specialRequest, String status) {
        this.item = item;
        this.customerId = customerId;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.isVip = isVip;
        this.specialRequest = specialRequest;
    }



    public String getCustomerId() { return customerId; }
    public String getItem() { return item; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public boolean isVip() { return isVip; }
    public String getSpecialRequest() { return specialRequest; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Customer ID: " + customerId + ", Item: " + item + ", Price: " + price +
                ", Quantity: " + quantity + ", VIP: " + isVip + ", Special Request: " + specialRequest + ", Status: " + status;
    }
}