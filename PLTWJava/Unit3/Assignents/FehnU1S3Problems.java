package Unit3.Assignents;
import java.util.Scanner;
public class FehnU1S3Problems {
    public static void main(String[] args){
        Scanner ui = new Scanner(System.in);
        int[] listy = new int[10];
        int n;
        System.out.println("Input 10 numbers, end with 0 after 10th num: ");
        n=ui.nextInt();
        int i = 0;
        while(!(n==0)){
            listy[i] = n;
            n=ui.nextInt();
            i++;
        }
        evenOddChecker(listy);

        

        ui.close();
    }
    public static void evenOddChecker(int[] listy){
        int evens = 0;
        int odds = 0;
        for (int x: listy){
            if ((x%2)==0){
                evens++;
            } else{
                odds++;
            }
        }
        System.out.printf("\nEvens: %f\nOdds: %f",evens,odds);
        
    }
    public static int[] merge(int[] list1, int[] list){

    }
    public static boolean isSorted(int[] listy){

    }
}
