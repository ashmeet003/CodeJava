package classCode;

public class numberPlay {

    public static double sumOfNumbers(double[] num){
        double sum = 0;
        for(int i = 0; i < num.length; i++){
            sum += num[i];
        }
        return sum;
    }

    public static double avgOfNumbers(double[] num){
        double avg = sumOfNumbers(num) / num.length;
        return avg;
    }

    public static double maxOfNumbers(double[] num){
        double max = num[0];
        for(int i = 0; i < num.length; i++){
            if(num[i] > max){
                max = num[i];
            }
        }
        return max;
    }

    public static void main(String[] args){
        double[] numbers = new double[5];
        numbers[0] = 1.0;
        numbers[1] = 5.0;
        numbers[2] = 5.3;
        numbers[3] = 6.8;
        numbers[4] = 8.8;

        double sum = sumOfNumbers(numbers);
        double avg = avgOfNumbers(numbers);
        double max = maxOfNumbers(numbers);

        System.out.printf("Sum of Numbers: %.2f\n", sum);
        System.out.printf("Average of Numbers: %.2f\n", avg);
        System.out.println("Largest of Numbers: " + max);

    }
}
