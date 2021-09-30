package PLTWJava.Unit1.Assignments;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class FehnTextAdventureR1{
    public static void main(String[] args){
        Scanner ui = new Scanner(System.in);
        System.out.print("Enter you're character's name: ");
        String userName = ui.next();
        List<String> inventory = new ArrayList<>();

        System.out.printf("\nWeird Old Man: \nWelcome to Aurora, %s! \nI see you've never been here before... allow me to show you around.",userName);

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
            System.out.print("Where would you like to go?\n1. Blacksmith\n2. Food Shop\n3. TBA\n4. TBA\n5. Quit\n(Enter numbers or name): ");
            locationChoice = ui.nextLine().toLowerCase();

            //loop for the blacksmith's shop, loop breaks when you buy something or leave
            while (locationChoice.equals("1") || locationChoice.equals("blacksmith")){
                System.out.print("Blacksmith: Welcome to BeeBo\'s Blacksmith Shack!\nWould you like me to make you something? (yes/no): ");
                String bsChoiceOne = ui.nextLine().toLowerCase();
                if (bsChoiceOne.equals("yes")){
                    System.out.print("Blacksmith: What can I make for ya? (one word): ");
                    String bsMake = ui.nextLine().toLowerCase();
                    System.out.printf("\nBlacksmith: A %s huh? I can make that for 20 gold coins.",bsMake);
                    //could've created a procedure for adding items to the inventory but im going to leave it a bit wet
                    //since the math and things added to inventory are different for multiple locations/what you buy
                    coins -= 20;
                    System.out.printf("\nGold Coins Left: %s", coins);
                    inventory.add(bsMake);
                    System.out.printf("\n%s added to inventory.",bsMake);
                    System.out.println("\nInventory:");
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
                            System.out.printf("Coins left: %s",coins);
                            System.out.println("\nSmall Metal Shiv added to inventory.");
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
                            System.out.printf("Coins left: %s",coins);
                            System.out.println("\nLongsword added to inventory.");
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
                            System.out.printf("Coins left: %s",coins);
                            System.out.println("\nGold Inlaid Dagger added to inventory.");
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
                                System.out.println("-1 coin");
                                coins -= 1;
                                System.out.printf("Gold Coins Left: %s", coins);
                                System.out.println("\n5x Apples added to inventory.");
                                System.out.println("Inventory:");
                                for (String i : inventory) {
                                    System.out.println(i);
                                }
                            }
                            else if (fsPicker.contains("2") || fsPicker.contains("orange")){
                                inventory.add("3x Oranges");
                                System.out.println("-1 coin");
                                coins -= 1;
                                System.out.printf("Gold Coins Left: %s", coins);
                                System.out.println("\n3x Oranges added to inventory.");
                                System.out.println("Inventory:");
                                for (String i : inventory) {
                                    System.out.println(i);
                                }
                            }
                            else if (fsPicker.contains("3") || fsPicker.contains("corn")){
                                inventory.add("3x Corn Stock");
                                System.out.println("-1 coin");
                                coins -= 1;
                                System.out.printf("Gold Coins Left: %s", coins);
                                System.out.println("\n3x Corn Stock added to inventory.");
                                System.out.println("Inventory:");
                                for (String i : inventory) {
                                    System.out.println(i);
                                }
                            }
                            else if (fsPicker.contains("4") || fsPicker.contains("banana")){
                                inventory.add("5x Bananas");
                                System.out.println("-1 coin");
                                coins -= 1;
                                System.out.printf("Gold Coins Left: %s", coins);
                                System.out.println("\n5x Bananas added to inventory.");
                                System.out.println("Inventory:");
                                for (String i : inventory) {
                                    System.out.println(i);
                                }
                            }
                            System.out.print("Enter names or numbers (type 'done' when done): ");
                            fsPicker = ui.nextLine();
                        }
                        System.out.println("Bethy: \nThanks for your business!\nI must close up shop now, it's getting pretty late.\nHope to see you again!");
                        System.out.println("You have left the Fruit & Veggie Stop...");
                        break;
                    }
            }
            
            //users can quit anytime they are on the location select screen since there is no technical end to the game
            if (locationChoice.contains("5") || locationChoice.contains("quit")){
                System.out.println("Thank you for playing!");
                break;
            }
            //this is to make sure users enter what I want them to
            else if (!(locationChoice.contains("1") || locationChoice.contains("2") || locationChoice.contains("5") || locationChoice.contains("blacksmith") || locationChoice.contains("food shop"))){
                System.out.println("Please enter a valid input! (Numbers or names of places)");
            }
        }
        ui.close();
    }
}
