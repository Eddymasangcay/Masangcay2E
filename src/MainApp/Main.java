package MainApp;

import java.util.Scanner;
import BankingApp.BankApp;

public class Main {
    static boolean loggedIn = false; 
    static int currentAccount = -1; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankingApp.Account[] bapp = new BankingApp.Account[10];

      
        for (int i = 0; i < bapp.length; i++) {
            bapp[i] = new BankingApp.Account();
        }

        int response;
        do {
            System.out.println("WELCOME TO MY SYSTEM!");
            System.out.println("What do you feel like doing today?");
            System.out.println("1. Banking");
            System.out.println("2. Shopping");
            System.out.println("3. Pay Bills");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    BankApp.bankingApp(sc, bapp);
                    break;
                case 2:
                    System.out.println("Still in development >.<, Love you Sir Bus <3");

                    break;
                case 3:
                    System.out.println("Still in development >.<, Love you Sir Bus <3");
                    break;
                case 4:
                    System.out.println("Please comeback again, We are pleasured to serve you!");
                    break;
                default:
                    System.out.println("INVALID ACTION!");
            }

            System.out.print("Do you want to Continue using? (1/0): ");
            response = sc.nextInt();
        } while (response == 1);

        sc.close();
    }
}
