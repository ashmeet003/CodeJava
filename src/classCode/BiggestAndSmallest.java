package classCode;

import java.util.Scanner;
public class BiggestAndSmallest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num;    // stores number of inputs entered
        int max, min;

        System.out.print("Number of numbers? ");
        num = sc.nextInt();
        System.out.print("Number 1: ");
        int testNum = sc.nextInt();
        min = testNum;
        max = testNum;
        for(int i = 1; i < num; i++){
            System.out.print("Number " + (i+1) + ": ");
            testNum = sc.nextInt();
            if(testNum > max){
                max = testNum;
            }
            if(testNum < min){
                min = testNum;
            }
        }

        System.out.println("Biggest = " + max);
        System.out.println("Smallest = " + min);
        sc.close();

    }
}
