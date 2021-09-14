package PLTWJava.Unit1.Notes.Section3;
import java.util.Scanner;

public class Condish {
    public static void main(String[] args){
        //CONDITIONAL STATEMENT -> if then else else if
        
        int b = 3;
        int a = 8;
        int c = 6;

        //python if b!=0:

        /*
        if (b!=0){
            System.out.println("b is not 0");
        }
        if (a>c){
            System.out.println("a is less than c");
        }
        if (a/c >0){
            System.out.println("a/c is greater than 0");
        }

        //else if
        //python = elif java = else if

        if(b!=0){
            System.out.println("b is not 0");
        } else if (b!=3){
            System.out.println("b is not 3");
        } else{
            System.out.println("all failed");
        }
        if (a>c){
            System.out.println("a is less than c");
        } else {
            System.out.println("a is not nless than c");
        }
        */

        //gradeChecker();

        //evenOddChecker();

        //return function
        evenOddChecker(999);

        midpoint();
        

    }
    private static void gradeChecker(){
        Scanner ui = new Scanner(System.in);
        System.out.print("Int grade: ");
        int gradeNum = ui.nextInt();
        if (gradeNum>=90){
            System.out.println("A");
        } else if (gradeNum>=80){
            System.out.println("B");
        } else if (gradeNum>=70){
            System.out.println("c");
        } else if (gradeNum>=60){
            System.out.println("D");
        } else{
            System.out.println("F");
        }
        ui.close();
    }
    private static void evenOddChecker(){
        Scanner ui = new Scanner(System.in);
        System.out.print("Even or Odd #: ");
        if (ui.nextInt()%2 == 0){
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
        ui.close();
    }

    //a function that returns true or false
    private static boolean evenOddChecker(int n){
        if (n%2==0){
            System.out.printf("%n is Even\n",n);
            return true;
        } else {
            System.out.printf("%n is Odd\n",n);
            return false;
        }
    }

    private static void midpoint(){
        Scanner ui = new Scanner(System.in);
        System.out.print("X-coord: ");
        double x = ui.nextDouble();
        System.out.print("Y-coord: ");
        double y = ui.nextDouble();

        if (!(y>0)){
            System.out.print("The point is outside.");
        } else if (x<0){
            System.out.print("The point is outside.");
        } else if (y<=(-0.5*x)+100){
            System.out.print("The point is inside.");
        }
        else{
            System.out.print("The point is outside.");
        }
        ui.close();
    }



}
