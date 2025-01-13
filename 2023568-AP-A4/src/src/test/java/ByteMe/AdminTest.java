package ByteMe;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AdminTest {

    @BeforeEach
    public void setUp() {
        // Initialize the menu and orders before each test
        Admin.getMenu().clear();
        Admin.orders.clear();
        ByteMe.basicMenu(); // Assuming this method populates the menu with initial items
    }

    @Test
    public void testOrderOutOfStockItem() {
        // Simulate an out-of-stock item by setting its availability to false
        Admin.FoodItem outOfStockItem = new Admin.FoodItem("123", "Out of Stock Item", 10.0, "Category", "Quantity", false);
        Admin.getMenu().put(outOfStockItem.getId(), outOfStockItem);

        // Attempt to place an order for the out-of-stock item
        String customerId = "testCustomer";
        String itemId = outOfStockItem.getId();
        double price = outOfStockItem.getPrice();
        int quantity = 1;
        boolean isVip = false;
        String specialRequest = "";
        String status = "Pending";

        // Capture the output to verify the error message
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Admin.createOrder(customerId, itemId, price, quantity, isVip, specialRequest, status);

        // Verify that the appropriate error message is displayed
        String expectedMessage = "Item is out of stock.";
        assertTrue(outContent.toString().contains(expectedMessage));

        // Verify that the order is not processed
        String orderId = customerId + "-" + itemId;
        assertNull(Admin.orders.get(orderId));

        // Print test passed message
        System.out.println("Test is passed");
    }
    @Test
    public void testInvalidLoginAttempts() {
        // Capture the output to verify the error message
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Simulate invalid login attempts
        String incorrectUsername = "wrongUser";
        int incorrectPassword = 1234;

        // Attempt to log in with incorrect username
        ByteMe.check("Admin", 999999, incorrectPassword);
        String expectedMessage1 = "Invalid User ID or Password";
        assertTrue(outContent.toString().contains(expectedMessage1));

        // Clear the output stream
        outContent.reset();

        // Attempt to log in with incorrect password
        ByteMe.check("Admin", 2023568, 9999);
        String expectedMessage2 = "Invalid User ID or Password";
        assertTrue(outContent.toString().contains(expectedMessage2));

        // Verify that access is not granted
        // Assuming there is a method to check if an admin is logged in
        // assertFalse(ByteMe.isAdminLoggedIn());
    }

}


