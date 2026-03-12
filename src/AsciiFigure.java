/*
////////////////\\\\\\\\\\\\\\\\
////////////********\\\\\\\\\\\\
////////****************\\\\\\\\
////************************\\\\
********************************
* (for figSize = 5)*/
public class AsciiFigure {
    public static final int figSize = 5;
    public static void main(String[] args){

        int length = (4*(figSize - 1)) *2;
        for(int i =0; i < figSize; i++){
            int updateValue = 4 * i;
            for(int j = 0; j < length/2 - updateValue; j++){
                System.out.print("/");
            }
            for(int j = 0; j < updateValue*2; j++){
                System.out.print("*");
            }

            for(int j = 0; j < length/2- updateValue; j++){
                System.out.print("\\");
            }
            System.out.println();
        }
    }
}
