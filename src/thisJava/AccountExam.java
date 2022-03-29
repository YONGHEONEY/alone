package thisJava;

public class AccountExam {

    public static void main(String[] args) {
        Account01 account = new Account01();

        account.setBalance(10000);
        System.out.println("현재잔고 : " + account.getBalance());

        account.setBalance(-100);
        System.out.println("현재잔고 : " + account.getBalance());

        account.setBalance(20000000);
        System.out.println("현재잔고 : " + account.getBalance());

        account.setBalance(30000);
        System.out.println("현재잔고 : " + account.getBalance());
    }
}
