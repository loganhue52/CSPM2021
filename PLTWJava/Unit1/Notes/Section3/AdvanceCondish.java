package PLTWJava.Unit1.Notes.Section3;
import java.util.Scanner;

public class AdvanceCondish{
    public static void main(String[] args){
        /*
        int a = 1;
        int b = 2;
        int c = 1;
        
        //and &&

        System.out.println(a>b && a>c); //false
        System.out.println(a<b && b>c); //true

        //or ||

        System.out.println(a>b || a>c); //false
        System.out.println(a<b || a>c); //true
        System.out.println(a<b || b>c); //true

        //input between 0 and 100
        int in=99;
        if (in<100 && in>0){
            System.out.println("in is good");
        } else{
            System.out.println("NO"); 
        }
        */
        boolean l= login();
        while(!l){
            System.out.println("Incorrect please try again");
            l = login();
        }
        System.out.println("Welcome");
    }

    public static boolean login(){
            //login
            String un = "billybob";
            String pw = "123456";
            Scanner ui = new Scanner(System.in);
            System.out.print("Username: ");
            String unIn = ui.nextLine();
            System.out.print("Password: ");
            String pwIn = ui.nextLine();
            ui.close();
            
            if (unIn.equals(un) && pwIn.equals(pw)){
                return true;
            } else {
                return false;
            }

            // while (!(unIn.equals(un) && pwIn.equals(pw))){
            //     System.out.print("Username: ");
            //     unIn = ui.nextLine();
            //     System.out.print("Password: ");
            //     pwIn = ui.nextLine();
            // }

            // System.out.println("Nice");

            
    }
    private static void what(){
        Scanner ui = new Scanner(System.in);
        System.out.print("Hey guess what: ");
        String in = ui.nextLine();
        while(!in.equals("what")){
            System.out.print("Hey guess what: ");
            in = ui.nextLine();
        }
        System.out.println("CHICKEN BUTT");
        ui.close();
    }
}