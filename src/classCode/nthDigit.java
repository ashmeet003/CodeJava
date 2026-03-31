package classCode;

import java.util.Scanner;
public class nthDigit {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a N value: ");
        int n = sc.nextInt();
        // groups based on 1-9, 10-99, 100-999
       /* int digits = 1;
        long count = 9;
        long start = 1;
        while (n > digits * count) { // finding digit place in a group
            n -= (digits * count);    //subtracts n from max num in a group
            // leads to second group
            digits++;
            count *= 10;
            start *= 10;
        }
        // 10----2g----10-9=1.....1/2=0number==1%2=1= 1digit
        // 15----2g----15-9=6-----6/2=3number==6%2=0=2digit
        // 18----2g----18-9=9-----9/2=4numer===9%2=1..1 digit..14number&1digit
        // 101---3g----101-99=2...
        int number = (int) (start + ((n - 1) / digits)); // finds the number
        int digitIndex = (n - 1) % digits;              // finds the place of digit in number
        */
















        int count = 0;
        int flag = 0;
        for(int i = 1; i <= n; i++){
            if(i>=100000){
                count++;
                if(count == n){
                    flag = i/100000;
                    break;
                }
                count++;
                if(count == n){
                    flag = (i%100000)/10000;
                    break;
                }
                count++;
                if(count == n){
                    flag = (i%10000)/1000;
                    break;
                }
                count++;
                if(count == n){
                    flag = (i%1000)/100;
                    break;
                }
                count++;
                if(count == n){
                    flag = (i%100)/10;
                    break;
                }
                count++;
                if(count == n){
                    flag = i%10;
                    break;
                }
            }
            else if(i>=10000){
                count++;
                if(count == n){
                    flag = i/10000;
                    break;
                }
                count++;
                if(count == n){
                    flag = (i%10000)/1000;
                    break;
                }
                count++;
                if(count == n){
                    flag = (i%1000)/100;
                    break;
                }
                count++;
                if(count == n){
                    flag = (i%100)/10;
                    break;
                }
                count++;
                if(count == n){
                    flag = i%10;
                    break;
                }
            }
            else if(i>=1000){
                count++;
                if(count == n){
                    flag = i/1000;
                    break;
                }
                count++;
                if(count == n){
                    flag = (i%1000)/100;
                    break;
                }
                count++;
                if(count == n){
                    flag = (i%100)/10;
                    break;
                }
                count++;
                if(count == n){
                    flag = i%10;
                    break;
                }
            }
            else if(i>=100){
                count++;
                if(count == n){
                    flag = i/100;
                    break;
                }
                count++;
                if(count == n){
                    flag = (i%100)/10;
                    break;
                }
                count++;
                if(count == n){
                    flag = i%10;
                    break;
                }
            }
            else if(i>=10){
                count++;
                if(count == n){
                    flag = i/10;
                    break;
                }
                count++;
                if(count == n){
                    flag = i%10;
                    break;
                }
            }
            else{
                count +=1;
                if(count == n){
                    flag = i;
                    break;
                }
            }
        }
        System.out.println("Num is :" + flag);
        sc.close();


    }
}
