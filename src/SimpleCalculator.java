/*
Ashmeet Kaur
COMPB11
Performs addition, subtraction, multiplication, division, exponents, and roots
handles doubles and integers.
*** Program assumes that user entered only numbers. ***
*/

import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean running = true;     // to keep the program going, till user chooses to exit

        System.out.println("\n************************************************************************");
        System.out.println("********************* Welcome to Simple Calculator *********************");
        System.out.println("************************************************************************\n");

        while(running) {
            System.out.println("\nMenu:");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Exponent (^)");
            System.out.println("6. Square root");
            System.out.println("7. Exit from the program");
            System.out.println("\nEnter a number (1-7) from options above:");
            int option;
            if(sc.hasNextInt()){            // checks if valid integer is entered
                option = sc.nextInt();      // if yes, stores the integer form into option variable
            }
            else{                           // if invalid integer !(0-9) is entered
                System.out.println("Invalid value entered");
                System.out.println("--------------------------------------------");
                sc.next();                  // frees the input object
                continue;                   // continues the program
            }

            if (option >=1 && option <=5){
                System.out.println("Enter the first number:");
                double num1;                // first operand
                if(sc.hasNextDouble()){     // checks for valid integer/double value
                    num1 = sc.nextDouble(); // stores value into num1
                }
                else{
                    System.out.println("Invalid value entered.");
                    System.out.println("--------------------------------------------");
                    sc.next();              // clears the input stream
                    continue;               // continues the program, from start
                }
                System.out.println("Enter the second number: ");
                double num2;                // second operand
                if(sc.hasNextDouble()){
                    num2 = sc.nextDouble();
                }
                else{
                    System.out.println("Invalid value entered.");
                    System.out.println("--------------------------------------------");
                    sc.next();
                    continue;
                }
                double result;                          // stores result of operation
                System.out.println("\n--------------------------------------------");

                switch(option){
                    case 1:     // addition
                        result = num1 + num2;
                        System.out.println(num1 + " + " + num2 + " = " + result);
                        break;
                    case 2:     // subtraction
                        result = num1 - num2;
                        System.out.println(num1 + " - " + num2 + " = " + result);
                        break;
                    case 3:     // multiplication
                        result = num1 * num2;
                        System.out.println(num1 + " * " + num2 + " = " + result);
                        break;
                    case 4:     // division
                        if (num2 == 0){
                            System.out.println("Error: Cannot divide by 0");
                        }
                        else{
                            result = num1 / num2;
                            System.out.println(num1 + " / " + num2 + " = " + result);
                        }
                        break;
                    case 5:     // exponent
                        result = Math.pow(num1, num2);
                        System.out.println(num1 + " ^ " + num2 + " = " + result);
                        break;
                    default:
                        System.out.println("Error detected");
                        break;
                }
                System.out.println("--------------------------------------------");

            }
            else if (option == 6){              // option for square root; since it uses one operand
                System.out.println("Enter a number to find its square root: ");
                double num;  // stores number to be operated upon
                if(sc.hasNextDouble()){
                    num = sc.nextDouble();
                }
                else{
                    System.out.println("Invalid value entered.");
                    System.out.println("--------------------------------------------");
                    sc.next();
                    continue;
                }

                if(num < 0){                   // checks for negative number
                    System.out.println("Error: Square root of negative number is not allowed.");
                    System.out.println("--------------------------------------------");
                }
                else{
                    double sqrRootNum = Math.sqrt(num);
                    System.out.println("\n--------------------------------------------");
                    System.out.println("Square root of "+ num + " is: "+ sqrRootNum);
                    System.out.println("--------------------------------------------");
                }
            }
            else if (option == 7){          // option to exit program
                running = false;
            }
            else{                           // if option other than 1-7 is entered
                System.out.println("Error: Invalid Option Entered!");
                System.out.println("Try again.");
                System.out.println("--------------------------------------------\n");
            }
        }

        // program exit
        System.out.println("\n************************************************************************");
        System.out.println("You chose to exit program!");
        System.out.println("Thank you for using Simple Calculator!");
        System.out.println("************************************************************************");


    }
}
