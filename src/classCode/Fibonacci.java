package classCode;

public class Fibonacci {
    public static final int MAX_TERM_VALUE = 35;
    public static void main(String[] args){
        System.out.println("This program lists the Fibonacci sequence.");
        int num1 = 0;
        int num2 = 1;
        System.out.println(num1);
        System.out.println(num2);
        int term = num1 + num2;
        while (term < MAX_TERM_VALUE){
            System.out.println(term);
            num1 = num2;
            num2 = term;
            term = num1 + num2;
        }
    }
}