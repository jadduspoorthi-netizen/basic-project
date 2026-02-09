/*Scenario: Compute electricity bills, apply surcharge, compare highest consumption */
package project;
import java.util.Scanner;

class ElectricityBill {

    
    static String utilityName = "Electricity Board";
    static double ratePerUnit = 6.50;

   
    int consumerNo;
    String name;
    double unitsConsumed;

    
    ElectricityBill() {
    	
        consumerNo = 0;
        name = "Unknown";
        unitsConsumed = 0;
    }

    ElectricityBill(int consumerNo, String name, double unitsConsumed) {
        this.consumerNo = consumerNo;
        this.name = name;
        this.unitsConsumed = unitsConsumed;
    }

    
    double calculateBill() {
        return unitsConsumed * ratePerUnit;
    }

   
    double calculateBill(double surcharge) {
        return calculateBill() + surcharge;
    }

    
    int compareConsumption(ElectricityBill other) {
        if (this.unitsConsumed > other.unitsConsumed)
            return 1;
        else if (this.unitsConsumed < other.unitsConsumed)
            return -1;
        else
            return 0;
    }
}

public class electricity {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // input size
        System.out.print("Enter number of consumers: ");
        int n = sc.nextInt();
        sc.nextLine();

        ElectricityBill[] bills = new ElectricityBill[n];

        
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Consumer " + (i + 1));
            System.out.print("Consumer Number: ");
            int cno = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String nm = sc.nextLine();
            System.out.print("Units Consumed: ");
            double units = sc.nextDouble();
            bills[i] = new ElectricityBill(cno, nm, units);
        }

        
        System.out.println("\n--- Bills ---");
        for (int i = 0; i < n; i++) {
            System.out.println(bills[i].name + " -> Bill = " + bills[i].calculateBill());
        }

        
        System.out.print("\nEnter surcharge: ");
        double s = sc.nextDouble();

        
        System.out.println("\n--- Bills with Surcharge ---");
        for (int i = 0; i < n; i++) {
            System.out.println(bills[i].name + " -> Bill = " + bills[i].calculateBill(s));
        }

        
        ElectricityBill max = bills[0];
        for (int i = 1; i < n; i++) {
            if (bills[i].compareConsumption(max) == 1)
                max = bills[i];
        }

       
        System.out.println("\nHighest Consumption: " + max.name + " (" + max.unitsConsumed + " units)");
    }
}
