# ByteMe

## Overview
ByteMe is a Java-based application designed to manage a food ordering system. It includes functionalities for both administrators and customers, allowing them to manage food items, place orders, and handle various administrative tasks.

## Features
- Admin and Customer login
- Manage food items (add, update, remove)
- Place and view orders
- Process refunds
- Handle special requests
- Generate daily sales reports

## Usage
1. **Admin Login**: Admins can log in using their Admin ID and password to manage the menu and orders.
2. **Customer Login**: Customers can log in using their Customer ID and password to place orders and view their order history.
3. **Menu Management**: Admins can add, update, and remove food items from the menu.
4. **Order Management**: Admins can view pending orders, update order statuses, and process refunds.
5. **Special Requests**: Admins can handle special requests from customers.
6. **Sales Reports**: Admins can generate daily sales reports to track total sales and popular items.

## OOP and Java Concepts Used
- **Classes and Objects**: The application is structured using classes such as `Admin`, `Customer`, `Order`, and `FoodItem`.
- **Inheritance**: The `Admin` and `Customer` classes inherit common properties and methods from a base class (if applicable).
- **Polymorphism**: Methods are overridden to provide specific implementations for different user types.
- **Encapsulation**: Data members are kept private and accessed through public getter and setter methods.
- **Collections**: Java collections like `HashMap` and `ArrayList` are used to manage food items and orders.
- **Streams and Lambdas**: Used for processing collections, such as filtering and sorting orders.
- **File I/O**: Reading from and writing to files for order history and sales reports.
- **Exception Handling**: Handling exceptions to ensure the application runs smoothly.

## Testing
The application includes junit tests to verify the functionality of various components. Tests are written using JUnit and cover scenarios such as:
- Ordering out of stock items
- Invalid login attempts

### Example Test
```java
@Test
public void testInvalidLoginAttempts() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    ByteMe.check("Admin", 999999, 1234);
    assertTrue(outContent.toString().contains("Invalid User ID or Password"));

    outContent.reset();

    ByteMe.check("Admin", 2023568, 9999);
    assertTrue(outContent.toString().contains("Invalid User ID or Password"));
}
```

## How to Run
1. **Run the Application**: Execute the main class `ByteMe` using your IDE or by running `java -cp target/ByteMe-1.0-SNAPSHOT.jar ByteMe.ByteMe` in the terminal.
2. **Run Tests**: Run the tests using Maven by executing `mvn test`.

## Dependencies
- Java 11 or higher
- Maven 3.6.0 or higher
- JUnit 5

## Conclusion
ByteMe is a comprehensive application for managing a food ordering system, demonstrating various OOP and Java concepts. It includes robust testing to ensure functionality and reliability. Follow the instructions above to set up and run the application.