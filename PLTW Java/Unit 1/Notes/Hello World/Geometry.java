import java.util.Scanner;
import java.lang.Math;

public class Geometry {
    public static void main(String[] args){
        Scanner ui = new Scanner(System.in);
        //Constant variable
        //all caps
        final double PI = 3.141592654;
        System.out.println("Circle or Square?");
        String shape = ui.nextLine();

        if (shape.equals("Circle")) {
            System.out.println("Radius:");
            String radius = ui.next();
            int r=Integer.parseInt(radius);
            double power = Math.pow(r, 2);
            double area = (power*PI);
            System.out.println("Area of Circle: "+area);
        } else {
            System.out.println("Length:");
            String len = ui.next();
            int length=Integer.parseInt(len);
            System.out.println("Width:");
            String wid = ui.next();
            int width=Integer.parseInt(wid);
            double area = (length*width);
            System.out.println("Area of Square: "+area);
        }
        ui.close();
    }
}
