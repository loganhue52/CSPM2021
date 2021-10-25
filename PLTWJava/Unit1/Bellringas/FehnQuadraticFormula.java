package Unit1.Bellringas;
import java.lang.Math;
import java.util.Scanner;

public class FehnQuadraticFormula {
    public static void main(String[] args){
        Scanner ui = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = ui.nextDouble();
        System.out.print("Enter b: ");
        double b = ui.nextDouble();
        System.out.print("Enter c: ");
        double c = ui.nextDouble();

        double dis = Math.pow(b, 2)-(4*a*c);

        if (dis>0){
            double x1 = ((b*-1)+(Math.sqrt(dis)))/(2*a);
            double x2 = ((b*-1)-(Math.sqrt(dis)))/(2*a);
            System.out.printf("x = %f & %f",x1,x2);
        } else if (dis==0){
            double x1 = ((b*-1)+(Math.sqrt(dis)))/(2*a);
            System.out.printf("x has one root. x = %f",x1);
        } else{
            System.out.println("x has no real roots.");
        }

        ui.close();
    }
}
