package practice;

import java.util.Arrays;
import java.util.Scanner;

public class GugudanString {
    static Scanner sc = new Scanner(System.in);
    // 입력값 받기
    static String input = sc.nextLine();
    // 입력값 분리
    static String[] SpiltStr = input.split(",");
    static int first = Integer.parseInt(SpiltStr[0]);
    static int second = Integer.parseInt(SpiltStr[1]);

    // 계산 담당 메소드
    public static int[] calc(int time) {
        int[] result = new int[second];

        for(int i=0; i < result.length; i++) {
            result[i] = time * (i+1);
        }
        return result;
    }

    // 출력 메소드
    public static void print(int[] result) {
        for(int i=0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    // 결과값
    public static void main(String[] args) {
        for(int i=2; i<=first; i++) {
            print(GugudanString.calc(i));
        }

    }
}

//사용자가 입력한 값에 따라 크기가 다른 구구단을 계산해 출력한다.
//예를 들어 사용자가 "8,7"과 같은 문자열을 입력하면 팔칠단을 구현한다.
//팔칠단은 2 * 1 ... 2 * 7, 3 * 1 ... 3 * 7, ... , 8 * 1 ... 8 * 7 까지 구현하는 것을 의미한다.
