package BankingApp;

import java.util.Scanner;

public class Register {
    
    public static void register(Scanner sc, Account[] bapp) {
        int es = fes(bapp);
        if (es == -1) {
            System.out.println("No more account slots available!");
            return;
        }
        
        System.out.println("Enter Account No.: ");
        bapp[es].accno(sc.nextInt());
        System.out.print("Enter Pin No.: ");
        bapp[es].pin(sc.nextInt());
        System.out.println("Registered Account No: " + bapp[es].gaccno());
    }
    
    private static int fes(Account[] bapp) {
        for (int i = 0; i < bapp.length; i++) {
            if (bapp[i].gaccno() == 0) {
                return i;
            }
        }
        return -1;
    }
}
