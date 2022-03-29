package thisJava;

import java.util.Scanner;

public class BankApplication {
    private static Account[] accountArray = new Account[100];
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true; // flag

        while(run) {
            System.out.print("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
            System.out.print("입력 : ");
            int selectNo = sc.nextInt();

            switch (selectNo) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    accountList();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    withdraw();
                    break;
                case 5:
                    run = false;
            }
        }
        System.out.println("종료합니다.");

    }

    private static void withdraw() {
        System.out.println("=========출금==========");
        System.out.print("계좌 번호 : ");
        String ano = sc.next(); // 찾을 계좌번호 입력
        System.out.print("출금액 : ");
        int money = sc.nextInt(); // 예금할 금액 입력

        Account account = findAccount(ano);
        if(account == null) {
            System.out.println("결과 : 출금계좌가 없습니다.");
            return;
        }
        account.setBalance(account.getBalance()-money) ;
        System.out.println("결과 : 출금이 성공되었습니다.");
    }

    private static void deposit() {
        System.out.println("=========예금==========");
        System.out.print("계좌 번호 : ");
        String ano = sc.next(); // 찾을 계좌번호 입력
        System.out.print("예금액 : ");
        int money = sc.nextInt(); // 예금할 금액 입력

        Account account = findAccount(ano);
        if(account == null) {
            System.out.println("결과 : 출금계좌가 없습니다.");
            return;
        }
        account.setBalance(account.getBalance()+money) ;
        System.out.println("결과 : 입금이 성공되었습니다.");
    }

    // deposit , withdraw 호출해서 이용
    private static Account findAccount(String ano) {
        // !! 핵심 !!
        Account account = null;
        for(int i=0; i< accountArray.length; i++) {
            if(accountArray[i] != null) {
                // 값이 존재하면 존재하는 값을 dbAno 변수에 담아준다.
                String dbAno = accountArray[i].getAno();
                if(dbAno.equals(ano)) {
                    account = accountArray[i];
                    break;
                }
            }
        }
        return account;
    }

    private static void accountList() {
        System.out.println("==========계좌목록=========");
        for (int i = 0; i < accountArray.length; i++) {
            Account account = accountArray[i];
            if (account != null) { // 유효성 검사
                System.out.println(account.toString());
            }
        }
    }

    // 계좌생성
    private static void createAccount() {
        System.out.print("계좌번호 : ");
        String ano = sc.next();
        System.out.print("계좌주 : ");
        String owner = sc.next();
        System.out.print("입금액 : ");
        int balance = sc.nextInt();

        Account newAccount = new Account(ano, owner, balance);
        for (int i = 0; i < accountArray.length; i++) {
            if (accountArray[i] == null) { // 유효성 검사
                accountArray[i] = newAccount;
                System.out.println("결과 : 계좌가 생성되었습니다.");
                break;
            }
        }
    }
}
