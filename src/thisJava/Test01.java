package thisJava;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
       boolean run = true;
       int stuNum = 0;
       int[] scores = null; // scores 배열이 null 기본값으로 지정되어있으니 사용시에는 초기화시켜줘야한다.

       Scanner sc = new Scanner(System.in);

       while(run) {
           System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
           System.out.println("---------------------------------------------------");
           System.out.print("선택 >> ");

           int choice = sc.nextInt();

           if(choice == 1) {
               System.out.print("학생수 : ");
               stuNum = sc.nextInt();
               scores = new int[stuNum]; // ★새로운 배열 생성
           } else if(choice == 2) {
               for(int i=0; i<scores.length; i++){
                   System.out.print("scores["+i+"]>");
                   scores[i] = sc.nextInt();
               }
           } else if(choice == 3) {
               for(int i=0;i<scores.length;i++){
                   System.out.println("scores["+i+"]:"+scores[i]);
               }
           } else if(choice == 4) {
               int sum = 0;
               for(int i=0; i< scores.length; i++) {
                   sum += scores[i];
               }
               System.out.println("총점 :" + sum);
               double avg = sum / scores.length;
               System.out.println("평균 :" + avg);
           } else if(choice == 5) {
               run = false;
           }
       }
        System.out.println("종료.");
    }
}
