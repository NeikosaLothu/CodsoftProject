import java.util.Scanner;

class BankAccount {
    private float balance;

    public BankAccount(float initialBalance) {
        this.balance = initialBalance;
    }

    public float getBalance() {
        return balance;
    }

    public void deposit(float amount) {
        balance += amount;
    }

    public boolean withdraw(float amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } 
        return false;
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void checkBalance() {
        System.out.println("Your balance: " + account.getBalance());
    }

    private void withdrawMoney() {
        System.out.print("Enter amount to withdraw: ");
        float amount = scanner.nextFloat();
        if (amount > 0 && account.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    private void depositMoney() {
        System.out.print("Enter amount to deposit: ");
        float amount = scanner.nextFloat();
        if (amount > 0) {
            account.deposit(amount);
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
}

public class AtmMachine {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(5000); 
        ATM myATM = new ATM(myAccount);
        myATM.start();
    }
}
