import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayNotes{
    public static void main(String[] args){
        /*
            Python List
            listy=[1,2.4,"string",[1,2,3],True,function()]
            listy[2] -> "string"
            listy[2] = "poop"
        */
        //datatupe[] name = {data};
        int[] numbers = {1,2,3,4,5,6,7,8,9};
        double[] decimals = {1.1,2.2,3.3,4.4,5.5};

        //empty list in python -> listy=[]

        //this causes issues
        int[] emptynums;
        //empty arrays can only have a set amount put into them
        int[] emptynums2 = new int[28];

        //printArray(numbers);        

        //use String,Double,Integer... have to pass in class
        List<String> list = new ArrayList<>();

        list.add("this is");
        list.add("an array list");

        //System.out.println(list);

        int[] rando={1,2,3,4,5,6,7,8,9};
        //for loop to add 10 to even numbers
        for (int i=1;i<rando.length;i+=2){
            rando[i]=rando[i]+10;
        }
        printArray(rando);


    }
    private static void printArray(int[] listy){
        for (int i=0;i<listy.length;i++){
            System.out.println(listy[i]);
        }
    }
    private static void gpaCalc(){
        Scanner sc = new Scanner(System.in);
        double[] grades = new double[5];
        double avg = 0;
        for (int i=0;i<5;i++){
            double g = sc.nextDouble();
            grades[i]=g;
        }
        for (int i=0;i<grades.length;i++){
            avg+=grades[i];
        }
        avg/=5;
        System.out.println(avg);
        
    }
}