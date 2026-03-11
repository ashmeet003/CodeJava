/*
* Program takes one integer input from user and use the value to create a filled rectangle shape.
* Since they are no spaces used, it end results in a rectangle shape.
* The result for shapeSize = 4:
* ####
* ####
* ####
* ####
* */
import java.util.Scanner;
public class Rectangle {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int shapeSize = 0;

        System.out.print("Enter a side value for rectangle: ");
        shapeSize = sc.nextInt();
        for(int i = 0; i < shapeSize; i++){
            for(int j = 0; j < shapeSize; j++){
                System.out.print("#");
            }
            System.out.println();
        }
        sc.close();
    }
}
