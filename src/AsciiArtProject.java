/*
* Name: Ashmeet Kaur
* Student ID: 00889414
*
* This program works on input based on format ""[shapeName],[size],[asciiChar]"
* The program prints:
* => a triangle and diamond based on even and odd number of size
* => a rectangle based on [size]*[size]
* => A circle
* => And a home with two trees and a lawn.
* */

import java.util.Scanner;
public class AsciiArtProject {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("\n********************************************");
        System.out.println("            Welcome to ASCII Art            ");
        System.out.println("********************************************\n");

        // introductory menu:
        System.out.println("Menu Shapes:");
        System.out.println("1. triangle\n2. diamond\n3. rectangle\n4. circle\n5. home");
        String shape;               // stores shape name
        int size;                   // stores size
        char asciiChar;             // character chosen to print

        while(true){                // Will continue till user enters valid format
            boolean flag = true;    // to check for size being a valid number
            System.out.print("Enter your input in format: [shape],[size],[character]: ");
            String inputSen = sc.nextLine().toLowerCase().trim();               // stores input

            int commaIndex = inputSen.indexOf(",");                         // checks for first ',' as delimiter
            if(commaIndex == -1){                                           // if first comma is not found
                System.out.println("Error: Incorrect input format. Use ',' to separate values\n");
                continue;
            }

            shape = inputSen.substring(0, commaIndex);                      // stores shape

            int secondCommaIndex = inputSen.indexOf(",", commaIndex + 1);   // checks for second ','
            if(secondCommaIndex == -1){
                System.out.println("Error: Incorrect input format. Use ',' to separate values\n");
                continue;
            }

            String sizeTemp = inputSen.substring(commaIndex + 1, secondCommaIndex);       // stores string number from input
            for(int i = 0; i < sizeTemp.length(); i++){                                   // checks if substring is only a number
                if(!Character.isDigit(sizeTemp.charAt(i))){
                    System.out.println("Error: [size] should only be a positive number without extra characters.");
                    System.out.println("Try again:\n");
                    flag = false;
                    break;
                }
            }
            if(flag){                                   // if string is a number only
                size = Integer.parseInt(sizeTemp);      // string parses to integer
            }
            else{
                System.out.println("Error: Number not found. Enter correct input format.\n");
                continue;                               // else while loop continues
            }
            asciiChar = inputSen.charAt(inputSen.indexOf(",", commaIndex + 1) + 1);     // stores first character to print
            break;                                      // ends loop if everything was correct
        }


        System.out.println("\nInput Entered=> shape: " + shape + "; size: "+ size+ "; char: "+ asciiChar);
        System.out.println();


        // main program starts:
        // first if works for both triangle and diamond
        // since first half of diamond is same as triangle
        // Odd number of size makes a triangle without spaces
        // Even number makes a triangle with gaps for a proper centered triangle
        if(shape.equals("triangle") || shape.equals("diamond")) {
            if(shape.equals("triangle")){
                System.out.println("You chose to print a triangle");
            }
            else{
                System.out.println("You chose to print a diamond");
            }

            // for odd number
            if(size%2!=0){
                int height=(size+1)/2;                      // stores length of triangle
                int base = height;                          // stores base width of triangle
                int charPrintIndex = height;                // stores the center point for top character
                for(int i = 0; i < height; i++){            // for number of rows
                    for(int j = 1; j <= base; j++){         // for number of columns
                        if(j >= charPrintIndex){            // marks the point where character printing starts
                            System.out.print(asciiChar);
                        }
                        else{                               // rest of indexes get a " "
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                    base++;                                 // width increases (number of characters increases) with each row
                    charPrintIndex--;                       // point for printing gets pushed left with each row.
                }

                if(shape.equals("diamond")){                // works for diamond's lower half
                    height = (size - 1) / 2;                // height is same as triangle with one less row (since already printed with above statements)
                    base = size - 1;                        // starting base is 1 less than center of diamond (next line to center)
                    charPrintIndex = 2;                     // point to print starts with one space and at 2nd index
                    for(int i = 0; i < height; i++){        // number of rows
                        for(int j = 1; j <= base; j++){     // number of columns
                            if(j >= charPrintIndex){        // marks the point where character printing starts
                                System.out.print(asciiChar);
                            }
                            else{                           // rest of indexes get a " "
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                        base--;                             // width decreases (number of characters decreases) with each row
                        charPrintIndex++;                   // point for printing gets pushed right with each row.
                    }
                }
            }
            // works for even number of size:
            else{
                int charIndex = size;                       // stores the center point for top character
                int base = size;                            // stores base width of triangle
                for(int i = 0; i < size; i++){              // number of rows
                    int checkEvenSpace = 1;                 // checks for gaps between characters (since char is printed first, space gets even place)
                    for(int j = 1; j <= base; j++){         // number of columns
                        if(j >= charIndex){                 // marks checkpoint to start printing characters
                            if(checkEvenSpace % 2 == 0){    // if characters getting printed are at even count, space gets printed
                                System.out.print(" ");
                                checkEvenSpace++;           // count increments
                            }
                            else{                           // all odd number of prints uses the character entered
                                System.out.print(asciiChar);
                                checkEvenSpace++;           // count continues
                            }
                        }
                        else{
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                    base++;                                 // width increases (number of characters increases) with each row
                    charIndex--;                            // point for printing gets pushed left with each row.
                }


                if(shape.equals("diamond")){                // works for lower half of diamond
                    charIndex = 2;                          // point to print starts with one space and at 2nd index
                    base = (2 * size) - 1;                  // base has double the characters due to gap between printed characters
                    for(int i = 0; i < size - 1; i++) {     // number of rows
                        int checkEvenSpace = 1;             // counts characters getting printed, to check for gaps to be inserted
                        for (int j = 1; j <= base; j++) {   // number of rows
                            if (j >= charIndex) {           // marks checkpoint to start printing characters
                                if(checkEvenSpace % 2 == 0){// if characters getting printed are at even count, space gets printed
                                    System.out.print(" ");
                                    checkEvenSpace++;       // count continues
                                }
                                else {                      // else character entered gets printed
                                    System.out.print(asciiChar);
                                    checkEvenSpace++;       // count continues
                                }

                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                        base--;                              // width decreases (number of characters decreases) with each row
                        charIndex++;                         // point for printing gets pushed right with each row.
                    }
                }
            }
        }


        // works to print rectangle
        else if(shape.equals("rectangle")) {
            System.out.println("You chose to print a rectangle");
            for(int i = 0; i <size; i++){                   // number of rows
                for(int j = 0; j <size; j++){               // number of columns
                    System.out.print(asciiChar);            // prints characters
                }
                System.out.println();                       // next line
            }
        }


        // works to print circle
        // prints upper two lines with two fewer characters each side
        // prints one diameter
        // prints lower two lines with two fewer characters each side
        // the logic gives circle-oval finish
        else if(shape.equals("circle")) {
            System.out.println("You chose to print a circle");

            // prints upper half of circle
            int base = size - 1;                        // top line has total (diameter - 4) characters
            int asciiPrintIndex = 3;                    // printing starts at 3 character for top line
            for(int i = 0; i < 2; i++){                 // upper two lines of circle
                for(int j = 1; j <= base; j++){         // number of columns
                    if(j >= asciiPrintIndex){           // marks the printing point
                        System.out.print(asciiChar);
                    }
                    else{                               // else prints spaces if the mark is not reached yet.
                        System.out.print(" ");
                    }
                }
                System.out.println();
                base+=2;                                // characters increases by two on each side.
                asciiPrintIndex-=2;                     // printing point shifts two places to the left
            }
            // prints the middle diameter
            for(int i = 0; i <= size; i++){
                System.out.print(asciiChar);
            }
            System.out.println();
            // prints the lower two lines of circle
            base = size + 1;                            // base starts with the size of diameter
            asciiPrintIndex = 1;                        // printing point is the starting point for lower half
            for(int i = 0; i < 2; i++){                 // number of rows = 2
                for(int j = 1; j <= base; j++){         // number of columns
                    if(j >= asciiPrintIndex){           // marking point to print
                        System.out.print(asciiChar);
                    }
                    else{
                        System.out.print(" ");          // else prints spaces if the mark is not reached yet.
                    }
                }
                System.out.println();
                base-=2;                                // characters decreases by two on each side.
                asciiPrintIndex+=2;                     // printing point shifts two places to the right
            }
        }


        // Surprise option for a home:
        else if(shape.equals("home")){
            System.out.println("\nYou chose to print a vintage house!!");
            System.out.println("----------------------------------------------------------------------------------------\n");

            int top=size;                                       // marks the top of the roof length
                                                                // all other measurements are based on roof's top

            // roof
            // The roof has fixed 3 rows
            // with each row having two more characters on each side
            int asciiPrintIndex = 5;                            // printing point starts as point 5
            for(int i = 0; i < 3; i++){                         // number of rows = 3;
                for(int j = 1; j <= top + 5; j++){              // number columns = top row size + 4 extra columns (2 extra added with extra each row)
                    if(j >= asciiPrintIndex){                   // checkpoint to start printing
                        System.out.print(asciiChar);
                    }
                    else{                                       // else " " fills the gaps
                        System.out.print(" ");
                    }
                }
                System.out.println();
                top+=2;                                         // two columns gets added
                asciiPrintIndex-=2;                             // checkpoint to print decreases by 2
            }

            // top space and tree's leaves
            int base = 5;                                       // for the tree's part, base of tree = 5 units
            int charPrintIndex = 5;                             // check point to print = 5, with respect to the wall's boundary
            int count = 0;                                      // keeps track of space between trees from top to bottom (space decreases)

            // for house
            for(int i = 0; i < 3; i++){                         // number of rows; just some extra space between door's top and roof
                for(int j = 0; j < top + 1; j++){               // number of columns used = 2 more on each side with respect to top of roof
                    if(j == 2 || j == top){                     // check for two outer lines of walls
                        System.out.print(asciiChar);
                    }
                    else{                                       // fills inner space with " "
                        System.out.print(" ");
                    }
                }
                // for leaves                                   // leaves in the same row
                int n = 2;
                while(n > 0){                                   // because we are printing 2 trees
                    for(int j = 1; j <= base; j++){             // trees are based on centered triangles
                        if(j >= charPrintIndex){
                            System.out.print(asciiChar);        // leaves gets printed
                        }
                        else{
                            System.out.print(" ");              // else space
                        }
                    }
                    for(int j = 0; j < n - count; j++){         // tracks space between two trees. Decreases from top to bottom
                        System.out.print(" ");
                    }
                    n--;                                        // for while loop to end

                }
                count++;                                        // factor by which space decreases with each row
                base++;                                         // columns in a tree increases with each row
                charPrintIndex--;                               // printing point shifts to left with each row
                System.out.println();
            }

            // for bottom house, door, and tree trunk
            int median = (size + 6) / 2;                        // middle point to print door
            for(int i = 0; i < 3; i++){                         // lower half of house; number of rows
                for(int j = 0; j < top + 13; j++){              // columns continue to include trees' width
                    if(j == 2 || j == top || (j>=median-1 && j<=median+2) || j == top + 5 || j == top + 12){
                        System.out.print(asciiChar);            // points for wall, door, and trees' trunks
                    }
                    else{
                        System.out.print(" ");                  // fills extra points with " "
                    }
                }
                System.out.println();
            }

            // for house's floor
            for(int i = 0; i < size + 7; i++){                  // floor of the house = space between two walls
                if(i >= 2){
                    System.out.print(asciiChar);
                }
                else{
                    System.out.print(" ");
                }

            }
            System.out.println();

            // for lawn
            for(int i = 0;i < 5;i++){                           // number of rows
                for(int j =0;j< top;j++){                       // number of columns
                    System.out.print("v`");                     // characters suiting a grass view
                }
                System.out.println();
            }
            System.out.println("\n\n----------------------------------------------------------------------------------------\n");

        }
        else{                                                    // if user enters invalid string for shape
            System.out.println("Error: You entered an invalid shape or wrong spellings");
        }


        System.out.println("\n\nThank you for using the program!!");
        System.out.println("*******************************************************************************************************");
        sc.close();
        // program ends

    }
}
