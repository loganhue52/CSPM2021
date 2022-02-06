import java.util.Scanner;
public class Geometry {
    public static void main(String[] args){
        Scanner ui = new Scanner(System.in);
        System.out.print("\nside1: ");
        double side1 = ui.nextDouble();
        System.out.print("\nside2: ");
        double side2 = ui.nextDouble();
        System.out.print("\nside3: ");
        double side3 = ui.nextDouble();
        System.out.print("\ncolor: ");
        String color = ui.next();
        System.out.print("\nfilled: ");
        boolean filled = ui.nextBoolean();

        Triangle tri = new Triangle(side1,side2,side3,color,filled);

        System.out.println("\nArea: "+tri.getArea()+"\nPerimeter: "+tri.getPerimeter()+"\nColor: "+tri.getColor()+"\nFilled: "+tri.isFilled());
    }
}
