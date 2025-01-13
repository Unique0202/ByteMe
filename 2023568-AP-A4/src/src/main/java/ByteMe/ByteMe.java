package ByteMe;
import java.util.Scanner;

public class ByteMe{
    static int userid;
    static int password;
    public static void main(String[] args){
        System.out.println("Welcome to ByteMe!!!\nPlease enter your credentials to login _||_");
        basicMenu();
        runGUI();
        //Defining category of users
        Scanner userType=new Scanner(System.in);
        System.out.println("Select your category (Admin, Customer): ");
        String usertype=userType.nextLine();

        //taking input of User Id and password of user
        if (usertype.equals("Admin")){
            Scanner userID=new Scanner(System.in);
            System.out.println("Enter your Admin ID: ");
            userid=userID.nextInt();

            Scanner Password=new Scanner(System.in);
            System.out.println("Enter your Password: ");
            password=Password.nextInt();

            check(usertype, userid, password);

        } else if (usertype.equals("Customer")){
            Scanner userID=new Scanner(System.in);
            System.out.println("Enter your Customer ID: ");
            userid=userID.nextInt();

            Scanner Password=new Scanner(System.in);
            System.out.println("Enter your Password: ");
            password=Password.nextInt();

            check(usertype, userid, password);
        }
        else{
            System.out.println("Please enter a valid category");
            main(null);
        }

    }
    public static void runGUI() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI gui = new GUI();
                gui.setVisible(true);
            }
        });
    }
    public static void basicMenu(){
        Admin.FoodItem item1 = new Admin.FoodItem("1", "Banana", 60, "Fruit","12" ,true);
        Admin.menu.put("1", item1);
        Admin.FoodItem item2 = new Admin.FoodItem("2", "Blue Lays", 10, "Snack","1" , true);
        Admin.menu.put("2", item2);
        Admin.FoodItem item3 = new Admin.FoodItem("3", "Coke", 60, "Beverage","1L" ,true);
        Admin.menu.put("3", item3);
        Admin.FoodItem item4 = new Admin.FoodItem("4", "Veg. Onion Pizza", 100, "Fast Food","1 Small" , true);
        Admin.menu.put("4", item4);
        Admin.FoodItem item5 = new Admin.FoodItem("5", "Kadhi Rice", 60, "Meal","1 Plate" ,true);
        Admin.menu.put("5", item5);
    }

    //Checks the user inputs are valid or not
    public static void check(String usertype, int userid, int password) {
            if (usertype.equals("Admin") && (userid == 2023568) && (password == 2005)) {
                System.out.println("You logged in as an admin");
                Admin.Methods();
            } else if (usertype.equals("Customer") && (userid == 123456) && (password == 1234)) {
                System.out.println("You logged in as a regular customer");
                Customer.Methods("Regular", userid);
            } else if (usertype.equals("Customer") && (userid == 78910) && (password == 5678)) {
                System.out.println("You logged in as a VIP customer");
                Customer.Methods("VIP", userid);
            } else {
                System.out.println("Invalid User ID or Password");
            }
    }
}
