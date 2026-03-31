package classCode;

import java.util.Scanner;
public class SquareDouble {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double num = 0.0;       // stores input value
        double sqrNum = 0.0;    // store square of input value

        System.out.print("Enter a number to square: ");
        num = sc.nextDouble();
        sqrNum = Math.pow(num, 2);

        System.out.println("Square of " + num + " is: " + sqrNum);
        sc.close();
    }
}
