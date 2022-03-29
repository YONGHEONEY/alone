package algorithm;

import java.util.Scanner;

public class Hundred12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int arr[][] = new int[num][num];
        // 1 5 9 13
        // 2 6 10 14
        // 3 7 11 15
        // 4 8 12 16

        for(int i=0; i<num; i++) {
            if(i % 2 == 0) {
                for (int k = 0; k < num; k++) {
                    arr[i][k] = (i * num) + k + 1;
                    // i * num + k + 1
                }
            } else {

            }
        }

        for(int i=0; i<num; i++){
            for(int k=0; k<num; k++){
                System.out.printf("%4d", arr[i][k]);
            }
            System.out.println();
        }

    }
}
