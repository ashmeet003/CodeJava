import java.util.Scanner;
import java.util.ArrayList;

public class fantasyAdventure {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> inventory = new ArrayList<>();
        int wallet = 300;

    }

    public static int dayInNarnia(Scanner sc, ArrayList<String> inventory, int wallet){
        ;
    }

    public static int mermaidLand(Scanner sc, ArrayList<String> inventory, int wallet){
        ;
    }

    public static int arabianNights(Scanner sc, ArrayList<String> inventory, int wallet){
        ;
    }

    public static int fightBoss(Scanner sc, ArrayList<String> inventory, int wallet){
        ;
    }

    public static int fightMonstors(Scanner sc, ArrayList<String> inventory, int wallet){
        ;
    }

    public static void displayWallet(int wallet){
        System.out.println("\n-------------------------------------------------");
        System.out.println("Amount in your wallet: $" + wallet);
        System.out.println("-------------------------------------------------\n");
    }

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

    public static int addToInventory(Scanner sc, ArrayList<String> inventory, int wallet, String[] horcrux){
        System.out.println("Your options to choose from: ");
        int n = 1;
        for(String hx: horcrux){
            System.out.println(n + ". " + hx);
            n++;
        }
        System.out.println("Enter a number corresponding to an item: ");
        int input = isValidNum(sc, horcrux.length);
        System.out.println("You chose to add " + horcrux[input - 1] + ".");
        if(wallet >= 20){
            wallet -= 20;
            System.out.println(horcrux[input - 1] + " added!");
            displayWallet(wallet);
            displayInventory(inventory);
        }
        else{
            System.out.println("Add item mission aborted!");
            System.out.println("Insufficient funds! Each item costs $20");
            displayWallet(wallet);
        }
        return wallet;
    }

    public static int updateInventory(Scanner sc, ArrayList<String> inventory, int wallet){
        displayInventory(inventory);
        int n = 2;
        while(n > 1) {
            System.out.println("Do you wish to add items to your inventory?");
            n = yesOrNo(sc);
        }
        if(n == 1){
            // add extra items, update inventory, subtract from wallet;
            String[] horcrux = {"LongSword", "Nagamaki", "Uchigatana", "Katana", "AK47", "AUG", "M1934", "M42"};
            wallet = addToInventory(sc, inventory, wallet, horcrux);
        }
        else{ // n == 0
            n = 2;
            while(n > 1) {
                System.out.println("Do you wish to sell items from your inventory?");
                n = yesOrNo(sc);
            }
            if(n==1){
                //sell items, update inventory, add to wallet
                if(inventory.isEmpty()){
                    System.out.println("No item to sell:(");
                    System.out.println("Inventory empty\n");
                }
                else {
                    System.out.println("Choose an item number from inventory to sell.");
                    int input = isValidNum(sc, inventory.size());
                    String removed = inventory.remove(input - 1);
                    wallet += 20;
                    System.out.println(removed + " sold!");
                    displayWallet(wallet);
                    displayInventory(inventory);
                }
            }
        }
        System.out.println("\n-----------------------------------------------");
        System.out.println("Exciting UpdateInventory!");
        System.out.println("-----------------------------------------------\n");
        return wallet;
    }

    public static int yesOrNo(Scanner sc){
        System.out.println("Yes(y) / No(n): ");
        String input = sc.nextLine().trim().toLowerCase();

        if (input.equals("yes") || input.equals("y")) {
            System.out.println("You chose to add items!");
            return 1;
        } else if (input.equals("no") || input.equals("n")) {
            System.out.println("You chose not to add items!");
            return 0;
        } else {
            System.out.println("Invalid input!");
            System.out.println("Try again....\n");
            return 2;
        }
    }

    public static int isValidNum(Scanner sc, int length){
        while(true){
            System.out.println("Enter a number from 1 to " + length);
            String input = sc.nextLine().trim();
            try{
                int option = Integer.parseInt(input);
                if(option >= 1 && option <= length){
                    return option;
                }
                else{
                    System.out.println("Number out of range!\n");
                }
            }
            catch(NumberFormatException e){
                System.out.println("Invalid Input!");
                System.out.println("Enter a number only!\n");
            }
        }
    }
}
