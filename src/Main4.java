

// 問題: https://paiza.jp/works/mondai/class_primer/class_primer__fighting_game

import java.util.Scanner;

class Player {

    int hp;
    int[] f;
    int[] a;

    Player(int hp, int f1, int a1, int f2, int a2, int f3,int a3) {
        this.hp = hp;
        // 発生フレーム
        this.f = new int[] { f1, f2, f3 };
        // 攻撃力
        this.a = new int[] { a1, a2, a3 };
    }

    // 強化系
    void enhance() {
        for (int i = 0; i < 3; i++) {
            if (a[i] == 0 && f[i] == 0) {
                continue;
            }
            a[i] += 5;
            f[i] = Math.max(f[i] - 3, 1);
        }
    }

    // 攻撃系（ダメージを受ける）
    void takeDamage(int d) {
        hp -= d;
    }

    // 生存確認
    boolean isAlive() {
        return hp > 0;
    }
}


public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 人数
        int memberNumber = sc.nextInt();
        // 攻撃回数
        int playTime = sc.nextInt();

        Player[] players = new Player[memberNumber];
        for (int i = 0; i < memberNumber; i++) {
            int hp = sc.nextInt();
            int f1 = sc.nextInt();
            int a1 = sc.nextInt();
            int f2 = sc.nextInt();
            int a2 = sc.nextInt();
            int f3 = sc.nextInt();
            int a3 = sc.nextInt();
            players[i] = new Player(hp, f1, a1, f2, a2, f3, a3);
        }

//        for (Player num: persons) {
//            System.out.println(num.hp);
//            for (int i = 0; i < 3; i++) {
//                System.out.println(num.f[i]);
//                System.out.println(num.a[i]);
//            }
//        }

        for (int i = 0; i < playTime; i++) {
            int playerA = sc.nextInt() -1;
            int skillA = sc.nextInt() -1;
            int playerB = sc.nextInt() -1;
            int skillB = sc.nextInt() -1;

            Player p1 = players[playerA];
            Player p2 = players[playerB];

            if(!p1.isAlive() || !p2.isAlive()) {
                continue;
            }

            int f1 = p1.f[skillA];
            int a1 = p1.a[skillA];
            int f2 = p2.f[skillB];
            int a2 = p2.a[skillB];
            boolean p1Enhance = a1 == 0 && f1 == 0;
            boolean p2Enhance = a2 == 0 && f2 == 0;

            if (p1Enhance && p2Enhance) {
                p1.enhance();
                p2.enhance();
            } else if (p1Enhance) {
                p1.enhance();
                p1.takeDamage(a2);
            } else if (p2Enhance) {
                p2.enhance();
                p2.takeDamage(a1);
            } else {
                if (f1 < f2) {
                    p2.takeDamage(a1);
                } else if (f1 > f2) {
                    p1.takeDamage(a2);
                }
            }
        }

        int aliveNumber = 0;
        for (Player player: players) {
            if (player.isAlive()) {
                aliveNumber++;
            }
        }

        System.out.println(aliveNumber);
    }
}
