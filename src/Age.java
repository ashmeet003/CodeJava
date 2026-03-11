import java.util.Scanner;
public class Age {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int orgAge;         // stores user's original age
        int updatedAge;     // stores dog age (*7 the original age)

        System.out.print("Enter your age: ");
        orgAge = sc.nextInt();
        updatedAge = orgAge * 7;

        System.out.println("Your dog age: " + updatedAge + " years.");
        System.out.println("Your regular age: " + orgAge + " years.");

        sc.close();
    }
}
