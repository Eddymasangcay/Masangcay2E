package BankingApp;

import java.util.Scanner;

public class BankApp {
    public static void bankingApp(Scanner sc, Account[] bapp) {
        int action;

        do {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter Action: ");
            action = sc.nextInt();

            switch (action) {
                case 1:
                    Register.register(sc, bapp);
                    break;

                case 2:
                    Login.login(sc, bapp);
                    break;

                case 3:
                    System.out.println("Exiting banking system...");
                    break;

                default:
                    System.out.println("INVALID ACTION");
            }
        } while (action != 3);
    }
}
