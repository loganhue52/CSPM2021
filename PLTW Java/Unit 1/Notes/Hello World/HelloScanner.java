import java.util.Scanner;

public class HelloScanner {
    public static void main(String[] args){
        //python >> input("message") > input a string
        //ClassName objectName = new ClassConstructor(parameters for obj);
        Scanner ui = new Scanner(System.in);

        String name = ui.nextLine();

        System.out.println("Hello"+name);

        ui.close();
    }
}
