import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListNotes {
    public static void main(String[] args){
        //Declaration <datatype> name = new Constructor<datatype>();
        ArrayList listy = new ArrayList();
        ArrayList     <String>  stringlist = new ArrayList  <String>  ();
        ArrayList<Integer> intlist = new ArrayList<Integer>();

        //add numbers
        intlist.add(1);

        //generic list
        listy.add(1);
        listy.add("1");
        listy.add("Kevin");
        listy.add(3.14159);
        // strings wont have "" in the list
        //System.out.println(listy);
        for (int i=0;i<listy.size();i++){
            listy.get(i); // get an item from the list

            //System.out.println(listy.get(i).getClass().getName());
        }
        // additionCalc();
        yourTurn();
    }
    public static void additionCalc(){
        Scanner ui = new Scanner(System.in);
        ArrayList<Double> numbers = new ArrayList<Double>();
        double total=0.0;

        System.out.print("\nNumber: ");
        double newNum = ui.nextDouble();

        while(newNum!=0){
            numbers.add(newNum);
            System.out.print("\nNumber: ");
            newNum = ui.nextDouble();
        }

        for (int i=0;i<numbers.size();i++){total+=numbers.get(i);System.out.print(numbers.get(i)+" ");}

        System.out.printf("\nYour total is: %.1f",total);
        ui.close();
    }
    public static void yourTurn(){
        ArrayList<String> animalList = new ArrayList<String>();
        animalList.add("lizard");
        animalList.add("doggie");
        animalList.add("cat");

        Scanner n = new Scanner(System.in);
        String input="";
        int pos;

        while(!input.equals("q")){
            System.out.println(animalList);
            System.out.println("(a) Add, (i) Insert, (r) Remove, (p) Replace, (c) Clear, or (q) Quit: ");
            input = n.nextLine();

            if (input.equals("a")){
                System.out.println("Animal: ");
                input = n.nextLine();
                animalList.add(input);
            } else if(input.equals("i")){
                System.out.println("Animal: ");
                input = n.nextLine();
                System.out.println("Position: ");
                pos=n.nextInt();
                if(pos>0 && pos<animalList.size()+1){
                    animalList.add(pos-1,input);
                } else {
                    System.out.println("Invalid input");
                }
            } else if (input.equals("r")){
                System.out.println("Animal: ");
                input=n.nextLine();
                animalList.remove(input);
                // for(int i=0;i<animalList.size();i++){
                //     if (animalList.get(i).equals(input)){
                //         animalList.remove(i);
                //     }
                // }
                
                
            } else if (input.equals("p")){
                System.out.println("Animal to add: ");
                input = n.nextLine();
                System.out.println("Position to replace: ");
                pos=n.nextInt();
                if(pos>0 && pos<animalList.size()+1){
                    animalList.set(pos-1,input);
                } else {
                    System.out.println("Invalid input");
                }
            } else if (input.equals("c")){
                System.out.println("Are you sure? ");
                input=n.nextLine();
                if (input.contains("y")){
                    animalList.clear();
                }
            }
        }
        n.close();
    }
}
