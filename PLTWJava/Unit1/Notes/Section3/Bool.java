package PLTWJava.Unit1.Notes.Section3;

public class Bool{
    public static void main(String[] args){
        //Boolean expression = any expression that returns a bool (true or false)
        // String name;
        // List l;
        // ArrayList al;
        //int x;
        //double y;
        //char c;
        // ar[];
        //byte b;
        boolean a; //primitize
        boolean b = true; // in Python = True
        boolean c = false;

        a = false;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        /* Relational operators
            > < <= => 
            && and
            || or
            != not equal to
            == equal to

        */

        a = a!=b; //false
        b = a==b; //false
        c = !(a==b); //false !() means not (opposite of ()) basically a negative sign

        int d=4;
        int e=5;

        System.out.println(d<e); //true

        System.out.println("true" == "tru"); //false
        
    }
}