import java.util.Scanner;

public class Main {
    static boolean loggedIn = false;  // Track login status
    static int currentAccount = -1;   // Track which account is logged in

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account[] bapp = new Account[10];

        // Initialize accounts
        for (int i = 0; i < bapp.length; i++) {
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

            switch (choice) {
                case 1:
                    bankingApp(sc, bapp); // Call the bankingApp method
                    break;
                case 2:
                    // Shopping logic here
                    break;
                case 3:
                    // Pay Bills logic here
                    break;
                default:
                    System.out.println("INVALID ACTION!");
            }

            System.out.print("Continue? (1/0): ");
            response = sc.nextInt();
        } while (response == 1);

        sc.close();
    }

    static void bankingApp(Scanner sc, Account[] bapp) {
        int accn, pin;
        int action;

        do {
            System.out.println("1. Register");
            System.out.println("2. Login");
            if (loggedIn) {
                System.out.println("3. Logout"); // Show logout option only if logged in
            }
            System.out.println("4. Exit");
            System.out.print("Enter Action: ");
            action = sc.nextInt();

            switch (action) {
                case 1:
                    // Registration
                    System.out.println("Enter Account No.: ");
                    bapp[0].setAccNo(sc.nextInt());
                    System.out.print("Enter Pin No.: ");
                    bapp[0].setPin(sc.nextInt());
                    System.out.println("Registered Account No: " + bapp[0].getAccNo());
                    break;

                case 2:
                    // Login
                    System.out.print("Enter Account No.: ");
                    accn = sc.nextInt();
                    System.out.print("Enter Pin No.: ");
                    pin = sc.nextInt();

                    int attempts = 3;

                    while (!(bapp[0].verifyAccount(accn, pin))) {
                        attempts--;
                        System.out.println("Invalid account, Attempts Left: " + attempts);
                        if (attempts == 0) {
                            System.out.println("MAX ATTEMPT LIMIT REACHED!");
                            System.exit(0);
                        }
                        System.out.print("Enter Account No.: ");
                        accn = sc.nextInt();
                        System.out.print("Enter Pin No.: ");
                        pin = sc.nextInt();
                    }

                    loggedIn = true; // Set login status
                    currentAccount = 0; // Set current account index
                    System.out.println("LOGIN SUCCESS!");
                    break;

                case 3:
                    // Logout
                    if (loggedIn) {
                        System.out.println("Logged out successfully!");
                        loggedIn = false; // Reset login status
                        currentAccount = -1; // Reset current account index
                    } else {
                        System.out.println("You are not logged in!");
                    }
                    break;

                case 4:
                    // Exit
                    break;

                default:
                    System.out.println("INVALID ACTION");
            }
        } while (action != 4); // Loop until exit
    }
}

class Account {
    private int accNo;
    private int pin;

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public boolean verifyAccount(int accn, int pin) {
        return this.accNo == accn && this.pin == pin;
    }
}
