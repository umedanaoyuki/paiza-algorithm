import java.util.Arrays;
import java.util.Scanner;

class Student {
    String name, birth, state;
    int old;
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            students[i] = new Student();
            students[i].name = sc.next();
            students[i].old = sc.nextInt();
            students[i].birth = sc.next();
            students[i].state = sc.next();
        }

        Arrays.sort(students, (a, b) -> a.old - b.old);

        for (int i = 0; i < n; i++ ) {
            System.out.println(students[i].name + " " + students[i].old + " " + students[i].birth + " " + students[i].state);
        }
    }
}