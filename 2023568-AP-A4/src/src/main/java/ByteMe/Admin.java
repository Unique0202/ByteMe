package ByteMe;

import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Admin {
    public static Map<String, FoodItem> menu = new HashMap<>();
    public static Map<String, Order> orders = new LinkedHashMap<>();
    private static MenuPage menuPage;
    private static OrdersPage ordersPage;

    public static void setMenuPage(MenuPage menuPage) {
        Admin.menuPage = menuPage;
    }

    public static void setOrdersPage(OrdersPage ordersPage) {
        Admin.ordersPage = ordersPage;
    }

    public static void addFoodItem(FoodItem item) {
        menu.put(item.getId(), item);
        if (menuPage != null) {
            menuPage.refreshMenuData();
        }
    }

    public static void updateFoodItem(FoodItem item) {
        menu.put(item.getId(), item);
        if (menuPage != null) {
            menuPage.refreshMenuData();
        }
    }

    public static void removeFoodItem(String id) {
        menu.remove(id);
        if (menuPage != null) {
            menuPage.refreshMenuData();
        }
    }

    public static class FoodItem {
        private String id;
        private String name;
        private double price;
        private String category;
        private String quantity;
        private boolean isAvailable;
        private List<Review> reviews;

        public FoodItem(String id, String name, double price, String category, String quantity, boolean isAvailable) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.category = category;
            this.quantity = quantity;
            this.isAvailable = isAvailable;
            this.reviews = new ArrayList<>();
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public String getCategory() {
            return category;
        }

        public String getQuantity() {
            return quantity;
        }

        public boolean isAvailable() {
            return isAvailable;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public void setAvailable(boolean isAvailable) {
            this.isAvailable = isAvailable;
        }

        public void addReview(Review review) {
            reviews.add(review);
        }

        public List<Review> getReviews() {
            return reviews;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Price: " + price +
                    ", Category: " + category + ", Available: " + isAvailable;
        }
    }

    public static void Methods() {

                System.out.println("\nSelect a method:");
                System.out.println("/////////////////////////");
                System.out.println("1. Menu Management");
                System.out.println("2. Order Management");
                System.out.println("3. Report Generation");
                System.out.println("4. View order history");
                System.out.println("5. Logout");
                System.out.println("////////////////////////");

        System.out.println("Enter choice: ");
        Scanner Choice = new Scanner(System.in);
        int choice = Choice.nextInt();
        if (choice == 1) {

                    System.out.println("Select how do you want to manage menu:");
                    System.out.println("Select a method:");
                    System.out.println("/////////////////////////");
                    System.out.println("1. Add new item");
                    System.out.println("2. Update an existing item");
                    System.out.println("3. Remove an item");
                    System.out.println("4. Display menu");
                    System.out.println("////////////////////////");

            System.out.println("Enter choice: ");
            Scanner Choice1 = new Scanner(System.in);
            choice = Choice1.nextInt();
            if (choice == 1) {
                addFoodItem();
            } else if (choice == 2) {
                updateFoodItem();
            } else if (choice == 3) {
                removeFoodItem();
            } else if (choice == 4) {
                displayMenu();
            } else {
                System.out.println("Invalid choice. Please try again.");
                Methods();
            }
        } else if (choice == 2) {

                    System.out.println("\nSelect how do you want to manage orders:");
                    System.out.println("Select a method:");
                    System.out.println("/////////////////////////");
                    System.out.println("1. View pending orders");
                    System.out.println("2. Update order status");
                    System.out.println("3. Process refunds");
                    System.out.println("4. Handle special requests");
                    System.out.println("5. Order priority");
                    System.out.println("////////////////////////");

            System.out.println("Enter choice: ");
            Scanner Choice2 = new Scanner(System.in);
            choice = Choice2.nextInt();
            if (choice == 1) {
                viewPendingOrders();
            } else if (choice == 2) {
                updateOrderStatus();
            } else if (choice == 3) {
                processRefunds();
            } else if (choice == 4) {
                handleSpecialRequests();
            } else if (choice == 5) {
                orderPriority();
            } else {
                System.out.println("Invalid choice. Please try again.");
                Methods();
            }

        } else if (choice == 3) {
            generateDailySalesReport();
        } else if (choice == 4) {
            System.out.println("Order history:");
            loadOrderHistory();
            Methods();
        }
        else if (choice == 5) {
            System.out.println("Logged out successfully.");
            ByteMe.main(null);
        } else {
            System.out.println("Invalid choice. Please try again.");
            Methods();
        }
    }

    // Add a new food item
    public static void addFoodItem() {
        System.out.print("Enter item ID: ");
        Scanner ID = new Scanner(System.in);
        String id = ID.nextLine();

        System.out.print("Enter item name: ");
        Scanner Name = new Scanner(System.in);
        String name = Name.nextLine();

        System.out.print("Enter price: ");
        Scanner Price = new Scanner(System.in);
        double price = Price.nextDouble();

        System.out.print("Enter category: ");
        Scanner Category = new Scanner(System.in);
        String category = Category.nextLine();

        System.out.print("Enter quantity: ");
        Scanner Quantity = new Scanner(System.in);
        String quantity = Quantity.nextLine();

        System.out.print("Is available (true/false): ");
        Scanner IsAvailable = new Scanner(System.in);
        boolean isAvailable = IsAvailable.nextBoolean();

        FoodItem newItem = new FoodItem(id, name, price, category, quantity, isAvailable);
        addFoodItem(newItem);
        System.out.println("Item added: " + newItem);

        System.out.println("Do you wish to add more items in the menu (yes/no): ");
        Scanner MoreItems = new Scanner(System.in);
        String moreItems = MoreItems.nextLine();
        if (moreItems.equals("yes")) {
            addFoodItem();
        } else {
            Methods();
        }
    }

    // Update an existing food item
    public static void updateFoodItem() {
        System.out.print("Enter item ID to update: ");
        Scanner ID = new Scanner(System.in);
        String id = ID.nextLine();

        System.out.print("Enter new price: ");
        Scanner Price = new Scanner(System.in);
        double price = Price.nextDouble();

        System.out.print("Enter new category: ");
        Scanner Category = new Scanner(System.in);
        String category = Category.nextLine();

        System.out.print("Enter new quantity: ");
        Scanner Quantity = new Scanner(System.in);
        String quantity = Quantity.nextLine();

        System.out.print("Is available (true/false): ");
        Scanner IsAvailable = new Scanner(System.in);
        boolean isAvailable = IsAvailable.nextBoolean();

        FoodItem item = menu.get(id);
        if (item != null) {
            item.setPrice(price);
            item.setCategory(category);
            item.setAvailable(isAvailable);
            updateFoodItem(item);
            System.out.println("Item updated: " + item);
        } else {
            System.out.println("Food item with ID " + id + " not found.");
        }

        System.out.println("Do you wish to update more items in the menu (yes/no): ");
        Scanner MoreItems = new Scanner(System.in);
        String moreItems = MoreItems.nextLine();
        if (moreItems.equals("yes")) {
            updateFoodItem();
        } else {
            Methods();
        }
    }

    // Remove a food item
    public static void removeFoodItem() {
        System.out.print("Enter item ID to remove: ");
        Scanner ID = new Scanner(System.in);
        String id = ID.nextLine();

        FoodItem item = menu.remove(id);
        if (item != null) {
            removeFoodItem(id);
            System.out.println("Item removed: " + item);
        } else {
            System.out.println("Food item with ID " + id + " not found.");
        }
        System.out.println("Do you wish to remove more items in the menu (yes/no): ");
        Scanner MoreItems = new Scanner(System.in);
        String moreItems = MoreItems.nextLine();
        if (moreItems.equals("yes")) {
            removeFoodItem();
        } else {
            Methods();
        }
    }

    // Display all items in the menu
    public static void displayMenu() {
        if (menu.isEmpty()) {
            System.out.println("The menu is empty.");
        } else {
            for (FoodItem item : menu.values()) {
                System.out.println(item);
            }
        }
        System.out.println("Do you wish to display the menu again (yes/no): ");
        Scanner ViewMenu = new Scanner(System.in);
        String viewMenu = ViewMenu.nextLine();
        if (viewMenu.equals("yes")) {
            displayMenu();
        } else {
            Methods();
        }
    }

    public static Map<String, FoodItem> getMenu() {
        return menu;
    }

    // View pending orders
    public static void viewPendingOrders() {
        orders.values().stream()
                .filter(order -> !order.getStatus().equals("Completed"))
                .sorted(Comparator.comparing(Order::isVip).reversed())
                .forEach(System.out::println);

        if (ordersPage != null) {
            ordersPage.refreshOrdersData();
        }

        Methods();
    }

    // Update order status
    public static void updateOrderStatus() {
        System.out.print("Enter order ID to update (Customer ID-Item): ");
        Scanner scanner = new Scanner(System.in);
        String orderId = scanner.nextLine();

        Order order = orders.get(orderId);
        if (order != null) {
            System.out.print("Enter new status (e.g., Preparing, Out for Delivery, Completed): ");
            String status = scanner.nextLine();
            order.setStatus(status);
            System.out.println("Order updated: " + order);
        } else {
            System.out.println("Order not found.");
        }

        if (ordersPage != null) {
            ordersPage.refreshOrdersData();
        }

        Methods();
    }

    // Process refunds
    public static void processRefunds() {
        System.out.print("Enter order ID to refund (Customer ID-Item): ");
        Scanner scanner = new Scanner(System.in);
        String orderId = scanner.nextLine();

        Order order = orders.remove(orderId);
        if (order != null) {
            System.out.println("Refund processed for order: " + order);
        } else {
            System.out.println("Order not found.");
        }

        if (ordersPage != null) {
            ordersPage.refreshOrdersData();
        }

        Methods();
    }

    // Handle special requests
    public static void handleSpecialRequests() {
        System.out.print("Enter order ID to view special request (Customer ID-Item): ");
        Scanner scanner = new Scanner(System.in);
        String orderId = scanner.nextLine();

        Order order = orders.get(orderId);
        if (order != null) {
            System.out.println("Special request for order " + orderId + ": " + order.getSpecialRequest());
        } else {
            System.out.println("Order not found.");
        }

        Methods();
    }

    // Order priority
    public static void orderPriority() {
        System.out.println("Orders are prioritized based on VIP status.");
        viewPendingOrders();
    }

    // Add a method to create orders for testing
    public static void createOrder(String customerId, String itemId, double price, int quantity, boolean isVip, String specialRequest, String status) {
        FoodItem item = menu.get(itemId);
        if (item == null || !item.isAvailable()) {
            System.out.println("Item is out of stock.");
            return;
        }
        Order order = new Order(customerId, itemId, price, quantity, isVip, specialRequest, status);
        orders.put(customerId + "-" + itemId, order);

        // Save only the new order to the order history file
        saveOrderHistory(order);

        if (ordersPage != null) {
            ordersPage.refreshOrdersData();
        }
    }

    public static void generateDailySalesReport() {
        double totalSales = 0;
        Map<String, Integer> itemCount = new HashMap<>();
        int totalOrders = orders.size();

        for (Order order : orders.values()) {
            totalSales += order.getPrice();
            itemCount.put(order.getItem(), itemCount.getOrDefault(order.getItem(), 0) + order.getQuantity());
        }

        String mostPopularItem = itemCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No items sold");

        System.out.println("Daily Sales Report:");
        System.out.println("Total Sales: $" + totalSales);
        System.out.println("Total Orders: " + totalOrders);
        System.out.println("Most Popular Item: " + mostPopularItem);

        System.out.println("Do you wish to generate the daily sales report again (yes/no): ");
        Scanner GenerateReport = new Scanner(System.in);
        String generateReport = GenerateReport.nextLine();
        if (generateReport.equals("yes")) {
            generateDailySalesReport();
        } else {
            Methods();
        }
    }
    public static void saveOrderHistory(Order order) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("order_history.txt", true))) {
            writer.write("Customer ID: " + order.getCustomerId() +
                    ", Item: " + order.getItem() +
                    ", Quantity: " + order.getQuantity() +
                    ", Price: " + order.getPrice() + "\n");
            System.out.println("Order history saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadOrderHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader("order_history.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}