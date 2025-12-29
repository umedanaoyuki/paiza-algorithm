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

        int k = sc.nextInt();
        for (Student student : students) {
            if (student.old == k) {
                System.out.println(student.name);
                break;
            }
        }
    }
}