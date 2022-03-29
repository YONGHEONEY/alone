package bank;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountApp {
    Scanner sc = new Scanner(System.in);
    // Account 정보를 list 에 담는다.
    ArrayList<Account> list = new ArrayList<Account>();

    // 계좌생성
    public void createAno(){
        System.out.println("새 계좌 생성");
        Account a = new Account();

        System.out.print("계좌 번호 : ");
        a.setAno(sc.nextLine());
        System.out.print("계좌 소유주 :");
        a.setOwner(sc.nextLine());
        System.out.print("입금 금액 : ");
        a.setBalance(sc.nextInt());

        System.out.println(a.toString());
    }

    public void showAno(){

    }

}
