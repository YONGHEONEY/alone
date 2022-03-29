package thisJava;

public class Account01 {
    // final 은 변수의 값을 고정시키는 것이기떄문에 사용불가
    public static final int MIN_BALANCE = 0;
    public static final int MAX_BALANCE = 1000000;
    private int balance;

    public Account01(){ }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if(balance > Account01.MAX_BALANCE || balance < Account01.MIN_BALANCE) {
            return;
        }
        this.balance = balance;
    }
}
