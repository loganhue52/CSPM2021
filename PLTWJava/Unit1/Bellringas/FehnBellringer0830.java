package PLTWJava.Unit1.Bellringas;

import java.util.Scanner;

public class FehnBellringer0830 {
    public static void main(String[] args){
        Scanner ui = new Scanner(System.in);
        System.out.println("Hello human.");
        System.out.println("What is your name?");
        String name = ui.next();
        System.out.println(name+", where do you go to school?");
        String school = ui.next();
        System.out.println("Do you like going to "+school+"?");
        String status = ui.next();
        System.out.println("Well "+name+", I hope you enjoy your day at "+school);
        ui.close();
    }
}