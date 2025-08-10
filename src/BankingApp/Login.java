
package BankingApp;

import java.util.Scanner;

public class Login {
    
    public static void login(Scanner sc, Account[] bapp) {
        int accn, pin;
        
        System.out.print("Enter Account No.: ");
        accn = sc.nextInt();
        System.out.print("Enter Pin No.: ");
        pin = sc.nextInt();

        int attempts = 3;
        int lgncnt = -1;

        while (attempts > 0 && lgncnt == -1) {
            for (int i = 0; i < bapp.length; i++) {
                if (bapp[i].gaccno() == accn && bapp[i].gpin() == pin) {
                    lgncnt = i;
                    break;
                }
            }
            
            if (lgncnt == -1) {
                attempts--;
                System.out.println("Invalid account or PIN. Attempts Left: " + attempts);
                if (attempts == 0) {
                    System.out.println("MAX ATTEMPT LIMIT REACHED!");
                    return;
                }
                System.out.print("Enter Account No.: ");
                accn = sc.nextInt();
                System.out.print("Enter Pin No.: ");
                pin = sc.nextInt();
            }
        }

        if (lgncnt != -1) {
            System.out.println("LOGIN SUCCESS!");
            
            int choice;
            do {
                System.out.println("\nWhat would you like to do?");
                System.out.println("1. Withdraw");
                System.out.println("2. Deposit");
                System.out.println("3. Logout");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                
                switch (choice) {
                    case 1:
                        System.out.println("Current Balance: " + bapp[lgncnt].gbalance());
                        System.out.print("Enter amount to withdraw: ");
                        float wthamount = sc.nextFloat();
                        bapp[lgncnt].withdraw(wthamount);
                        break;
                    case 2:
                        System.out.println("Current Balance: " + bapp[lgncnt].gbalance());
                        System.out.print("Enter amount to deposit: ");
                        float depositAmount = sc.nextFloat();
                        bapp[lgncnt].deposit(depositAmount);
                        System.out.println("Amount Added: " + depositAmount);
                        System.out.println("Total Balance: " + bapp[lgncnt].gbalance());
                        break;
                    case 3:
                        System.out.println("Logging out...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } while (choice != 3);
        }
    }
}

