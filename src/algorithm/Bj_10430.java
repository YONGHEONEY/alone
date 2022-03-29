package algorithm;

import java.util.Scanner;

public class Bj_10430 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("3개의 정수 입력 : ");
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int cal01 = (A+B)%C;
        int cal02 = ((A%C)+(B%C))%C;
        int cal03 = (A*B)%C;
        int cal04 = ((A%C)*(B%C))%C;
        System.out.print(A + " " + B + " " + C+"\n");
        System.out.println(cal01);
        System.out.println(cal02);
        System.out.println(cal03);
        System.out.println(cal04);
    }
}
//    첫째 줄에 (A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C, 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.
//
//        예제 입력 1
//        5 8 4
//        예제 출력 1
//        1
//        1
//        0
//        0