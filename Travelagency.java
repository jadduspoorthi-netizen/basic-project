package project;
import java.util.Random;
import java.util.Scanner;

class Travelagency{

    // Calculate fare without discount
    double calculateFare(double distance, double rate) {
        return distance * rate;
    }

    // Generate random discount coupon (5% to 15%)
    int generateCoupon() {
        Random r = new Random();
        return r.nextInt(11) + 5;
    }

   
    double applyDiscount(double fare, int coupon) {
        double discount = (fare * coupon) / 100;
        return fare - discount;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Travelagency obj = new Travelagency();
        System.out.print("Enter number of customers: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            System.out.println("\nCustomer " + i);

            System.out.print("Enter distance travelled (km): ");
            double distance = sc.nextDouble();

            System.out.print("Enter rate per km: ");
            double rate = sc.nextDouble();

            double fare = obj.calculateFare(distance, rate);
            int coupon = obj.generateCoupon();
            double finalFare = obj.applyDiscount(fare, coupon);

            System.out.println("Original Fare: ₹" + fare);
            System.out.println("Discount Coupon: " + coupon + "%");
            System.out.println("Final Fare: ₹" + finalFare);
        }

        sc.close();
    }
}
