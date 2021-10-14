public class StringNotes{
    public static void main(String[] args){
        String name = "bobby"; //literal assignment
        String name2 = new String("Rick"); //class construcotr

        System.out.println(name);
        System.out.println(name.concat(name2));
        System.out.println(name+name2);
        
        if (name2.equals(name)){
            System.out.println("They are the same!");
        } else{
            System.out.println("They are not the same!");
        }

        name+=name2;

        //implicit type conversion
        double age = 18.0;
        System.out.println("Your ae is "+age);
        
        //main string methods
        //substring = get a section of the string
        //indexOf = return the index of a character of a string String.indexOf("char")
        //equals = Strings can use == | String.equals(Object)
        //length = length of string

        String email = "roobert.edward@shoecarnival.com";
        
        //print the username only
        //from the first char TO the @ not including
        System.out.println(email.substring(0,email.indexOf("@")));
        //find the domain
        //starts at the @ and prints the rest of the string - only one parameter
        System.out.println(email.substring(email.indexOf("@")));

        //length of username
        System.out.println(email.substring(0,email.indexOf("@")).length());

    }
}