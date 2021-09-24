package PLTWJava.Unit1.Notes.Section3;

import java.util.Random;
import java.lang.Math;
import java.util.Scanner;

public class BasicMathQuiz{
    public static void main(String[] args){
        Scanner ui = new Scanner(System.in);
        Random rand = new Random();
        int points = 0;
        int i = 10;
        while(i!=0){
            int num1 = (int)(Math.random()*100); //Math class random
            int signNum = rand.nextInt(4);
            int num2 = rand.nextInt(10)+1;      // Random class method
            double ans=0;
            if (signNum==1){
                ans = num1/num2;
                System.out.printf("What is %d / %d ?: ",num1,num2);
            } else if (signNum==2){
                ans = num1*num2;
                System.out.printf("What is %d * %d ?: ",num1,num2);
            } else if (signNum==3){
                ans = num1-num2;
                System.out.printf("What is %d - %d ?: ",num1,num2);
            } else {
                ans = num1+num2;
                System.out.printf("What is %d + %d ?: ",num1,num2);
            }
            
            double in = ui.nextInt();
            if (in==ans){
                System.out.println("Correct!");
                points+=1;
            } else{System.out.println("FALSE");}
            //%f float or double     %d = int     %s = string
            System.out.printf("Answer: %f\n",ans);
            i--;
        }
        System.out.printf("You got %d correct out of 10",points);
        ui.close();
        //save the results
    }
}