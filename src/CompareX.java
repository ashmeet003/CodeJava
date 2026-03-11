import java.util.Scanner;
public class CompareX {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x;      // stores input value from user

        System.out.print("Enter a value for x: ");
        x = sc.nextInt();

        if(x > 10){
            System.out.println("x is greater than 10.");
        }
        else if(x < 10){
            System.out.println("x is less than 10.");
        }
        else{
            System.out.println("x is equal to 10.");
        }

        sc.close();
    }
}
