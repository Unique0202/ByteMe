package ByteMe;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<String, Integer> items = new HashMap<>();

    public void addItem(String itemId, int quantity) {
        items.put(itemId, quantity);
    }

    public void modifyItemQuantity(String itemId, int quantity) {
        if (items.containsKey(itemId)) {
            items.put(itemId, quantity);
        } else {
            System.out.println("Item not found in cart.");
        }
    }

    public void removeItem(String itemId) {
        items.remove(itemId);
    }

    public double getTotalPrice(Map<String, Admin.FoodItem> menu) {
        double total = 0.0;
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            Admin.FoodItem item = menu.get(entry.getKey());
            if (item != null) {
                total += item.getPrice() * entry.getValue();
            }
        }
        return total;
    }

    public void displayCart(Map<String, Admin.FoodItem> menu) {
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            Admin.FoodItem item = menu.get(entry.getKey());
            if (item != null) {
                System.out.println(item + ", Quantity: " + entry.getValue());
            }
        }
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public Map<String, Integer> getItems() {
        return items;
    }
}