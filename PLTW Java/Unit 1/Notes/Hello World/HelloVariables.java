import java.util.Scanner;

public class HelloVariables {
    /*
        Primitive Data = int, bits, bytes, boolean, float
        Non-Primative Data = strings, array, list, ArrayList
    */

    public static void main(String[] args){
        //datatype variableName = value;
        String age = "12";
        double cash = 5.25; //doube is not just for 2 decimal points
        String name = "Billy"; // String is technically a class
        boolean isOldEnough = true; // naming syntax typically begins with is

        Scanner ui = new Scanner(System.in);
        System.out.println("What is your name?");
        name = ui.nextLine(); //do not have to redefine type when reusing vars
        System.out.println("What is your age?");
        age = ui.next();

        System.out.println(name+" is "+age+" years old.");

        ui.close();
    }
}
