package algorithm;

import java.util.Scanner;

public class Hundred11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
// 1 2 3 4
// 8 7 6 5
// 9 10 11 12
// 16 15 14 13
        int arr[][] = new int[num][num];

        for (int i = 0; i < num; i++) { // 행

            if (i % 2 == 0) { // 짝수행
                for (int k = 0; k < num; k++) {
                    arr[i][k] = (i * num) + k + 1;
                    // i * num + k + 1
                }

            } else { // 홀수행
                for (int k = num - 1; k >= 0; k--) {
                    arr[i][k] = (i * num) + num - k;
                    // i * num + num - k
                }
            }
        }


        for (int i = 0; i < num; i++) {
            for (int k = 0; k < num; k++) {
                System.out.printf("%4d", arr[i][k]);
            }
            System.out.println();
        }
    }
}
