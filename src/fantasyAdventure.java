/*
Name: Ashmeet Kaur
Project: Fantasy Adventure World.
Welcome to my fantasy world. You get to experience 3 different worlds here.
The peace of forest, the snug of ocean, and the warmth of desert.
Each world will give you options to fight monsters or a boss.
With the amount in your game wallet, you can choose to buy weapons, or sell them if needed.
Each weapon has a level assigned to them, the more you'll collect, the more the level will increase.
Monster or a Boss could be defeated once your weapons reaches their level.

Have Fun!
 */

import java.util.Scanner;
import java.util.ArrayList;

public class fantasyAdventure {
    public static void main(String[] args){                     // main function, introduces the game plot, explains the rules.
        Scanner sc = new Scanner(System.in);                    // Scanner Class
        ArrayList<String> inventory = new ArrayList<>();        // ArrayList stores weapons and its level
        int wallet = 100;                                       // game wallet with initial amount $100

        System.out.println("\n********************************************************************");
        System.out.println("Welcome to fantasy World");
        System.out.println("\nYou can choose a world and begin your adventure");
        System.out.println("World's difficulty increases by its monster's level");
        System.out.println("Narnia is the easiest level, while the Arabian nights is the most difficult.");

        System.out.println("\n-Each monster you kill is worth $50");
        System.out.println("-Each boss you kill is worth $150");
        System.out.println("-Choose a weapon of at least the level to kill that monster.");
        System.out.println("-Each monster kill increases the weapons level increases by 0.5x");
        System.out.println("-Each boss kill increases the weapons level increases by 2x");
        System.out.println("-Else increase your weapon's level by buying them.");
        System.out.println("- Each item is priced at $20. The number next to item shows its level.");

        System.out.println("-----------------------------------------------------------------------------");

        System.out.println("\nHere are your menu option:");
        int flag = menu(sc, inventory, wallet);                             // moves to menu
        if(flag == -1){                                                     // if user chooses to exit, -1 is returned
            System.out.println("You chose to exit the adventure.\n");
        }
        System.out.println("See you again Human:)");                        // program exit.
        System.out.println("********************************************************************\n");
        sc.close();
    }

    // displays main menu till user chooses to exit.
    public static int menu(Scanner sc, ArrayList<String> inventory, int wallet){
        while(true){
            // the menu
            System.out.println("1. A day in Narnia");
            System.out.println("2. A dive in Mermaid Land");
            System.out.println("3. A night in Arabia");
            System.out.println("4. Update Inventory: buy items or sell them");
            System.out.println("5. Display current Inventory");
            System.out.println("6. Display current Wallet amount");
            System.out.println("7. Exit the game");

            int input = isValidNum(sc, 7);                  // validates the user input

            switch(input){                                         // each function is called based on valid user input
                case 1:
                    wallet = dayInNarnia(sc, inventory, wallet);
                    break;
                case 2:
                    wallet = mermaidLand(sc, inventory, wallet);
                    break;
                case 3:
                    wallet = arabianNights(sc, inventory, wallet);
                    break;
                case 4:
                    wallet = updateInventory(sc, inventory, wallet);
                    break;
                case 5:
                    displayInventory(inventory);
                    break;
                case 6:
                    displayWallet(wallet);
                    break;
                case 7:                                                  // if user chooses exit, return -1, else while loop continues.
                    return -1;
                default:
                    System.out.println("Error!");
                    break;
            }
        }
    }

    // introduction to first world
    // A day in Narnia:
    public static int dayInNarnia(Scanner sc, ArrayList<String> inventory, int wallet){
        System.out.println("\n-------------------------------------------------");
        System.out.println("Welcome to Narnia\n");
        System.out.println("- Your first World in the journey.");
        System.out.println("- This is a peaceful forest world.");
        System.out.println("- Birds, animals, and plants work together to balance the system.");
        System.out.println("\n- That doesn't mean we are free of evils.");
        System.out.println("- The night falls and evil plants and animals start to destroy our ecosystem");
        System.out.println("*** Your work? Destroy them. ***");

        System.out.println("Each monster is of level 140");
        System.out.println("And the boss, the giant Venus Fly Trap, is level 500");

        System.out.println("This is your chance to update inventory ");             // lets user update his inventory
        wallet = updateInventory(sc, inventory, wallet);                            // returns updates wallet value

        wallet = monsterOrBoss(sc, inventory, wallet, 140, 500); // lets user choose to fight a monster or a boss
                                                                                      // level of monster and boss is send through function
        System.out.println("-------------------------------------------------\n");
        return wallet;                                                                // returns wallet, to keep it updated
    }

    // Introduction to second world
    // Underwater land of Mermaids:
    public static int mermaidLand(Scanner sc, ArrayList<String> inventory, int wallet){
        System.out.println("\n-------------------------------------------------");
        System.out.println("Welcome to MermaidLand\n");
        System.out.println("- An underWater world filled with happiness and waterMagic.");
        System.out.println("- But since weeks we are suffering because of evil witch!");
        System.out.println("- If you are capable destroy the evil, Human..\n");
        System.out.println("- Each monster here is level 400");
        System.out.println("- The ultimate Boss, the evil witch, is level 1800\n");
        System.out.println("- Are you ready to fight human?");
        System.out.println("- To fight evil, we are blessing you with $100");
        wallet += 100;                                                                  // this level gifts user $100

        System.out.println("This is your chance to update inventory ");                 // lets user update inventory
        wallet = updateInventory(sc, inventory, wallet);                                // stores the updates wallet value

        wallet = monsterOrBoss(sc, inventory, wallet, 400, 1800);  // arguments include level of monster and boss. Updates wallet value is returned
        System.out.println("-------------------------------------------------\n");
        return wallet;                                                                  // updates wallet value is returned from the level
    }

    // Introduction to 3rd world:
    // The Arabian Nights
    public static int arabianNights(Scanner sc, ArrayList<String> inventory, int wallet){
        System.out.println("\n-------------------------------------------------");
        System.out.println("Welcome to Arabian Nights\n");
        System.out.println("Here day is too hot and night is too cold.");
        System.out.println("We hope you are packed properly!!!\n");
        System.out.println("- In this world you'll fight DESERT Monsters!!!!");
        System.out.println("- Haha...They are eager to meet you too!");
        System.out.println("- At the end you'll fight the Ultimate Boss too");
        System.out.println("- We are talking about the great SandWalker!!!!");
        System.out.println("- He is a gargantuan, Nocturnal Crab.\n");
        System.out.println("- You need your weapon to be at least the level 540 to defeat the monsters.");
        System.out.println("- And level 2400 to defeat the Great SandWalker");
        System.out.println("- Haha...Beware of their poison\n");

        System.out.println("This is your chance to update inventory ");                        // lets user update the inventory
        wallet = updateInventory(sc, inventory, wallet);

        wallet = monsterOrBoss(sc, inventory, wallet, 540, 2400);       // arguments include level of monster and boss. wallet value is stored
        System.out.println("-------------------------------------------------\n");
        return wallet;                                                                      // updated wallet value from the level is returned
    }


    // user chooses to fight a monster or a boss
    public static int monsterOrBoss(Scanner sc, ArrayList<String> inventory, int wallet, int monsterLevel, int bossLevel){
        System.out.println("Do you wish to fight monster?");
        int n = yesOrNo(sc);                                                    // logic is based on yesOrNo function
        if(n == 1){                                                             // if user enters yes, fights monsters
            System.out.println("You chose to fight monsters!!");
            wallet = fightMonsters(sc, inventory, wallet, monsterLevel);        // the functions lead to fighting monster and updating wallet
        }
        else{                                                             // if user chooses no to monsters
            System.out.println("You chose not to fight monsters!!");
            System.out.println("Do you wish to fight the Boss?");               // asks if they want to fight Boss
                                                                    // works till user enters either 0 or 1
            n = yesOrNo(sc);
            if(n == 1){                                                         // if user enters yes, fights boss
                System.out.println("You chose to fight the Boss!");
                wallet = fightBoss(sc, inventory, wallet, bossLevel);           // the functions lead to fighting boss and updating wallet
            }
            else{                                                               // if user chooses to quit fighting, returns to main menu
                System.out.println("Returning to menu.....");
            }

        }
        return wallet;                                                          // updated wallet value is returned
    }


    // if user chooses to fight boss
    public static int fightBoss(Scanner sc, ArrayList<String> inventory, int wallet, int bossLevel){
        System.out.println("\n-------------------------------------------------");
        System.out.println("You chose to fight BOSS in this level!");
        System.out.println("You Brave Brave Human!");
        System.out.println("Be ready to fight the ultimate Boss!!");
        System.out.println("Your Ultimate challenge in this World!");
        wallet = chooseAndFight(sc, inventory, wallet, bossLevel, 150);   // directs to function to choose a weapon. Argument involves money to be won if boss is defeated
        System.out.println("\n-------------------------------------------------");
        return wallet;                                                           // updated value of wallet is returned
    }


    // if user chooses to fight monsters
    public static int fightMonsters(Scanner sc, ArrayList<String> inventory, int wallet, int monsterLevel){
        System.out.println("\n-------------------------------------------------");
        System.out.println("You chose to fight monsters in this level!");
        System.out.println("You Brave Human!");
        wallet = chooseAndFight(sc, inventory, wallet, monsterLevel, 50); // directs to function to choose a weapon. Argument involves money to be won if monster is defeated
        System.out.println("\n-------------------------------------------------");
        return wallet;                                                          // updated value of wallet is returned
    }


    // function let user choose a weapon, earn money, and increase weapons level, if the enemy is defeated.
    public static int chooseAndFight(Scanner sc, ArrayList<String> inventory, int wallet, int level, int money){
        System.out.println("Choose a weapon from your inventory to fight:");
        displayInventory(inventory);                                            // displays inventory
        if(inventory.isEmpty()){                                                // if inventory is empty
            System.out.println("Oops! No weapon available.");                   // no fighting allowed
            System.out.println("Buy weapons for your inventory!");
            System.out.println("Returning ....\n");
            return wallet;                                                      // returns with the wallet value
        }
        else{
            System.out.println("Choose a number corresponding to inventory");   // else, a weapon is chosen.
            int input  = isValidNum(sc, inventory.size());                      // validates the user input to not exceed the number of items
            String item = inventory.get(input -1);                              // stores the string value of chosen weapon and its level
            int weaponLevel = Integer.parseInt(item.split(" ")[1]);       // stores the integer part, the level of the weapon.
            if(weaponLevel >= level){                                           // if the level of weapon is at least the level of monster
                System.out.println("You won!!!");                                   // user wins
                System.out.println("Enemy defeated!\n");
                System.out.println("You earned $" + money);
                wallet += money;                                                    // earns money with respect to boss or monster chosen to defeat
                System.out.println("Weapon level increased!!!!");                   // increases weapons level

                if(money == 150){                                                   // 150 is associated with boss
                    // defeated a boss
                    weaponLevel *= 2;                                               // weapon's level increases 2x
                }
                else{                                                               // else, a monster
                    // defeated monster
                    weaponLevel = weaponLevel + (int)(weaponLevel/2);               // increases by half the value of current level
                }
                
                String updatedItem = item.split(" ")[0] + " " + weaponLevel;  // stores the complete updated weapon with its updated level
                inventory.set(input - 1, updatedItem);                              // modifies the inventory with updated data
                System.out.println("Your updated Weapon: " + inventory.get(input -1));

            }
            else{                                                               // if user does not have enough level of weapon to fight
                System.out.println("You lose!");                                    // user loses
                System.out.println("You lose $50");
                wallet -= 50;                                                       // loses $50
                if(wallet < 0){
                    wallet = 0;
                }
                System.out.println("Returning......\n");
            }
            return wallet;                                                      // returns with updated wallet
        }

    }


    // displays current wallet value
    public static void displayWallet(int wallet){
        System.out.println("\n-------------------------------------------------");
        System.out.println("Amount in your wallet: $" + wallet);
        System.out.println("-------------------------------------------------\n");
    }


    // displays the inventory
    public static void displayInventory(ArrayList<String> inventory){
        System.out.println("\n-------------------------------------------------");
        System.out.println("Your Current Inventory: ");
        if(inventory.isEmpty()){
            System.out.println("*** Empty ***");
        }
        else{
            int num = 1;
            for(String i: inventory){
                System.out.println(num + ". " + i);
                num++;
            }
        }
        System.out.println("-------------------------------------------------\n");
    }


    // works to add, update level of weapon based on chosen weapon from array of weapons
    public static int addToInventory(Scanner sc, ArrayList<String> inventory, int wallet, String[] weapons){
        System.out.println("\n-------------------------------------------------");
        System.out.println("Your options to choose from: ");                     // asks user to choose a weapon to add
        int n = 1;
        for(String hx: weapons){                                                // displays the array of weapons
            System.out.println(n + ". " + hx);
            n++;
        }
        System.out.println("Input a number corresponding to an item.");
        int input = isValidNum(sc, weapons.length);                             // validates the input to not exceed array's length
        System.out.println("You chose to add " + weapons[input - 1] + ".");     // shows the item they chose to add
        if(wallet < 20){                                                        // added for safety measure
            System.out.println("\nAdd item mission aborted!");
            System.out.println("Insufficient funds! Each item costs $20");
            displayWallet(wallet);
            return wallet;
        }
        else{                                                       // if wallet has a minimum balance of $20
            wallet -= 20;                                                       // gets deducted, and weapon get added
            if(wallet < 0){                                                     // maintains any negative value at 0;
                wallet = 0;
            }
            System.out.println("Adding " + weapons[input - 1] + " ....");

            String name = weapons[input - 1].split(" ")[0];               // stores the name of the weapon
            int flag = 0;                                                       // to flag if similar name already exists
            for(int i = 0; i < inventory.size(); i++ ){                         // loops through the inventory
                String nameCheck = inventory.get(i).split(" ")[0];        // stores inventory's item's name
                if(name.equals(nameCheck)){                                     // if name matches
                    System.out.println("Weapon level increased!");                              // increases weapons level
                    int newLevel = Integer.parseInt(weapons[input - 1].split(" ")[1]);    // stores the level of weapon from chosen item
                    int initialLevel = Integer.parseInt(inventory.get(i).split(" ")[1]);  // stores the level of weapon from the inventory
                    int updatedLevel = newLevel + initialLevel;                                 // adds both the level
                    String updatedWeapon = name + " " + updatedLevel;                           // updates the string to have the name and updated level
                    inventory.set(i, updatedWeapon);                             // updates the inventory
                    flag = 1;                                                    // flags the weapon as matched
                    break;                                                       // breaks from the for loop
                }
            }

            if (flag == 0){                                                      // if a weapon was not found in inventory
                inventory.add(weapons[input - 1]);                               // adds the weapon
            }
            displayWallet(wallet);                                               // displays the current wallet balance
            displayInventory(inventory);                                         // displays the inventory
        }
        return wallet;                                                           // returns updates wallet
    }


    // lead to add, or sell the weapon
    public static int updateInventory(Scanner sc, ArrayList<String> inventory, int wallet){
        displayInventory(inventory);                                            // displays inventory
                                                                 // loops runs till 1 or 0 is entered
        System.out.println("Do you wish to add items to your inventory?");  // asks if the user wants to buy items
        int n = yesOrNo(sc);                                                    // based on yesOrNo function to validate input
        if(n == 1){                                                             // if user chooses to add item
            System.out.println("You chose to buy item");
            if(wallet < 20){
                System.out.println("\n...Insufficient funds");
            }
            else {
                // add extra items, update inventory, subtract from wallet;
                String[] horcrux = {"FireBall 45", "UltraSonicWaves 40", "PrismRay 45", "ShellFire 40", "AK47 40", "AUG 35", "WaterCannon 55", "PearlBall 35"};
                wallet = addToInventory(sc, inventory, wallet, horcrux);
            }// lead to addToInventory function. Stores updated wallet value
        }
        else{ // n == 0                                                         // if user chooses not to add items
            System.out.println("You chose not to add items!");
                                                              // asks if they want to sel an item, works till user enters yes or no
            System.out.println("Do you wish to sell items from your inventory?");
            n = yesOrNo(sc);
            if(n==1){                                                           // if yes to sell item
                //sell items, update inventory, add to wallet
                if(inventory.isEmpty()){                                        // checks if inventory is empty
                    System.out.println("No item to sell:(");                    // therefore no sale allowed
                    System.out.println("Inventory empty\n");
                }
                else {                                                          // if user possess a weapon
                    System.out.println("Choose an item number from inventory to sell.");
                    displayInventory(inventory);
                    int input = isValidNum(sc, inventory.size());               // asks which weapon to sell from the list
                    String removed = inventory.remove(input - 1);         // removes the item from inventory and stores in variable
                    wallet += 20;                                               // $20 added back to wallet
                    System.out.println(removed + " sold!");
                    displayWallet(wallet);                                      // displays wallet
                    displayInventory(inventory);                                // displays inventory
                }
            }
        }

        System.out.println("Returning to Main Menu.......");
        System.out.println("-----------------------------------------------\n");
        return wallet;                                                          // returns to main menu with updated wallet value
    }


    // works to validate if user entered yes or no
    public static int yesOrNo(Scanner sc){
        while(true) {
            System.out.println("Yes(y) / No(n): ");
            String input = sc.nextLine().trim().toLowerCase();                       // takes the whole line for possibility of different input cases

            if (input.equals("yes") || input.equals("y")) {                          // if yes or y is entered, returns 1
                return 1;
            } else if (input.equals("no") || input.equals("n")) {                    // if no or n is entered, returns 0
                return 0;
            } else {                                                                 // else returns 2
                System.out.println("Invalid input!");
                System.out.println("Try again....\n");
            }
        }
    }


    // works to validate if a number is within range of 1 to n
    // mainly for cases like menu options or for inventory number selection
    public static int isValidNum(Scanner sc, int length){
        while(true){                                                            // works till user enters right input
            System.out.print("Enter a number from 1 to " + length + ": ");
            String input = sc.nextLine().trim();                                // takes the whole line for possibility of use cases
            try{                                                                // uses try and catch block
                int option = Integer.parseInt(input);                           // parses the value
                if(option >= 1 && option <= length){                            // if value is between  1 to length needed
                    return option;                                              // returns the value
                }
                else{                                                           // else, shows error and loop continues
                    System.out.println("Number out of range!\n");
                }
            }
            catch(NumberFormatException e){                                     // if value other than a number is added, shows error, loop continues
                System.out.println("Invalid Input!");
                System.out.println("Enter a number only!\n");
            }
        }
    }
}
