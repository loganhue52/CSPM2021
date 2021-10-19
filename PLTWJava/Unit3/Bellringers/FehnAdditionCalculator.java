import java.util.Scanner;

public class FehnAdditionCalculator{
    public static void main(String[] args){
        Scanner ui = new Scanner(System.in);
        System.out.print("How many numbers?: ");
        int length = ui.nextInt();
        double[] nums = new double[length];
        double total=0.0;

        for (int i=0;i<nums.length;i++){
            System.out.print("Number: ");
            double newNumber=ui.nextDouble();
            nums[i]=newNumber;
            total+=nums[i];
        }

        for (int i=0;i<nums.length;i++){System.out.print(nums[i]+" ");}

        System.out.printf("\nYour total is: %.1f",total);
    }
}