package algorithm;

import java.util.Scanner;

public class Hundred08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int factorial = 1;
        int result = 1;
//        for (int i = 1; i <= num; i++) {
//            factorial *= i;
//        }
//        System.out.println(factorial);
        while(factorial <= num) {
            result *= factorial;
            factorial++;
        }
        System.out.println(result);
    }
}
