package ByteMe;

import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Customer {
    private static Cart cart = new Cart();

    public static void Methods(String usertype, int userid) {
        System.out.println("Select a method:");
        System.out.println("/////////////////////////");
        System.out.println("1. Browse menu");
        System.out.println("2. Cart Operations");
        System.out.println("3. Order Tracking");
        System.out.println("4. Reviews section");
        System.out.println("5. Logout");
        System.out.println("////////////////////////");

        System.out.println("Enter choice: ");
        Scanner Choice = new Scanner(System.in);
        int choice = Choice.nextInt();
        if (choice == 1) {

            System.out.println("How do you want to browse the menu?");
            System.out.println("Select a method:");
            System.out.println("/////////////////////////");
            System.out.println("1. View all items");
            System.out.println("2. Search functionality (search for specific items by name or id)");
            System.out.println("3. Filter by category (Snack, Fast Food, Beverage, Fruit, Meal)");
            System.out.println("4. Sort by price");
            System.out.println("////////////////////////");

            System.out.println("Enter choice: ");
            Scanner BrowseMenu = new Scanner(System.in);
            int browseMenu = BrowseMenu.nextInt();
            if (browseMenu == 1) {
                viewAllItems(usertype, userid);
            } else if (browseMenu == 2) {
                searchItems(usertype, userid);
            } else if (browseMenu == 3) {
                filterByCategory(usertype, userid);
            } else if (browseMenu == 4) {
                sortByPrice(usertype, userid);
            } else {
                System.out.println("Invalid choice. Please try again.");
                Customer.Methods(usertype, userid);
            }
        } else if (choice == 2) {
            System.out.println("\nChoose a cart operation you want to perform:");
            System.out.println("Select a method:");
            System.out.println("/////////////////////////");
            System.out.println("1. Add items to cart");
            System.out.println("2. Modify quantities of items in cart");
            System.out.println("3. Remove items from cart");
            System.out.println("4. View total price");
            System.out.println("5. View cart");
            System.out.println("6. Checkout process");
            System.out.println("////////////////////////");

            System.out.println("Enter choice: ");
            Scanner CartOperation = new Scanner(System.in);
            int cartOperation = CartOperation.nextInt();
            if (cartOperation == 1) {
                addItemToCart(usertype, userid);
            } else if (cartOperation == 2) {
                modifyItemQuantity(usertype, userid);
            } else if (cartOperation == 3) {
                removeItemFromCart(usertype, userid);
            } else if (cartOperation == 4) {
                viewTotalPrice(usertype, userid);
            }else if (cartOperation == 5) {
                viewCart(usertype, userid);
            } else if (cartOperation == 6) {
                checkout(usertype, userid);
            } else {
                System.out.println("Invalid choice. Please try again.");
                Customer.Methods(usertype, userid);
            }
        } else if (choice == 3) {

            System.out.println("\nChoose a cart operation you want to perform:");
            System.out.println("Select a method:");
            System.out.println("/////////////////////////");
            System.out.println("1. View order status");
            System.out.println("////////////////////////");

            System.out.println("Enter choice: ");
            Scanner OrderTracking = new Scanner(System.in);
            int orderTracking = OrderTracking.nextInt();
            if (orderTracking == 1) {
                viewOrderStatus(usertype, userid);
            } else {
                System.out.println("Invalid choice. Please try again.");
                Customer.Methods(usertype, userid);
            }
        } else if (choice == 4) {
        System.out.println("\nChoose a review operation:");
        System.out.println("/////////////////////////");
        System.out.println("1. Provide review");
        System.out.println("2. View reviews");
        System.out.println("////////////////////////");

            System.out.println("Enter choice: ");
            Scanner ReviewOperation = new Scanner(System.in);
            int reviewOperation = ReviewOperation.nextInt();
            if (reviewOperation == 1) {
                provideReview(usertype, userid);
            } else if (reviewOperation == 2) {
                viewReviews(usertype, userid);
            } else {
                System.out.println("Invalid choice. Please try again.");
                Methods(usertype, userid);
            }
        } else if (choice == 5) {
            System.out.println("Logged out successfully.");
            ByteMe.main(null);
        } else {
            System.out.println("Invalid choice. Please try again.");
            Admin.Methods();
        }
    }
    //View all items in the menu
    public static void viewAllItems(String usertype, int userid) {
        Map<String, Admin.FoodItem> menu = Admin.getMenu();
        if (menu.isEmpty()) {
            System.out.println("The menu is empty.");
        } else {
            for (Admin.FoodItem item : menu.values()) {
                System.out.println(item);
            }
        }
        System.out.println("Do you wish to view menu again (yes/no): ");
        Scanner ViewMenu = new Scanner(System.in);
        String viewMenu = ViewMenu.nextLine();
        if (viewMenu.equals("yes")) {
            viewAllItems(usertype, userid);
        } else {
            Customer.Methods(usertype, userid);
        }
    }
// search an item by name or id
    public static void searchItems(String usertype, int userid) {
        System.out.print("Enter item name or item id: ");
        Scanner Keyword = new Scanner(System.in);
        String keyword = Keyword.nextLine().toLowerCase();

        Map<String, Admin.FoodItem> menu = Admin.getMenu();
        boolean found = false;

        for (Admin.FoodItem item : menu.values()) {
            if (item.getName().toLowerCase().contains(keyword) || item.getId().toLowerCase().contains(keyword)) {
                System.out.println(item);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No items found matching the keyword: " + keyword);
        }

        System.out.println("Do you wish to search another item (yes/no): ");
        Scanner SearchAgain = new Scanner(System.in);
        String searchAgain = SearchAgain.nextLine();
        if (searchAgain.equals("yes")) {
            searchItems(usertype, userid);
        } else {
            Customer.Methods(usertype, userid);
        }
    }
    //Filter items by category
    // Add this method to Customer.java
    public static void filterByCategory(String usertype, int userid) {
        System.out.print("Enter category (Snack, Fast Food, Beverage, Fruit, Meal): ");
        Scanner Category = new Scanner(System.in);
        String category = Category.nextLine().toLowerCase();

        Map<String, Admin.FoodItem> menu = Admin.getMenu();
        boolean found = false;

        for (Admin.FoodItem item : menu.values()) {
            if (item.getCategory().toLowerCase().equals(category)) {
                System.out.println(item);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No items found in the category: " + category);
        }

        System.out.println("Do you wish to filter by another category (yes/no): ");
        Scanner FilterAgain = new Scanner(System.in);
        String filterAgain = FilterAgain.nextLine();
        if (filterAgain.equals("yes")) {
            filterByCategory(usertype, userid);
        } else {
            Customer.Methods(usertype, userid);
        }
    }
    //Sort items by price
    public static void sortByPrice(String usertype, int userid) {
        Map<String, Admin.FoodItem> menu = Admin.getMenu();
        List<Admin.FoodItem> itemList = new ArrayList<>(menu.values());

        itemList.sort(Comparator.comparingDouble(Admin.FoodItem::getPrice));

        for (Admin.FoodItem item : itemList) {
            System.out.println(item);
        }

        System.out.println("Do you wish to sort by price again (yes/no): ");
        Scanner SortAgain = new Scanner(System.in);
        String sortAgain = SortAgain.nextLine();
        if (sortAgain.equals("yes")) {
            sortByPrice(usertype, userid);
        } else {
            Customer.Methods(usertype, userid);
        }
    }
    private static void addItemToCart(String usertype, int userid) {
        System.out.print("Enter item ID: ");
        Scanner ID = new Scanner(System.in);
        String id = ID.nextLine();

        System.out.print("Enter quantity: ");
        Scanner Quantity = new Scanner(System.in);
        int quantity = Quantity.nextInt();

        cart.addItem(id, quantity);
        System.out.println("Item added to cart.");

        System.out.println("Do you wish to add more items to the cart (yes/no): ");
        Scanner MoreItems = new Scanner(System.in);
        String moreItems = MoreItems.nextLine();
        if (moreItems.equals("yes")) {
            addItemToCart(usertype, userid);
        } else {
            Methods(usertype, userid);
        }
    }

    private static void modifyItemQuantity(String usertype, int userid) {
        System.out.print("Enter item ID: ");
        Scanner ID = new Scanner(System.in);
        String id = ID.nextLine();

        System.out.print("Enter new quantity: ");
        Scanner Quantity = new Scanner(System.in);
        int quantity = Quantity.nextInt();

        cart.modifyItemQuantity(id, quantity);
        System.out.println("Item quantity updated.");

        System.out.println("Do you wish to modify more items in the cart (yes/no): ");
        Scanner MoreItems = new Scanner(System.in);
        String moreItems = MoreItems.nextLine();
        if (moreItems.equals("yes")) {
            modifyItemQuantity(usertype, userid);
        } else {
            Methods(usertype, userid);
        }
    }

    private static void removeItemFromCart(String usertype, int userid) {
        System.out.print("Enter item ID: ");
        Scanner ID = new Scanner(System.in);
        String id = ID.nextLine();

        cart.removeItem(id);
        System.out.println("Item removed from cart.");

        System.out.println("Do you wish to remove more items from the cart (yes/no): ");
        Scanner MoreItems = new Scanner(System.in);
        String moreItems = MoreItems.nextLine();
        if (moreItems.equals("yes")) {
            removeItemFromCart(usertype, userid);
        } else {
            Methods(usertype, userid);
        }
    }

    private static void viewTotalPrice(String usertype, int userid) {
        Map<String, Admin.FoodItem> menu = Admin.getMenu();
        double total = cart.getTotalPrice(menu);
        System.out.println("Total price: " + total);

        System.out.println("Do you wish to view the total price again (yes/no): ");
        Scanner ViewAgain = new Scanner(System.in);
        String viewAgain = ViewAgain.nextLine();
        if (viewAgain.equals("yes")) {
            viewTotalPrice(usertype, userid);
        } else {
            Methods(usertype, userid);
        }
    }

    private static void viewCart(String usertype, int userid) {
        Map<String, Admin.FoodItem> menu = Admin.getMenu();
        cart.displayCart(menu);

        System.out.println("Do you wish to view the cart again (yes/no): ");
        Scanner ViewAgain = new Scanner(System.in);
        String viewAgain = ViewAgain.nextLine();
        if (viewAgain.equals("yes")) {
            viewCart(usertype, userid);
        } else {
            Methods(usertype, userid);
        }
    }

    private static void checkout(String usertype, int userid) {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            Methods(usertype, userid);
            return;
        }

        System.out.print("Enter payment details: ");
        Scanner PaymentDetails = new Scanner(System.in);
        String paymentDetails = PaymentDetails.nextLine();

        System.out.print("Enter delivery address: ");
        Scanner DeliveryAddress = new Scanner(System.in);
        String deliveryAddress = DeliveryAddress.nextLine();

        boolean isVip = usertype.equals("VIP");
        System.out.println("Please write special request if any: ");
        Scanner SpecialRequest = new Scanner(System.in);
        String specialRequest = SpecialRequest.nextLine();


        Map<String, Integer> items = cart.getItems();
        Map<String, Admin.FoodItem> menu = Admin.getMenu();

        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            String itemId = entry.getKey();
            int quantity = entry.getValue();
            Admin.FoodItem item = menu.get(itemId);
            if (item != null) {
                double price = item.getPrice() * quantity;
                String status = "Pending";
                Admin.createOrder(String.valueOf(userid), item.getName(), price, quantity, isVip, specialRequest, status);
            }
        }

        System.out.println("Order placed successfully.");
        cart = new Cart(); // Clear the cart after checkout

        Methods(usertype, userid);
    }

    // View order status
    public static void viewOrderStatus(String usertype, int userid) {
        System.out.print("Enter order ID (Customer ID-Item): ");
        Scanner scanner = new Scanner(System.in);
        String orderId = scanner.nextLine();

        Order order = Admin.orders.get(orderId);
        if (order != null) {
            System.out.println("Order status for " + orderId + ": " + order.getStatus());
        } else {
            System.out.println("Order not found.");
        }

        System.out.println("Do you wish to view another order status (yes/no): ");
        String viewAgain = scanner.nextLine();
        if (viewAgain.equals("yes")) {
            viewOrderStatus(usertype, userid);
        } else {
            Methods(usertype, userid);
        }
    }

    // Provide a review for a food item
    public static void provideReview(String usertype, int userid) {
        System.out.print("Enter item ID to review: ");
        Scanner scanner = new Scanner(System.in);
        String itemId = scanner.nextLine();

        Map<String, Admin.FoodItem> menu = Admin.getMenu();
        Admin.FoodItem item = menu.get(itemId);
        if (item != null) {
            System.out.print("Enter your review: ");
            String reviewText = scanner.nextLine();

            System.out.print("Enter your rating (1-5): ");
            int rating = scanner.nextInt();

            Review review = new Review(String.valueOf(userid), reviewText, rating);
            item.addReview(review);
            System.out.println("Review added successfully.");
        } else {
            System.out.println("Food item not found.");
        }

        Methods(usertype, userid);
    }

    // View reviews for a food item
    public static void viewReviews(String usertype, int userid) {
        System.out.print("Enter item ID to view reviews: ");
        Scanner scanner = new Scanner(System.in);
        String itemId = scanner.nextLine();

        Map<String, Admin.FoodItem> menu = Admin.getMenu();
        Admin.FoodItem item = menu.get(itemId);
        if (item != null) {
            List<Review> reviews = item.getReviews();
            if (reviews.isEmpty()) {
                System.out.println("No reviews for this item.");
            } else {
                for (Review review : reviews) {
                    System.out.println(review);
                }
            }
        } else {
            System.out.println("Food item not found.");
        }

        Methods(usertype, userid);
    }
}
