package project;

import java.util.Scanner;

class Restaurant {

    static double gstRate = 0.05;       
    static double discountRate = 0.10;  
    static double studentDiscountRate = 0.05; 

    String restaurantName;

    Restaurant(String name) {
        restaurantName = name;
    }

    
    static double calculateGST(double amount) {
        return amount * gstRate;
    }

   
    static double calculateDiscount(double amount) {
        return amount * discountRate;
    }

    static double calculateDiscount(double amount, boolean isStudent) {
        if (isStudent)
            return amount * (discountRate + studentDiscountRate);
        else
            return amount * discountRate;
    }
}

class Order extends Restaurant {

    int orderId;

    String[] itemNames = {"Burger", "Pizza", "Pasta", "Sandwich", "Cold Drink"};
    double[] itemPrice = {120, 150, 200, 100, 60};

    int[] itemQty = new int[itemNames.length];

    double baseAmount;
    double gstAmount;
    double discountAmount;
    double finalAmount;

    boolean isStudent;

    static double totalSales = 0;

    Order(int orderId, String name, boolean isStudent) {
        super(name);
        this.orderId = orderId;
        this.isStudent = isStudent;
    }

    void displayMenu() {
        System.out.println("\n--- MENU ---");
        for (int i = 0; i < itemNames.length; i++) {
            System.out.println((i + 1) + ". " + itemNames[i] + " : ₹" + itemPrice[i]);
        }
    }

    void takeOrder(Scanner sc) {
        for (int i = 0; i < itemNames.length; i++) {
            System.out.print("Enter quantity for " + itemNames[i] + ": ");
            itemQty[i] = sc.nextInt();
        }
    }

    void generateBill() {
        baseAmount = 0;

        for (int i = 0; i < itemNames.length; i++) {
            baseAmount += itemQty[i] * itemPrice[i];
        }

        gstAmount = calculateGST(baseAmount);
        discountAmount = calculateDiscount(baseAmount, isStudent);
        finalAmount = baseAmount + gstAmount - discountAmount;

        totalSales += finalAmount;
    }

    void displayBill() {
        System.out.println("\n--- BILL ---");
        System.out.println("Order ID: " + orderId);
        System.out.println("Restaurant: " + restaurantName);
        System.out.println("Base Amount: ₹" + baseAmount);
        System.out.println("GST (5%): ₹" + gstAmount);

        if (isStudent)
            System.out.println("Discount (15% - Student): ₹" + discountAmount);
        else
            System.out.println("Discount (10%): ₹" + discountAmount);

        System.out.println("Final Payable Amount: ₹" + finalAmount);
    }

   
    static void dailyReport() {
        System.out.println("\n----- DAILY SALES REPORT -----");
        System.out.println("Total Sales of the Day: ₹" + totalSales);
        System.out.println(" Report generated successfully on screen");
    }
}

public class Restaurent {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number of Orders Today: ");
        int n = sc.nextInt();

        Order[] orders = new Order[n];   // Array of Objects

        for (int i = 0; i < n; i++) {

            System.out.println("\n--- Order " + (i + 1) + " ---");

            System.out.print("Enter Order ID: ");
            int id = sc.nextInt();

            sc.nextLine();
            System.out.print("Enter Restaurant Name: ");
            String name = sc.nextLine();

            System.out.print("Is Student? (true/false): ");
            boolean isStudent = sc.nextBoolean();

            orders[i] = new Order(id, name, isStudent);

            orders[i].displayMenu();
            orders[i].takeOrder(sc);
            orders[i].generateBill();
            orders[i].displayBill();
        }

        //  Display Total Daily Sales
        Order.dailyReport();

        sc.close();
    }
}