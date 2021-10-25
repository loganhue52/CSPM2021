package Unit1.Assignments;
import java.util.Scanner;
import java.lang.Math;

public class FehnU1S12Problems {
    public static void main(String[] args){
        triangleArea();
        midPointTable();
        minuteYearConverter();
        triangleVolume();
    }
    private static void triangleArea(){
        Scanner ui = new Scanner(System.in);
        System.out.print("x1: ");
        double x1=ui.nextDouble();
        System.out.print("y1: ");
        double y1=ui.nextDouble();
        System.out.print("x2: ");
        double x2=ui.nextDouble();
        System.out.print("y2: ");
        double y2=ui.nextDouble();
        System.out.print("x3: ");
        double x3=ui.nextDouble();
        System.out.print("y3: ");
        double y3=ui.nextDouble();
        double side1 = Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2, 2));
        double side2 = Math.sqrt(Math.pow(x2-x3,2)+Math.pow(y2-y3, 2));
        double side3 = Math.sqrt(Math.pow(x3-x1,2)+Math.pow(y3-y1, 2));
        double s = (side1+side2+side3)/2;
        double area = Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
        System.out.printf("Area: %.2f",area);
        ui.close();
    }
    private static void midPointTable(){
        // SCOTT METHOD FOR THE WIN
        double ax1=0; double ay1=0; double ax2=1; double ay2=4; double ax3=2; double ay3=7; double ax4=3; double ay4=9; double ax5=4; double ay5=11;
        double bx1=2; double by1=1; double bx2=4; double by2=2; double bx3=6; double by3=3; double bx4=10; double by4=5; double bx5=12; double by5=7;
        double mx1=(ax1+bx1)/2; double mx2=(ax2+bx2)/2; double mx3=(ax3+bx3)/2; double mx4=(ax4+bx4)/2; double mx5=(ax5+bx5)/2;
        double my1=(ay1+by1)/2; double my2=(ay2+by2)/2; double my3=(ay3+by3)/2; double my4=(ay4+by4)/2; double my5=(ay5+by5)/2;
        System.out.println("a\t\tb\t\tMiddle Point");
        System.out.printf("(%.1f, %.1f)\t(%.1f, %.1f)\t(%.1f, %.1f)\n",ax1,ay1,bx1,by1,mx1,my1);
        System.out.printf("(%.1f, %.1f)\t(%.1f, %.1f)\t(%.1f, %.1f)\n",ax2,ay2,bx2,by2,mx2,my2);
        System.out.printf("(%.1f, %.1f)\t(%.1f, %.1f)\t(%.1f, %.1f)\n",ax3,ay3,bx3,by3,mx3,my3);
        System.out.printf("(%.1f, %.1f)\t(%.1f, %.1f)\t(%.1f, %.1f)\n",ax4,ay4,bx4,by4,mx4,my4);
        System.out.printf("(%.1f, %.1f)\t(%.1f, %.1f)\t(%.1f, %.1f)\n",ax5,ay5,bx5,by5,mx5,my5);
    }
    private static void minuteYearConverter(){
        Scanner ui = new Scanner(System.in);
        System.out.print("Minutes: ");
        int min = ui.nextInt();
        //calculation for years
        int hours = min/60;
        int days = hours/24;
        int years = days/365;
        //calculation for remaining days
        double remDays = days%365;
        System.out.printf("%d minutes is about %d years and %.0f days",min,years,remDays);
        ui.close();
    }
    private static void triangleVolume(){
        Scanner ui = new Scanner(System.in);
        System.out.print("Sides: ");
        double s = ui.nextDouble();
        System.out.print("Height: ");
        double h = ui.nextDouble();
        double area = (Math.sqrt(3)/4)*Math.pow(s, 2);
        double vol = area*h;
        System.out.printf("Area: %.2f\nVolume: %.2f",area,vol);
        ui.close();
    }
}
