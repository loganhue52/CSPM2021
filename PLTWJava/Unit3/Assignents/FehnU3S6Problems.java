package Unit3.Assignents;
import java.util.Scanner;
public class FehnU3S6Problems {
    public static void main(String[] args){
        Scanner ui = new Scanner(System.in);
        int[] listy = new int[10];
        System.out.println("Input 10 numbers, end with 0 after 10th num: ");
        int n=ui.nextInt();
        int i = 0;
        while(!(n==0)){
            listy[i] = n;
            n=ui.nextInt();
            i++;
        }
        evenOddChecker(listy);
        
        System.out.print("Enter list1 size: ");
        int[] list1 = new int[ui.nextInt()];
        System.out.print("Enter list1 contents one by one: ");
        n=ui.nextInt();
        i = 0;
        while(!(i==list1.length-1)){
            list1[i] = n;
            n=ui.nextInt();
            i++;
        }
        System.out.print("Enter list2 size: ");
        int[] list2 = new int[ui.nextInt()];
        System.out.print("Enter list2 contents one by one: ");
        n=ui.nextInt();
        i = 0;
        while(!(i==list2.length-1)){
            list2[i] = n;
            n=ui.nextInt();
            i++;
        }
        System.out.println("Merged list: "+merge(list1,list2));
        

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
