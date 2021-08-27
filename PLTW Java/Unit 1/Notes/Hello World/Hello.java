// one line comment

/* 
    comment block
    JVM = Java Virutal Machine - translates the code to the computer
    Java is a grandobject (descendant) of C
*/

//public = any file or class can access this class (in python lang - global var - private would be local var)
//class = defines that the following code is in a class
//ClassName - first letter capital AND same as the file name
public class Hello{
    public static void main(String[] args){
        //public means where and who can access method
        //method = function that objects use - object.method
        //static means we can run the method without creating an object
            //instantiation = creating the object
        //void means it will return nothing ie it doesn't return
        //methodName = main
        //(String[] args) = data passed to the function specifically string array
        System.out.println("Hello World");
        //; are . in computer science - they end the statement/sentence

        System.out.print("Howdy");
        System.out.print("Bonjour\n");

        System.out.println(5.1473);
        System.out.printf("%5.2f%n",5.1473);
    }
}

//javac (name of file) - creating class
//java (name of .java file) - running it