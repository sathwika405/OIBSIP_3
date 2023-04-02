import java.util.ArrayList;
import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize user id and pin
        String userId = "sathwika";
        String userPin = "sathvi@3";
        double balance = 1000.0;
        ArrayList<String> transactionHistory = new ArrayList<>();

        // Prompt user for id and pin
        System.out.print("Enter user ID: ");
        String enteredId = scanner.nextLine();

        System.out.print("Enter user PIN: ");
        String enteredPin = scanner.nextLine();

        // Validate id and pin
        if (!enteredId.equals(userId) || !enteredPin.equals(userPin)) {
            System.out.println("Invalid user ID or PIN. Please try again.");
            scanner.close();
            return;
        }

        // Display menu
        System.out.println("Welcome to the ATM!");
        int choice = 0;
        do {
            System.out.println("1. View transaction history");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (transactionHistory.size() == 0) {
                        System.out.println("No transaction history.");
                    } else {
                        System.out.println("Transaction history:");
                        for (String transaction : transactionHistory) {
                            System.out.println(transaction);
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (balance < withdrawAmount) {
                        System.out.println("Insufficient balance. Please try again.");
                    } else {
                        balance -= withdrawAmount;
                        String transaction = "Withdrawal of " + withdrawAmount + " successfully completed.";
                        transactionHistory.add(transaction);
                        System.out.println(transaction);
                    }
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    balance += depositAmount;
                    String transaction = "Deposit of " + depositAmount + " successfully completed.";
                    transactionHistory.add(transaction);
                    System.out.println(transaction);
                    break;
                case 4:
                    System.out.print("Enter recipient account number: ");
                    String recipientAccountNumber = scanner.next();
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    if (balance < transferAmount) {
                        System.out.println("Insufficient balance. Please try again.");
                    } else {
                        balance -= transferAmount;
                        transaction = "Transfer of " + transferAmount + " to account number " + recipientAccountNumber + " successfully completed.";
                        transactionHistory.add(transaction);
                        System.out.println(transaction);
                    }
                    break;
                case 5:
                    System.out.println("Current balance: " + balance);
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        } while (choice != 6);

        scanner.close();
    }
}
