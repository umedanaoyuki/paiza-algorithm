// 問題：https://paiza.jp/works/mondai/class_primer/class_primer__super_super_supercar

import java.util.Scanner;

class SuperCar {
    // 燃料
    int fuel;
    // 燃費
    int fuelConsumption;
    // 走行距離
    int length;

    SuperCar(int fuel, int fuelConsumption) {
        this.fuel = fuel;
        this.fuelConsumption = fuelConsumption;
        this.length = 0;
    }

    void run() {
        if (fuel == 0) {
            return;
        }
        fuel -= 1;
        length = length + fuelConsumption;
    }

    void fly() {}

    void teleport() {}
}

class SuperSuperCar extends SuperCar {

    SuperSuperCar(int fuel, int fuelConsumption) {
        super(fuel, fuelConsumption);
    }

    @Override
    void fly() {
        if (fuel < 5) {
            run();
        } else {
            fuel -= 5;
            length = length + fuelConsumption * fuelConsumption;
        }
    }
}

class SuperSuperSuperCar extends SuperCar{
    SuperSuperSuperCar(int fuel, int fuelConsumption) {
        super(fuel, fuelConsumption);
    }

    @Override
    void fly() {
        if (fuel < 5) {
            run();
        } else {
            fuel -= 5;
            length = length + 2 * fuelConsumption * fuelConsumption;
        }
    }

    @Override
    void teleport() {
        if (fuel < fuelConsumption * fuelConsumption) {
            fly();
        } else {
            fuel -= fuelConsumption * fuelConsumption;
            length = length + fuelConsumption * fuelConsumption * fuelConsumption * fuelConsumption;
        }
    }
}


public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 車の台数
        int carNumber = sc.nextInt();
        // 回数
        int driveTime = sc.nextInt();

        SuperCar[] superCars = new SuperCar[carNumber];
        for (int i = 0; i < carNumber; i++) {
            String type = sc.next();
            int fuel = sc.nextInt();
            int fuelConsumption = sc.nextInt();
            if (type.equals("supercar")) {
                superCars[i] = new SuperCar(fuel, fuelConsumption);
            } else if (type.equals("supersupercar")) {
                superCars[i] = new SuperSuperCar(fuel, fuelConsumption);
            } else if (type.equals("supersupersupercar")) {
                superCars[i] = new SuperSuperSuperCar(fuel, fuelConsumption);
            }
        }

        for (int i = 0; i < driveTime; i++) {
            int index = sc.nextInt() - 1;
            String func = sc.next();
            if (func.equals("run")) {
                superCars[index].run();
            } else if (func.equals("fly")) {
                superCars[index].fly();
            } else if (func.equals("teleport")) {
                superCars[index].teleport();
            }
        }

        for (SuperCar superCar : superCars) {
            System.out.println(superCar.length);
        }
    }
}
