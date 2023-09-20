
import java.util.Scanner;

public class ATM {

    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.next();

            switch (choice) {
                case "1":
                    System.out.print("Enter the deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    System.out.println(bankAccount.deposit(depositAmount));
                    break;
                case "2":
                    System.out.print("Enter the withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    System.out.println(bankAccount.withdraw(withdrawAmount));
                    break;
                case "3":
                    System.out.println(bankAccount.checkBalance());
                    break;
                case "4":
                    System.out.println("Thank you for using the ATM!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner ai = new Scanner(System.in);
        System.out.println("Enter your Name please: ");
        String name = ai.next();
        BankAccount userAccount = new BankAccount(name, 1000.0);
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}

class BankAccount {

    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public String deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return "Deposited $" + amount + ". Your new balance: $" + balance;
        } else {
            return "Invalid deposit amount.";
        }
    }

    public String withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                return "Withdrew $" + amount + ". Your new balance: $" + balance;
            } else {
                return "Insufficient funds.";
            }
        } else {
            return "Invalid withdrawal amount.";
        }
    }

    public String checkBalance() {
        return "The account balance for " + accountHolder + ": is $" + balance;
    }
}
