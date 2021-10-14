import java.lang.Math;
import java.util.Scanner;

public class SciFiName {
    public static void main(String[] args){
        Scanner ui = new Scanner(System.in);

        System.out.print("Please enter your first name: ");
        String first = ui.nextLine();

        System.out.print("Please enter your last name: ");
        String last = ui.nextLine();

        System.out.print("Please enter your city's name: ");
        String city = ui.nextLine();

        System.out.print("Please enter your school's name: ");
        String school = ui.nextLine();

        System.out.print("Please enter your brother's name: ");
        String brother = ui.nextLine();

        System.out.print("Please enter your sister's name: ");
        String sister = ui.nextLine();

        int rF=(int) (Math.random()*first.length());
        int rL=(int) (Math.random()*last.length());
        String sciFirst = first.substring(0,rF)+last.substring(rL);
        //String sciFirst = first.substring(0,3)+last.substring(5);
        int rC=(int) (Math.random()*city.length());
        int rS=(int) (Math.random()*school.length());
        String sciLast = city.substring(0,rC)+school.substring(rS);
        int rB=(int) (Math.random()*brother.length());
        int rSi=(int) (Math.random()*sister.length());
        String sciHome = brother.substring(0,rB)+sister.substring(rSi);

        System.out.printf("Welcome! %s %s from %s",sciFirst,sciLast,sciHome);
    }
}
