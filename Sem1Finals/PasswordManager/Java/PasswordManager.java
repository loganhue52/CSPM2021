import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class PasswordManager {
    public static void main(String[] args){

        List<Account> mainMap = new ArrayList<>();

        Scanner ui = new Scanner(System.in);

        Boolean logIn=false;

        System.out.print("Are you a new user? (y/n): ");
        String askNewUser=ui.nextLine();

        String masterPass="p4$$w0rD";

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
            while (!(Checker.check(masterPass))){
                System.out.println("New password does not meet the requirements!");
                System.out.print("Master Password: ");
                masterPass = ui.nextLine();
            }
            System.out.println("Profile created!");
        }
        int tries = 3;
        while (logIn==false){
            System.out.print("Enter Master Password: ");
            String uIn = ui.nextLine();
            if (uIn.equals(masterPass)){
                logIn = true;
                System.out.println("Log In Successful!");
            }
            else if (!(uIn.equals(masterPass))){
                System.out.println("Log In Failed");
                tries -= 1;
                System.out.printf("\n{0} tries remaining.",tries);
            }
            //completely shuts down the program when they fail
            if (tries == 0){
                System.out.println("Exiting...");
                System.exit(0);
            }
        }
            
        //print('Welcome.')

        String uIn="";
        while (!(uIn.equals("quit"))){
            //wanted to go for a more console-esk feel, like a command prompt password manager and less like an "app"
            System.out.println("Commands:\n\tls - list accounts by catagory\n\taa - add account\n\tra - remove account\n\tea - edit account\n\tgp - generate password\n\tquit - exit");
            System.out.print("> ");
            uIn = ui.nextLine();
            //these are all of my checkers to run fuctions when the user inputs a command
            // if (uIn.toLowerCase().contains("ac")){
            //     addCatagory(mainMap);
            // }
            if (uIn.toLowerCase().contains("ls")){
                listFunc(mainMap);
            }
            else if (uIn.toLowerCase().contains("aa")){
                // if (!(fillCheck(mainMap))){
                //     System.out.println("Please create a catagory first!");
                // }
                // else{
                mainMap=addAccount(mainMap);
            }
            else if (uIn.toLowerCase().contains("ra")){
                // if (!(fillCheck(catDictionary))){
                //     System.out.println("Please create a catagory first!");
                // }
                // else{
                mainMap=remAccount(mainMap);
            }
            else if (uIn.toLowerCase().contains("ea")){
                // if (!(fillCheck(catDictionary))){
                //     System.out.println("Please create a catagory first!");
                // }
                // else{
                mainMap=editAccount(mainMap);
            }
            else if (uIn.toLowerCase().contains("gp")){
                String genPass = Generator.generate();
                System.out.printf("Generated password: {0}",genPass);
            }
            else if (uIn.toLowerCase().contains("q")){
                System.exit(0);
            }
            else{
                System.out.println("Invalid input");
            }
        }
        ui.close();
    }
    // private static void addCatagory(List<Account> listy){
    //     List<String> values = new ArrayList<>();
    //     Scanner ui = new Scanner(System.in);
    //     System.out.print("Catagory Name: ");
    //     String uIn = ui.nextLine();
    //     //making the stored dictionary values a list so i can remove specific indices
    //     dict.put(uIn, values);
    //     return dict;
    // }
    private static void listFunc(List<Account> dict){
        //for every key (the catagories) in the dictionary, print (catagory):
        List<String> catList = new ArrayList<>();
        for (Account i : dict){
            String cat = i.getCatagory();
            if (!(catList.contains(cat))){
                catList.add(cat);
            }
        }
        for (String i : catList){
            //print accouts by catagories in catList
            System.out.printf("\nCatagory: {0}",i);
            for (Account j : dict){
                if (j.getCatagory().equals(i)){
                    System.out.printf("\n\tTitle: {0}\n\t\tUsername: {1}\n\t\tPassword: {2}",j.getTitle(),j.getUsername(),j.getPassword());
                }
            }
        }
    }
    private static List<Account> addAccount(List<Account> dict){
        Scanner ui = new Scanner(System.in);
        System.out.print("\nCatagory: ");
        String newCat=ui.nextLine();
        System.out.print("\nTitle: ");
        String newTitle=ui.nextLine();
        System.out.print("\nUsername: ");
        String newUn=ui.nextLine();
        System.out.print("\nPassword: ");
        String newPass=ui.nextLine();
        Account newAccount = new Account(newTitle,newUn,newPass,newCat);
        dict.add(newAccount);
        ui.close();
        return dict;

        //this placed variable was a debug thing i did but decided to keep because it works
        // Boolean placed=false;
        // Boolean isCatagory=false;
        // //telling the user the requirements
        // System.out.println("New password must have:\n\t1 capital letter\n\t1 number\n\t1 special symbol: !,@,//,$,%,^,&,(,)\n\tLength of 8 or more");
        // System.out.print("New password: ");
        // String newPass=ui.nextLine();
        // //this makes sure that they enter a password that meets the requirements
        // while (Checker.check(newPass)==false){
        //     System.out.println("New password does not meet the requirements!");
        //     System.out.print("New password: ");
        //     newPass=ui.nextLine();
        // }
        // System.out.println("Please select a catagory to add your password to.\n(use 'ls' to list catagories and passwords.)");
        // while (placed==false){
        //     //wasn't sure if i should keep this but i did
        //     System.out.print("> ");
        //     String uIn=ui.nextLine();
        //     if (uIn.equals("ls")){
        //         listFunc(dict);
        //         System.out.print("\n> ");
        //         uIn=ui.nextLine();
        //     }
        //     //makes sure that the catagory the user chose was an actual catagory
        //     for (Account i : dict){
        //         if (i.getCatagory().equals(uIn)){
        //             isCatagory=true;
        //         }
        //     }
        //     if (isCatagory){
        //         dict.indexOf(uIn);
        //         placed=true;
        //     }
        //     else{
        //         System.out.println("Invalid catagory, try again.");
        //     }
        // //print(catDictionary)
        // }
    }
    private static List<Account> remAccount(List<Account> dict){
        Scanner ui = new Scanner(System.in);
        System.out.println("Please select the title of the account to remove.\n(use 'ls' to list catagories and passwords)");
        Boolean removed = false;
        while (removed==false){
            //wasn't sure if i should keep this but i did
            System.out.print("> ");
            String uIn=ui.nextLine();
            if (uIn.equals("ls")){
                listFunc(dict);
                System.out.print("\n> ");
                uIn=ui.nextLine();
            }
            //makes sure that the title the user chose was an actual title
            for (Account i : dict){
                if (i.getTitle().equals(uIn)){
                    dict.remove(i);
                }
                else{
                    System.out.println("Invalid account title, try again.");
                    break;
                }
            }
            ui.close();
        }
        return dict;
        // while (true){
        //     int x = 0;
        //     System.out.print("Catagory Name: ");
        //     String uCat = ui.nextLine();
        //     if (dict.isEmpty()){
        //         System.out.println("There are no passwards in this catagory!");
        //         break;
        //     }
        //     if (dict.keys().toString().contains(uCat)){
        //         // if type(catDictionary[uCat]) == list:
        //         //need to find a way to iterate through the values of the uCat key
        //         for (String i : dict[uCat]){
        //             x+=1
        //             print(f'{x}.',i)
        //         }
        //         // break
        //         // else:
        //         //     print("1.",catDictionary[uCat])
        //         //     break
        //     }
        //     else{
        //         System.out.println("Invalid catagory");
        //     }
        // }
        // uI=input('Select the password to remove: ')
        // //couldn't figure out how to remove specific values from a dictionary key, so i made the values for the dict a list
        // k = int(uI)-1
        // //the user can either put in the exact password or the number cooresponding to it
        // //the following conditional is for if they entered a number or the exact password
        // if uI in catDictionary[uCat]:
        //     // i = str(catDictionary[uCat])
        //     indice=int(catDictionary[uCat].index(uI))
        //     catDictionary[uCat] = catDictionary[uCat][:indice]+catDictionary[uCat][indice+1:]
        // elif catDictionary[uCat][k] != "":
        //     catDictionary[uCat] = catDictionary[uCat][:k]+catDictionary[uCat][k+1:]
        // else:
        //     print('Invalid Input')
    }
    private static List<Account> editAccount(List<Account> dict){

        //add ability to edit any aspect of the account




            // while True:
            //     x=0
            //     uCat = input('Catagory Name: ')
            //     if fillCheck(catDictionary[uCat]) == False:
            //         print('There are no passwards in this catagory!')
            //         //copied code from the remPass() function
            //         return
            //     if uCat in catDictionary.keys():
            //         if type(catDictionary[uCat]) == list:
            //             for i in catDictionary[uCat]:
            //                 x+=1
            //                 print(f'{x}.',i)
            //             break
            //         else:
            //             print("1.",catDictionary[uCat])
            //             break
            //     else:
            //         print('Invalid catagory')
            
            // uI=input('Select the password to edit: ')
            // changeIn=input('Type what you want it changed to: ')
            // while Checker(changeIn).check()==False:
            //     print('New password does not meet the requirements!')
            //     changeIn=input('Changed password: ')
            // k = int(uI)-1
            // //most of this function is copied from the remPass() function but instead of removing, it replaces
            // if uI in catDictionary[uCat]:
            //     indice=int(catDictionary[uCat].index(uI))
            //     catDictionary[uCat][indice] = str(changeIn)
            // elif catDictionary[uCat][k] != "":
            //     catDictionary[uCat][k] = str(changeIn) 
            // else:
            //     print('Invalid Input')
    //this function makes sure that there are values in what is passed in
    // private static Boolean fillCheck(Dictionary<String,String> i){
    //     if str(i) == "":
    //         return False
    //     elif i == {}:
    //         return False
    //     elif i == []:
    //         return False
    //     else:
    //         return True
    }
}
