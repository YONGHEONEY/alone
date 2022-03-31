package practice;

import java.util.Scanner;

public class GugudanExam {

    static Scanner sc = new Scanner(System.in);
    // 배열의 크기 및 구구단 출력 지정
    static int time = sc.nextInt();

    // 계산 메소드
    public static int[] result(int num) {
        int[] result = new int[time];

        for(int i=0; i < result.length; i++) {
            result[i] = num * (i+1);
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

    public static void main(String[] args) {

        // 실행
        for(int i=2; i<=time; i++) {
            int result[] = GugudanExam.result(i);
            GugudanExam.print(result);
        }
    }
}


//사용자가 입력한 값에 따라 크기가 다른 구구단을 계산해 출력한다.
//예를 들어 사용자가 8을 입력하면 팔팔단,
//19를 입력하면 십구십구단(2 * 1에서 19 * 19)을 계산해 출력한다.
//이 요구사항은 앞의 실습을 소화했으면 구현할 수 있기 때문에 생략한다