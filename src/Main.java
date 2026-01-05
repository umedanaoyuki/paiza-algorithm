import java.util.Arrays;
import java.util.Scanner;

class Student {
    String name, birth, state;
    int old;

    void changeName(String name) {
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // クラスの人数
        int n = sc.nextInt();

        // 名前の更新回数
        int t = sc.nextInt();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            students[i] = new Student();
            students[i].name = sc.next();
            students[i].old = sc.nextInt();
            students[i].birth = sc.next();
            students[i].state = sc.next();
        }

//        for (int i = 0; i < 2; i++) {
//            System.out.println(infos[i].name);
//        }

        for (int i = 0; i < t; i++) {
            int a = sc.nextInt() -1;
            String nn = sc.next();
            students[a].changeName(nn);
        }

        // 最終的な回答の出力
        for (int i = 0; i < n; i++ ) {
            System.out.println(students[i].name + " " + students[i].old + " " + students[i].birth + " " + students[i].state);
        }
    }
}