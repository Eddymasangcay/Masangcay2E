import java.util.Scanner;

class Account {
    int accNo;
    int pin;

    boolean verifyAccount(int accn, int pin) {
        return this.accNo == accn && this.pin == pin;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account[] bapp = new Account[10]; 
        for(int i = 0; i < bapp.length; i++) {
            bapp[i] = new Account();
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

            switch(choice) {
                case 1:
                    int accn, pin;
                    System.out.println("1. Register");
                    System.out.println("2. Login");
                    System.out.println("3. Exit");
                    System.out.print("Enter Action: ");
                    int action = sc.nextInt();

                    switch(action) {
                        case 1:
                            
                            int emptyIndex = -1;
                            for(int i = 0; i < bapp.length; i++) {
                                if(bapp[i].accNo == 0) {
                                    emptyIndex = i;
                                    break;
                                }
                            }
                            if(emptyIndex == -1) {
                                System.out.println("No more accounts can be registered!");
                                break;
                            }
                            System.out.println("Enter Account No.: ");
                            bapp[emptyIndex].accNo = sc.nextInt();
                            System.out.print("Enter Pin No.: ");
                            bapp[emptyIndex].pin = sc.nextInt();
                            System.out.println("Registered Account No: " + bapp[emptyIndex].accNo);
                            break;

                        case 2:
                            System.out.print("Enter Account No.: ");
                            accn = sc.nextInt();
                            System.out.print("Enter Pin No.: ");
                            pin = sc.nextInt();

                            int attempts = 3;
                            boolean loggedIn = false;
                            while(attempts > 0) {
                                // Find account
                                Account target = null;
                                for(int i = 0; i < bapp.length; i++) {
                                    if(bapp[i].accNo == accn) {
                                        target = bapp[i];
                                        break;
                                    }
                                }
                                if(target != null && target.verifyAccount(accn, pin)) {
                                    System.out.println("LOGIN SUCCESS!");
                                    loggedIn = true;
                                    break;
                                }
                                attempts--;
                                System.out.println("Invalid account, Attempts Left: "+attempts);
                                if(attempts == 0) {
                                    System.out.println("MAX ATTEMPT LIMIT REACHED!");
                                    break;
                                }
                                System.out.print("Enter Account No.: ");
                                accn = sc.nextInt();
                                System.out.print("Enter Pin No.: ");
                                pin = sc.nextInt();
                            }
                            break;

                        case 3:
                            break;
                        default:
                            System.out.println("INVALID ACTION");
                    }
                    break;

                case 2:
                    System.out.println("Shopping feature coming soon!");
                    break;
                    
                case 3:
                    System.out.println("Pay Bills feature coming soon!");
                    break;

                default:
                    System.out.println("INVALID ACTION!");
            }
            System.out.print("Continue? (1/0): ");
            response = sc.nextInt();
        } while(response == 1);
        sc.close();
    }
}
