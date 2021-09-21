package PLTWJava.Unit1.Notes.Section1;
import java.util.Scanner;

public class LoopNotes{
    public static void main(String[] args){
        // dont do this
        // while(true){
        //     System.out.println("Hi");
        // }

        /*
        int i = 1;
        while (i<11){
            System.out.print(i+", ");
            i++;
        } */

        /*
        for (int i=1;i<11;i++){
            System.out.print(i+", ");
        }

        System.out.println();

        for (int j=10;j>0;j--){
            System.out.print(j+", ");
        }
        */
        // for (iterater num; loop until; step count)
        /*
        for (int j=1;j<11;j++){
            if (j<10){
                System.out.print(j+", ");
            } else{
                System.out.print(j);
            }
        }

        System.out.println();

        int k=1;
        while(k<11){
            if (k<10){
                System.out.print(k+", ");
            } else{
                System.out.print(k);
            }
            k++;
        }
        */
        // one liner: while(i<length){i++;}
        // if(i==12)System.out.println("yes");

        //create a f(x) that takes in user input until they type in -1
            //after, output the min and max value they entered
        basicStats();
    }
    private static void minMaxChecker(){
        Scanner ui = new Scanner(System.in);
        System.out.print("Give me a numba: ");
        int num = ui.nextInt();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (num!=-1){
            if (num<min){
                min = num;
            } else if (num>max){
                max = num;
            }
            System.out.print("Give me a numba: ");
            num = ui.nextInt();
        }
        System.out.println("min: "+min+", max: "+max);
        ui.close();
    }
    private static void basicStats(){
        //loop until user enters q
        //find the mix max avg and total
        Scanner ui = new Scanner(System.in);
        System.out.print("Give me a numba: ");
        String num = ui.nextLine();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int total = 0;
        int iter = 0;
        while (!num.equals("q")){
            if (Integer.valueOf(num)<min){
                min = Integer.valueOf(num);
            } else if (Integer.valueOf(num)>max){
                max = Integer.valueOf(num);
            }
            iter++;
            total += Integer.valueOf(num);
            System.out.print("Give me a numba: ");
            num = ui.nextLine();
        }
        System.out.println("min: "+min+"\n max: "+max+"\n avg: "+(total/iter)+"\n total: "+total);
        ui.close();
    }
}