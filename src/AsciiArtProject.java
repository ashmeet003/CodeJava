import java.util.Scanner;
public class AsciiArtProject {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n********************************************");
        System.out.println("            Welcome to ASCII Art            ");
        System.out.println("********************************************\n");

        System.out.println("Menu Shapes:");
        System.out.println("1. triangle\n2. diamond\n3. rectangle\n4. circle");
        System.out.print("Enter your input in format: [shape],[size],[character]: ");
        String inputSen = sc.next().toLowerCase().trim();
        int commaIndex = inputSen.indexOf(",");
        String shape = inputSen.substring(0, commaIndex);
        int size = Integer.parseInt(inputSen.substring(commaIndex + 1, inputSen.indexOf(",", commaIndex + 1)));
        char asciiChar = inputSen.charAt(inputSen.indexOf(",", commaIndex + 1) + 1);

        System.out.println("string: " + shape + "; size: "+ size+ "; char: "+ asciiChar);

        if(shape.equals("triangle")) {
            System.out.println("You chose to print a triangle");
        }
        else if(shape.equals("diamond")) {
            System.out.println("You chose to print a diamond");
        }
        else if(shape.equals("rectangle")) {
            System.out.println("You chose to print a rectangle");
            for(int i = 0; i <size; i++){
                for(int j = 0; j <size; j++){
                    System.out.print(asciiChar);
                }
                System.out.println();
            }
        }
        else if(shape.equals("circle")) {
            System.out.println("You chose to print a circle");
        }
        else{
            System.out.println("Error: You entered an invalid shape or wrong spellings");
        }

        /*while(true){
            if(shape.equals("quit") || shape.equals("q")){
                System.out.println("You chose the exit the program.");
                break;
            }
            else if(!(shape.equals("triangle") || shape.equals("diamond") || shape.equals("rectangle") || shape.equals("circle"))){
                System.out.println("Error: Enter a valid shape or type quit to exit.");
            }
            else{
                System.out.print("Enter the size of the shape:");
                size = sc.nextInt();
                System.out.print("Enter a character you want for art: ");
                asciiChar = sc.next().charAt(0);
            }
        }*/

        System.out.println("Thank you for using the program!!");
        sc.close();

    }
}
