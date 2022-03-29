package thisJava;

public class Account {
    private String ano;
    private String owner;
    private int balance;

    //생성자
    public Account(String ano, String owner, int balance) {
        this.ano = ano;
        this.owner = owner;
        this.balance = balance;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getBalance() {  return balance;    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankMember{" +
                "계좌번호='" + ano + '\'' +
                ", 계좌주='" + owner + '\'' +
                ", 잔고=" + balance +
                '}';
    }
}
