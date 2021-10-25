package Unit1.Assignments;
import java.util.Scanner;
import java.lang.Math;

public class FehnU1S1Problems {
    public static void main(String[] args){
        convertMileToKM();
        calculateEnergy();
        futureInvestments();
        drivingCost();
    }
    private static void convertMileToKM(){
        Scanner ui = new Scanner(System.in);
        System.out.print("Miles: ");
        double mile = ui.nextDouble();
        double km = mile*1.6;
        System.out.printf(mile+" miles = %.1f kilometers",km);
        ui.close();
    }
    private static void calculateEnergy(){
        Scanner ui = new Scanner(System.in);
        System.out.print("Kilograms of water: ");
        double m = ui.nextDouble();
        System.out.print("Initial temperature: ");
        double initTemp = ui.nextDouble();
        System.out.print("Final temperature: ");
        double finalTemp = ui.nextDouble();
        double q = m*(finalTemp-initTemp)*4184;
        System.out.printf("The energy needed is %.1f joules.",q);
        ui.close();
    }
    private static void futureInvestments(){
        Scanner ui = new Scanner(System.in);
        System.out.print("Investment amount: ");
        double investAmount = ui.nextDouble();
        System.out.print("Annual interest rate (in percent): ");
        double interestRate = ui.nextDouble()/100;
        System.out.print("Number of years: ");
        double years = ui.nextDouble();
        double futureValue = investAmount*Math.pow((1+interestRate),years);
        System.out.printf("The future value is $%.2f",futureValue);
        ui.close();
    }
    private static void drivingCost(){
        Scanner ui = new Scanner(System.in);
        System.out.print("Distance: ");
        double distance = ui.nextDouble();
        System.out.print("Miles per gallon: ");
        double mpg = ui.nextDouble();
        System.out.print("Price per gallon: ");
        double ppg = ui.nextDouble();
        double finalCost = (distance/mpg)*ppg;
        System.out.printf("The cost of driving is $%.2f",finalCost);
        ui.close();
    }
}
