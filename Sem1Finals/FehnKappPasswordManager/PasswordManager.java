import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;

//Logan - translated python code to java, implemented use of the account class (didnt take nearly as long as I thought)
//Bryce - responsible for writing info to a text file AND how to implement it in my maze of java code 

public class PasswordManager {
    //the main method that runs on start
    public static void main(String[] args){
        //making the initial list of account objects
        List<Account> mainMap = new ArrayList<>();

        Scanner ui = new Scanner(System.in);

        Boolean logIn=false;

        System.out.print("Are you a new user? (y/n): ");
        String askNewUser=ui.nextLine();

        String masterPass="p4$$w0rD";

        //getting user information to make a new account
        if(askNewUser.toLowerCase().contains("y")){
            System.out.print("\nFirst Name: ");
            String userFName=ui.nextLine();
            System.out.print("\nLast Name: ");
            String userLName=ui.nextLine();
            System.out.print("\nUsername: ");
            String userUName=ui.nextLine();
            System.out.println("New password must have:\n\t1 capital letter\n\t1 number\n\t1 special symbol: !,@,//,$,%,^,&,(,)\n\tLength of 8 or more");
            System.out.print("\nMaster Password: ");
            masterPass = ui.nextLine();

            //making sure that the master password meets the requirements
            while (!(Checker.check(masterPass))){
                System.out.println("New password does not meet the requirements!");
                System.out.print("Master Password: ");
                masterPass = ui.nextLine();
            }

            System.out.println("Profile created!");

        }

        int tries = 3;
        
        //exits if they fail to log in 3 times
        while (logIn==false){
            System.out.print("\nEnter Master Password: ");
            String uIn = ui.nextLine();
            if (uIn.equals(masterPass)){
                logIn = true;
                System.out.println("Log In Successful!");
            }
            else if (!(uIn.equals(masterPass))){
                System.out.println("Log In Failed");
                tries -= 1;
                System.out.printf("\n%d tries remaining.",tries);
            }
            //completely shuts down the program when they fail
            if (tries == 0){
                System.out.println("Exiting...");
                System.exit(0);
            }
        }
            
        //this is the main while loop that runs throughout the entire duration of the program
        String uIn="";
        while (!(uIn.equals("quit"))){
            //wanted to go for a more console-esk feel, like a command prompt password manager and less like an "app"
            System.out.println("Commands:\n\tls - list accounts by catagory\n\taa - add account\n\tra - remove account\n\tea - edit account\n\tgp - generate password\n\ts - save\n\tquit - exit");
            System.out.print("\n> ");
            //this if statement is needed to fix a "No next line" error with Scanner
            if(ui.hasNextLine()){
                uIn = ui.nextLine();
            }
            //each sttement simply reads user input and calls functions to run
            if (uIn.toLowerCase().contains("ls")){
                listFunc(mainMap);
            }
            //the functions return the updated list so the old list is set equal to the new one
            else if (uIn.toLowerCase().contains("aa")){
                mainMap=addAccount(mainMap);
            }
            else if (uIn.toLowerCase().contains("ra")){
                mainMap=remAccount(mainMap);
            }
            else if (uIn.toLowerCase().contains("ea")){
                mainMap=editAccount(mainMap);
            }
            //instead of a function, the generator class is called here
            else if (uIn.toLowerCase().contains("gp")){
                String genPass = Generator.generate();
                System.out.printf("Generated password: %s\n",genPass);
            }
            else if (uIn.toLowerCase().equals("s")){
                saveAccounts(mainMap);
            }
            else if (uIn.toLowerCase().contains("q")){
                //System.exit(0) will stop the entire program after 0 seconds
                System.exit(0);
            }
            //if they entered something wrong, it says invalid input and the while loop starts over
            else{
                System.out.println("Invalid input");
            }
        }
        //only closing ui here in the main, if it closed in each function then it closes throughout the entire program
        //java will say it isnt closed in the other functions but it works just fine
        ui.close();
    }
    //function to list out all of accounts by catagory
    private static void listFunc(List<Account> listy){
        //creating a list of the catagories 
        List<String> catList = new ArrayList<>();
        //for each object in the list, get the catagory
        //if the list does not contain that catagory, add it to the list
        for (Account i : listy){
            String cat = i.getCatagory();
            if (!(catList.contains(cat))){
                catList.add(cat);
            }
        }
        //print accouts by catagories in catList
        //for every catagory
        for (String i : catList){
            //print the catagory first
            System.out.printf("\nCatagory: %s",i);
            //then for every account in the list
            for (Account j : listy){
                //if it has the catagory we are iterating on, print it
                if (j.getCatagory().equals(i)){
                    System.out.printf("\n\tTitle: %s\n\t\tUsername: %s\n\t\tPassword: %s\n",j.getTitle(),j.getUsername(),j.getPassword());
                }
            }
        }
    }
    //function for adding new accounts
    private static List<Account> addAccount(List<Account> listy){
        Scanner ui = new Scanner(System.in);
        //first get all of the information and store it in variables
        System.out.print("\nCatagory: ");
        String newCat=ui.nextLine();
        System.out.print("\nTitle: ");
        String newTitle=ui.nextLine();
        System.out.print("\nUsername: ");
        String newUn=ui.nextLine();
        //making sure that the new password meets the requirements
        System.out.println("New password must have:\n\t1 capital letter\n\t1 number\n\t1 special symbol: !,@,//,$,%,^,&,(,)\n\tLength of 8 or more");
        System.out.print("\nPassword: ");
        String newPass=ui.nextLine();
        //while the checker does not equal true
        while (!(Checker.check(newPass))){
            System.out.println("New password does not meet the requirements!");
            System.out.print("Password: ");
            newPass = ui.nextLine();
        }
        System.out.println("Profile created!");
        //creating a new account object and adding it to the list
        Account newAccount = new Account(newTitle,newUn,newPass,newCat);
        listy.add(newAccount);
        return listy;
    }
    //the function for removing account objects
    private static List<Account> remAccount(List<Account> listy){
        Scanner ui = new Scanner(System.in);
        //removes by title
        System.out.println("Please select the title of the account to remove.\n(use 'ls' to list catagories and passwords)");
        Boolean removed = false;
        //while the object has not been removed
        while (removed==false){
            //they can enter "ls" if the want to list out the accounts
            System.out.print("> ");
            String uIn=ui.nextLine();
            if (uIn.equals("ls")){
                listFunc(listy);
                System.out.print("\n> ");
                uIn=ui.nextLine();
            }
            //makes sure that the title the user chose was an actual title
            //creating an empty account since it throws an error if you remove within the for loop
            Account a2r = new Account();
            //for every account in the list
            for (Account i : listy){
                //if the title is correct
                if (i.getTitle().equals(uIn)){
                    //set the empty account to the account the user chose
                    a2r = i;
                    removed = true;
                }
                else{
                    System.out.println("Invalid account title, try again.");
                    break;
                }
            }
            //the removed var is for the while loop, but im using it here as a check to see if it is ready to be removed
            if (removed){
                listy.remove(listy.indexOf(a2r));
            }
        }
        return listy;
        
    }
    //function to edit the account
    private static List<Account> editAccount(List<Account> listy){
        Scanner ui = new Scanner(System.in);
        //edit by title, but the user can alsi change the title if they wish
        System.out.println("Please select the title of the account to change.\n(use 'ls' to list catagories and passwords)");
        Boolean changed = false;
        //while it hasnt been changed
        while (changed==false){
            System.out.print("> ");
            String uIn=ui.nextLine();
            if (uIn.equals("ls")){
                listFunc(listy);
                System.out.print("\n> ");
                uIn=ui.nextLine();
            }
            //makes sure that the title the user chose was an actual title
            for (Account i : listy){
                //if it was a real title, ask what to change
                if (i.getTitle().equals(uIn)){
                    System.out.print("\nWhat would you like to change?\n\t(t) - title\n\t(c) - catagory\n\t(u) - username\n\t(p) - password");
                    uIn=ui.nextLine();
                    //takes in input and uses the setters in the account class to change stuff
                    if (uIn.equals("t")){
                        System.out.print("\nNew title: ");
                        uIn=ui.nextLine();
                        i.setTitle(uIn);
                        changed=true;
                    } else if (uIn.equals("c")){
                        System.out.print("\nNew catagory: ");
                        uIn=ui.nextLine();
                        i.setCatagory(uIn);
                        changed=true;
                    } else if (uIn.equals("u")){
                        System.out.print("\nNew username: ");
                        uIn=ui.nextLine();
                        i.setUsername(uIn);
                        changed=true;
                    } else if (uIn.equals("p")){
                        //making sure that the new password meets the requirements
                        System.out.println("New password must have:\n\t1 capital letter\n\t1 number\n\t1 special symbol: !,@,//,$,%,^,&,(,)\n\tLength of 8 or more");
                        System.out.print("\nNew Password: ");
                        uIn=ui.nextLine();
                        while (!(Checker.check(uIn))){
                            System.out.println("New password does not meet the requirements!");
                            System.out.print("New Password: ");
                            uIn = ui.nextLine();
                        }
                        i.setPassword(uIn);
                        changed=true;
                    } else{
                        System.out.println("Invalid choice, please try again.");
                    }
                }
                else{
                    System.out.println("Invalid account title, try again.");
                    break;
                }
            }
        }
        return listy;
        
    }

    //Bryce's code begins here
    private static final String DATA_FILE = "mypasswords.txt";
    private static Scanner in;
    private static BufferedWriter out;
    public static void saveAccounts(List<Account> listy){
        List<String> catList = new ArrayList<>();
        //basically copy and paste from the the printing function
        for (Account i : listy){
            String cat = i.getCatagory();
            if (!(catList.contains(cat))){
                catList.add(cat);
            }
        }
        //instead of printing, it combines into a string to write
        String writeString = "";
        for (String i : catList){
            //print accouts by catagories in catList
            writeString=writeString+("\nCatagory: "+i);
            for (Account j : listy){
                if (j.getCatagory().equals(i)){
                    //logan did this one line
                    writeString=writeString+("\n\tTitle: "+j.getTitle()+"\n\t\tUsername: "+j.getUsername()+"\n\t\tPassword: "+j.getPassword()+"\n");
                }
            }
        }
        // System.out.println(writeString);
        //write to the file and save the file
        writeFile(writeString);
        saveAndClose();
    }
    //bryce was working on an implementation of editing the text file instead of overwriting but we ran out of time
    public static void writeFile(String s){
        if(out==null){
            try{
                out = new BufferedWriter(new FileWriter(DATA_FILE));
            }
            catch(Exception e){
                System.err.println("Cannot open file for output");
                e.printStackTrace();
            }
        }
        try{
            out.write(s);
            out.newLine();
        }
        catch(Exception e){
            System.err.println("Cannot write file!");
            e.printStackTrace();
        }
    }
    //saveAndClose
    public static void saveAndClose(){
        //close after the Scanner is done reading the file
        if(in!=null){
            try{
                in.close();
                in = null;
            }
            catch(Exception e){
                System.err.println("Cannot close input file!");
                e.printStackTrace();
            }
        }
        //close after the BufferedWriter is done writing to the file
        if(out!=null){
            try{
                out.close();
                out = null;
            }
            catch(Exception e){
                System.err.println("Cannot close output file!");
                e.printStackTrace();
            }
        }
    }
}
