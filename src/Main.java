import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String nickname = sc.next();
            int old = sc.nextInt();
            String birth = sc.next();
            String state = sc.next();

            System.out.println("User{");
            System.out.println("nickname : " + nickname);
            System.out.println("old : " + old);
            System.out.println("birth : " + birth);
            System.out.println("state : " + state);
            System.out.println("}");
        }
    }
}