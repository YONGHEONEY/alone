package algorithm;

import java.util.Scanner;

public class Hundred10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("숫자 입력 : ");
        int num = input.nextInt();
        int numA = 1;

        for(int i=1; i<=num; i++){
            for(int k=1; k<=num; k++){
                System.out.print(numA +" ");
                if(numA % num == 0) {
                    System.out.println();
                }
                numA++;
            }
        }

    }
}
// 입력된 수 만큼 N행 N열의 형태로 출력