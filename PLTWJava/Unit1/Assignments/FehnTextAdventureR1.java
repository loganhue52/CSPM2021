package PLTWJava.Unit1.Assignments;
import java.util.Scanner;
import java.util.ArrayList;

public class FehnTextAdventureR1{
    public static void main(String[] args){
        Scanner ui = new Scanner(System.in);
        System.out.print("Enter you're character's name: ");
        String userName = ui.next();
        String inventory[];

        System.out.printf("\nWeird Old Man: \nWelcome to Aurora, %f! \nI see you've never been here before... allow me to show you around.",userName);

        System.out.println("\nWeird Old Man: \nOver there (as he points to the left) is the blacksmith. \nThere, you can buy swords, knives, custom-made armor, and even shields!");
        System.out.println("Across from the blacksmith is the food store, they always have fresh fruits. ");
        System.out.println("Down the street a ways you can find the Inn, I hear they have a few rooms open for cheap! ");
        System.out.println("Behind the Inn is a horse breeder. Be weary however, his horses are known for being a bit... faulty. ");
        System.out.println("Here\'s 100 gold coins as a token of apprieciation. I must go now, have a good time!");

        int coins = 100;
        String locationChoice = "";
        //this loop will be running for the entire time the program is running
        //acts as a "main menu" kind of thing
        while (!(locationChoice.equals("quit") || locationChoice.equals("5"))){
            System.out.print("Where would you like to go?\n1. Blacksmith\n2. Food Shop\n3. Inn\n4. Horse Breeder\n5. Quit\n(Enter numbers or name): ");
            String locationChoice = ui.nextLine().toLowerCase();

            //loop for the blacksmith's shop, loop breaks when you buy something or leave
            while (locationChoice.equals("1") || locationChoice.equals("blacksmith")){
                System.out.print("Blacksmith: Welcome to BeeBo\'s Blacksmith Shack!\nWould you like me to make you something? (yes/no): ");
                String bsChoiceOne = ui.nextLine().toLowerCase();
                if (bsChoiceOne.equals("yes")){
                    System.out.print("Blacksmith: What can I make for ya? (one word): ");
                    String bsMake = ui.nextLine().toLowerCase();
                    System.out.printf("\nBlacksmith: A %f huh? I can make that for 20 gold coins.",bsMake);
                    //could've created a procedure for adding items to the inventory but im going to leave it a bit wet
                    //since the math and things added to inventory are different for multiple locations/what you buy
                    coins -= 20;
                    System.out.printf("\nGold Coins Left: ", coins);
                    inventory.add(bsMake);
                    System.out.printf("\n%f added to inventory.",bsMake);
                    System.out.println("Inventory:");
                    for (String i : inventory) {
                        System.out.println(i);
                      }
                    System.out.println("You have left BeeBo's...");
                    break;
                }
                else if (bsChoiceOne.equals("no")){
                    System.out.println("Blacksmith: No? Alrighty then, take a look at my current stock instead.\n1. Small Metal Shiv (10 gold coins)\n2. Longsword (25 gold coins)\n3. Gold Inlaid Dagger (30 gold coins)");
                    System.out.print("Blacksmith: You want one? (yes/no): ");
                    String bsChoiceTwo = ui.nextLine().toLowerCase();
                    if (bsChoiceTwo.equals("yes")){
                        System.out.print("\nBlacksmith: Which one would you like? (numbers): ");
                        String bsChoiceThree = ui.nextLine();
                        if (bsChoiceThree.equals("1")){
                            inventory.add("Small Metal Shiv");
                            coins -= 10;
                            System.out.println("-10 coins");
                            System.out.printf("Coins left: %f",coins);
                            System.out.println("Small Metal Shiv added to inventory.");
                            System.out.println("Inventory:");
                            for (String i : inventory) {
                                System.out.println(i);
                            }
                            System.out.println("You have left BeeBo's...");
                            break;
                        }
                        else if (bsChoiceThree.equals("2")){
                            inventory.add("Longsword");
                            coins -= 25;
                            System.out.println("-10 coins");
                            System.out.printf("Coins left: %f",coins);
                            System.out.println("Longsword added to inventory.");
                            System.out.println("Inventory:");
                            for (String i : inventory) {
                                System.out.println(i);
                            }
                            System.out.println("You have left BeeBo's...");
                            break;
                        }
                        else if (bsChoiceThree.equals("3")){
                            inventory.add("Gold Inlaid Dagger");
                            coins -= 30;
                            System.out.println("-30 coins");
                            System.out.printf("Coins left: %f",coins);
                            System.out.println("Longsword added to inventory.");
                            System.out.println("Inventory:");
                            for (String i : inventory) {
                                System.out.println(i);
                            }
                            System.out.println("You have left BeeBo's...");
                            break;
                        }
                    }
                    else if (bsChoiceTwo.equals("no")){
                        System.out.println("Blacksmith: Alrighty then... see ya around!");
                        System.out.println("You have left BeeBo's...");
                        break;
                    }
                }
            }
            while (locationChoice.equals("2") || locationChoice.equals("food shop")){
                    System.out.println("Bethy: Hello young man! Welcome to Bethy's Fruit & Veggie Stop!\nIn stock today we have:\n1. Apples (5 for 1 gold)\n2. Oranges (3 for 1 gold)\n3. Corn Stocks (3 for 1 gold)\n4. Bananas (5 for 1 gold)");
                    System.out.print("Would you like to buy something? (yes/no): ");
                    String fsChoiceOne = ui.nextLine().toLowerCase();
                    if (fsChoiceOne.equals("no")){
                        System.out.println("Bethy: Alrighty then, I've got to close up shop, it's getting pretty late around here.\nHope to see you again!");
                        System.out.println("You have left the Fruit & Veggie Stop...");
                        break;
                    }
                    else if (fsChoiceOne.equals("yes")){
                        String fsPicker = "";
                        while (!(fsPicker.equals("done"))){
                            if (fsPicker.contains("1") || fsPicker.contains("apple")){
                                inventory.add("5x Apples");
                                Sistem.out.println("-1 coin");
                                coins -= 1;
                                System.out.printf("Gold Coins Left: ", coins);
                                System.out.println("\n5x Apples added to inventory.");
                                System.out.println("Inventory:");
                                for (String i : inventory) {
                                    System.out.println(i);
                                }
                            }
                            elif "2" in fsPicker or "orange" in fsPicker:
                                inventory.append("3x Oranges")
                                print('-1 coin')
                                coins -= 1
                                print('Gold Coins Left: ', coins)
                                print('3x Oranges added to inventory.')
                                print('Inventory: ')
                                for j in inventory:
                                    print(j)
                            elif "3" in fsPicker or "corn" in fsPicker:
                                inventory.append("3x Corn Stock")
                                print('-1 coin')
                                coins -= 1
                                print('Gold Coins Left: ', coins)
                                print('3x Corn Stock added to inventory.')
                                print('Inventory: ')
                                for j in inventory:
                                    print(j)
                            elif "4" in fsPicker or "banana" in fsPicker:
                                inventory.append("5x Bananas")
                                print('-1 coin')
                                coins -= 1
                                print('Gold Coins Left: ', coins)
                                print('5x Bananas added to inventory.')
                                print('Inventory: ')
                                for j in inventory:
                                    print(j)
                            fsPicker = input('Enter names or numbers (type "done" when done): ').lower()
                            print('''
                            Bethy: "Thanks for your business!
                                    I must close up shop now, it\'s getting pretty late.
                                    Hope to see you again!
                            ''')
                            print('''
                            You have left the Fruit & Veggie Stop...
                            ''')
                            break
                        }
                    }
            }
            while locationChoice == "3" or locationChoice == "inn":
                    print('''
                    Hotel Clerk: "Howdy Stra...
                                Wait a second... are you the new one in town?
                    ''')
                    htChoiceOne = input('(yes/no): ').lower()
                    if htChoiceOne == "yes":
                        print('''
                        Hotel Clerk: "Ah yes! I thought so.
                                    50% discount for you my friend!"
                        ''')
                        buyRoom = input('"You lookin\' to buy a room? Only 3 gold coins per night!" (yes/no): ')
                        if buyRoom == "yes":
                            nights = int(input("How many nights you stayin\'? (numbers): "))
                            #had to do a conditional here so that the grammar was right if they only wanted 1 night as opposed to multiple
                            if nights == "1":
                                print('''
                                Hotel Clerk: "Only {} huh? That'll be 3 gold coins.
                                            Your room is just to the left."
                                '''.format(nights))
                                print('-3 coins')
                                coins -= 3
                                print('Gold Coins Left: ', coins)
                                print('Room key added to inventory.')
                                inventory.append("Room Key")
                                print('Inventory: ')
                                for j in inventory:
                                    print(j)
                                userLeave = input('You are now in your room. Type "leave" to leave. ').lower()
                                if userLeave == "leave":
                                    print('You have left the Inn...')
                                    break
                            else:
                                htotal = nights*3
                                print('''
                                Hotel Clerk: "{0} nights? That'll be {1} gold coins.
                                            Your room is just to the left."
                                '''.format(nights,htotal))
                                print('-{0} coins'.format(htotal))
                                coins -= htotal
                                print('Gold Coins Left: ', coins)
                                print('Room key added to inventory.')
                                inventory.append("Room Key")
                                print('Inventory: ')
                                for j in inventory:
                                    print(j)
                                userLeave = input('You are now in your room. Type "leave" to leave. ').lower()
                                if userLeave == "leave":
                                    print('You have left the Inn...')
                                    break
                        elif buyRoom == "no":
                            print('"Alrighty then..."')
                            print('You have left the Inn...')
                            break
                    if htChoiceOne == "no":
                        print('''
                        Hotal Clerk: "Ah nevermind..
                        ''')
                        buyRoom = input('"You lookin\' to buy a room? It\'s 6 gold coins per night." (yes/no): ')
                        if buyRoom == "yes":
                            nights = int(input("How many nights you stayin\'? (numbers): "))
                            if nights == "1":
                                print('''
                                Hotel Clerk: "Only {} huh? That'll be 6 gold coins.
                                            Your room is just to the left."
                                '''.format(nights))
                                print('-6 coins')
                                coins -= 6
                                print('Gold Coins Left: ', coins)
                                print('Room key added to inventory.')
                                inventory.append("Room Key")
                                print('Inventory: ')
                                for j in inventory:
                                    print(j)
                                userLeave = input('You are now in your room. Type "leave" to leave. ').lower()
                                if userLeave == "leave":
                                    print('You have left the Inn...')
                                    break
                            else:
                                htotal = nights*6
                                print('''
                                Hotel Clerk: "{0} nights? That'll be {1} gold coins.
                                            Your room is just to the left."
                                '''.format(nights,htotal))
                                print('-{0} coins'.format(htotal))
                                coins -= htotal
                                print('Gold Coins Left: ', coins)
                                print('Room key added to inventory.')
                                inventory.append("Room Key")
                                print('Inventory: ')
                                for j in inventory:
                                    print(j)
                                userLeave = input('You are now in your room. Type "leave" to leave. ').lower()
                                if userLeave == "leave":
                                    print('You have left the Inn...')
                                    break
            while locationChoice == "4" or locationChoice == "horse breeder":
                    print('''
                    The horse breeder's shack is closed...
                    The lights are off but someone is inside...
                    ''')
                    knockChoice = input('Knock? (yes/no): ').lower()
                    if knockChoice == "yes":
                        print('''
                        Drunken man with a slur: "Go aWay, i\'M clOsed!!!"
                        ''')
                        print('You proceed to walk away...')
                        break
                    if knockChoice == "no":
                        print('''
                        You proceed to walk away...
                        ''')
                        break
            #users can quit anytime they are on the location select screen since there is no technical end to the game
            if locationChoice == "5" or locationChoice == "quit":
                print('''
                    Thank you for playing!
                ''')
                break
            #this is to make sure users enter what I want them to
            elif locationChoice != ("1" or "2" or "3" or "4" or "5" or "blacksmith" or "food shop" or "inn" or "horse breeder" or "quit"): 
                print('Please enter a valid input! (Numbers or names of places)')
                ui.close();
        }
    }
}
