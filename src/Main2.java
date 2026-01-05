import java.util.Scanner;

// 問題：https://paiza.jp/works/mondai/class_primer/class_primer__closed_maze

class Point {

    char a;
    int[] road;

    Point(char a, int r1, int r2) {
        this.a = a;
        this.road = new int[] { r1, r2 };
    }
}

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int s = sc.nextInt();

        Point[] points = new Point[n + 1];
        for (int i = 1; i <= n; i++) {
            String a = sc.next();
            int r1 = sc.nextInt();
            int r2 = sc.nextInt();
            points[i] = new Point(a.charAt(0), r1, r2);
        }

        int now = s;
        StringBuilder sb = new StringBuilder();
        sb.append(points[now].a);

        for (int i = 0; i < k; i++) {
            int m = sc.nextInt() - 1;
            now = points[now].road[m];
            sb.append(points[now].a);
        }

        System.out.println(sb.toString());
    }
}