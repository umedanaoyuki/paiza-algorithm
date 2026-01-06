// 問題: https://paiza.jp/works/mondai/class_primer/class_primer__heros

import java.util.Arrays;
import java.util.Scanner;

class Hero {
    // レベル
    int level;
    // 体力
    int physicalStrength;
    // 攻撃力
    int offence;
    // 防御力
    int defence;
    // 素早さ
    int speed;
    // 賢さ
    int intelligence;
    // 運
    int lucky;

    Hero(int level, int physicalStrength, int offence, int defence, int speed, int intelligence, int lucky) {
        this.level = level;
        this.physicalStrength = physicalStrength;
        this.offence = offence;
        this.defence = defence;
        this.speed = speed;
        this.intelligence = intelligence;
        this.lucky = lucky;
    }
}

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 人数
        int n = sc.nextInt();
        // イベント数
        int k = sc.nextInt();

        Hero[] heroes = new Hero[n + 1];
        for (int i = 1; i <= n; i++) {
            int level = sc.nextInt();
            int physicalStrength = sc.nextInt();
            int offence = sc.nextInt();
            int defence = sc.nextInt();
            int speed = sc.nextInt();
            int intelligence = sc.nextInt();
            int lucky = sc.nextInt();
            heroes[i] = new Hero(level, physicalStrength, offence, defence,speed, intelligence, lucky);
        }

        for (int i = 1; i <= k; i++) {
            // 何番目の勇者に対しての指示か？
            int heroNumber = sc.nextInt();
            //　イベント内容
            String event = sc.next();


            if (event.equals("levelup")) {
                // 体力
                int h = sc.nextInt();
                // 攻撃力
                int a = sc.nextInt();
                // 防御力
                int d = sc.nextInt();
                // 素早さ
                int s = sc.nextInt();
                // 賢さ
                int c = sc.nextInt();
                // 運
                int f = sc.nextInt();

                heroes[heroNumber].level += 1;
                heroes[heroNumber].physicalStrength += h;
                heroes[heroNumber].offence += a;
                heroes[heroNumber].defence += d;
                heroes[heroNumber].speed += s;
                heroes[heroNumber].intelligence += c;
                heroes[heroNumber].lucky += f;
            }

            if (event.equals("muscle_training")) {
                // 体力
                int h = sc.nextInt();
                // 攻撃力
                int a = sc.nextInt();

                heroes[heroNumber].physicalStrength += h;
                heroes[heroNumber].offence += a;
            }

            if (event.equals("running")) {
                // 防御力
                int d = sc.nextInt();
                // 素早さ
                int s = sc.nextInt();

                heroes[heroNumber].defence += d;
                heroes[heroNumber].speed += s;
            }

            if (event.equals("study")) {
                // 賢さ
                int c = sc.nextInt();
                heroes[heroNumber].intelligence += c;
            }

            if (event.equals("pray")) {
                // 運
                int f = sc.nextInt();
                heroes[heroNumber].lucky += f;
            }

        }

        for (int i = 1; i < heroes.length; i++) {
            System.out.print(heroes[i].level);
            System.out.print(" " + heroes[i].physicalStrength);
            System.out.print(" " + heroes[i].offence);
            System.out.print(" " + heroes[i].defence);
            System.out.print(" " + heroes[i].speed);
            System.out.print(" " + heroes[i].intelligence);
            System.out.print(" " + heroes[i].lucky);
            System.out.println();
        }
    }
}