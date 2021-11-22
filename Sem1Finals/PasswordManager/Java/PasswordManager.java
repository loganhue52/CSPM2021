import java.util.Scanner;
import java.util.List;
import java.util.Hashtable;
import java.util.Dictionary;

public class PasswordManager {
    public static void main(String[] args){
        // https://www.educative.io/edpresso/how-to-create-a-dictionary-in-java
        Dictionary<String,String> catDictionary = new Hashtable<String,String>();

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
            System.out.println("Account created!");
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
            System.out.println("Commands:\n\tac - add catagory\n\tls - list catagories and passwords\n\tap - add password\n\trp - remove password\n\tep - edit password\n\tgp - generate password\n\tquit - exit");
            System.out.print("> ");
            uIn = ui.nextLine();
            //these are all of my checkers to run fuctions when the user inputs a command
            if (uIn.toLowerCase().contains("ac")){
                addCatagory();
            }
            else if (uIn.toLowerCase().contains("ls")){
                listFunc();
            }
            else if (uIn.toLowerCase().contains("ap")){
                if (!(fillCheck(catDictionary))){
                    System.out.println("Please create a catagory first!");
                }
                else{addPass();}
            }
            else if (uIn.toLowerCase().contains("rp")){
                if (!(fillCheck(catDictionary))){
                    System.out.println("Please create a catagory first!");
                }
                else{remPass();}
            }
            else if (uIn.toLowerCase().contains("ep")){
                if (!(fillCheck(catDictionary))){
                    System.out.println("Please create a catagory first!");
                }
                else{editPass();}
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
    }
    private static void addCatagory(Dictionary<String,String> dict){
        Scanner ui = new Scanner(System.in);
        System.out.print("Catagory Name: ");
        String uIn = ui.nextLine();
        //making the stored dictionary values a list so i can remove specific indices
        dict.put(uIn, "");
    }
    private static void listFunc(Dictionary<String,String> dict){
        //for every key (the catagories) in the dictionary, print (catagory):
        for (String i : (List<String>)(dict.keys())){
            System.out.println(i + ":");

            //this conditional was to fix the issue of printing out one vs multiple values
            //if the value is a list, it iterates through the list
            //if it isnt, it just prints that value
            //Credit to Gaege for this one
            if type(catDictionary[i]) == list:
                for j in catDictionary[i]:
                    print("\t",j)
                print()
            else:
                print("\t",catDictionary[i])
                print()
        }
    }
    private static void addPass(){
            //this placed variable was a debug thing i did but decided to keep because it works
            placed=False
            //telling the user the requirements
            print('New password must have:\n\t1 capital letter\n\t1 number\n\t1 special symbol: !,@,//,$,%,^,&,(,)\n\tLength of 8 or more')
            newPass=input('New password: ')
            //this makes sure that they enter a password that meets the requirements
            while Checker(newPass).check()==False:
                print('New password does not meet the requirements!')
                newPass=input('New password: ')
            print('Please select a catagory to add your password to.\n(use "ls" to list catagories and passwords.)')
            while placed==False:
                //wasn't sure if i should keep this but i did
                uI=input('> ')
                if uI=="ls":
                    listFunc()
                    uI=input('> ')
                //makes sure that the catagory the user chose was an actual catagory
                if uI in catDictionary.keys():
                    catDictionary[uI].append(newPass)
                    placed=True
                else:
                    print('Invalid catagory, try again.')
            //print(catDictionary)
    }
    private static void remPass(){
            while True:
                x = 0
                uCat = input('Catagory Name: ')
                if fillCheck(catDictionary[uCat]) == False:
                    print('There are no passwards in this catagory!')
                    return
                if uCat in catDictionary.keys():
                    if type(catDictionary[uCat]) == list:
                        for i in catDictionary[uCat]:
                            x+=1
                            print(f'{x}.',i)
                        break
                    else:
                        print("1.",catDictionary[uCat])
                        break
                else:
                    print('Invalid catagory')
            uI=input('Select the password to remove: ')
            //couldn't figure out how to remove specific values from a dictionary key, so i made the values for the dict a list
            k = int(uI)-1
            //the user can either put in the exact password or the number cooresponding to it
            //the following conditional is for if they entered a number or the exact password
            if uI in catDictionary[uCat]:
                // i = str(catDictionary[uCat])
                indice=int(catDictionary[uCat].index(uI))
                catDictionary[uCat] = catDictionary[uCat][:indice]+catDictionary[uCat][indice+1:]
            elif catDictionary[uCat][k] != "":
                catDictionary[uCat] = catDictionary[uCat][:k]+catDictionary[uCat][k+1:]
            else:
                print('Invalid Input')
    }
    private static void editPass(){
            while True:
                x=0
                uCat = input('Catagory Name: ')
                if fillCheck(catDictionary[uCat]) == False:
                    print('There are no passwards in this catagory!')
                    //copied code from the remPass() function
                    return
                if uCat in catDictionary.keys():
                    if type(catDictionary[uCat]) == list:
                        for i in catDictionary[uCat]:
                            x+=1
                            print(f'{x}.',i)
                        break
                    else:
                        print("1.",catDictionary[uCat])
                        break
                else:
                    print('Invalid catagory')
            
            uI=input('Select the password to edit: ')
            changeIn=input('Type what you want it changed to: ')
            while Checker(changeIn).check()==False:
                print('New password does not meet the requirements!')
                changeIn=input('Changed password: ')
            k = int(uI)-1
            //most of this function is copied from the remPass() function but instead of removing, it replaces
            if uI in catDictionary[uCat]:
                indice=int(catDictionary[uCat].index(uI))
                catDictionary[uCat][indice] = str(changeIn)
            elif catDictionary[uCat][k] != "":
                catDictionary[uCat][k] = str(changeIn) 
            else:
                print('Invalid Input')
    }
    //this function makes sure that there are values in what is passed in
    private static Boolean fillCheck(Hashtable<String,String> i){
        if str(i) == "":
            return False
        elif i == {}:
            return False
        elif i == []:
            return False
        else:
            return True
    }
}
