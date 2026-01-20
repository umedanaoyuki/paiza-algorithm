// 問題 https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__get_one

import java.util.*;

public class Main6 {

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();
        String[][] S = new String[H][W];

        for (int i = 0; i < H; i++) {
            S[i] = sc.next().split("");
        }

        int y = sc.nextInt();
        int x = sc.nextInt();

        if (S[y][x].equals(".")) {
            S[y][x] = "#";
        } else {
            S[y][x] = ".";
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(S[i][j]);
            }
            System.out.println();
        }
    }
}