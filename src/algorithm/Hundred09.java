package algorithm;

import java.util.Scanner;

public class Hundred09 {
    public static void main(String[] args) {
        int num = 1242;
        int accSum = 0;
        int store = 0;

        while(num != 0) {
            accSum += num % 10;
            num /= 10;
//            store += accSum;
        }
        System.out.println(accSum);



    }
}
// 입력된 수의 각 자릿수의 합
// 1242 -> 9