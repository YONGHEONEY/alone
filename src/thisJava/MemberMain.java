package thisJava;

public class MemberMain {
    public static void main(String[] args) {
        MemberService mem1 = new MemberService();
        boolean result = mem1.login("hong", "12345");

        if(result) {
            System.out.println("로그인 성공");
            mem1.logout();
        } else {
            System.out.println("로그인 불가");
        }

    }
}
