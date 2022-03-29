package algorithm;
// 입력된 수가 소수인지 판별
// 13 > 소수입니다.

import java.util.Scanner;

public class Hundred07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자 입력 : ");
        int num = sc.nextInt();

        boolean isPrimeNumber = true; // 플래그표시(유효성검사)

        for(int i=2; i<num-1; i++) {
           if(num % i == 0 ){
               isPrimeNumber = false;
               // 소수 X
           }
        }
        if(isPrimeNumber) {
            System.out.println(num + "소수입니다.");
        } else {
            System.out.println("소수가 아닙니다.");
        }

    }
}
