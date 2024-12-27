import java.util.Scanner;

// Account class
class Account {
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    public Account(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if(amount>0) {
            balance += amount;
            System.out.println("Deposited:"+ amount);
        }
        else {
            System.out.println("Invalid input:");
        }
    }

    public void withdraw(double amount) {
        if(amount>0 && amount<=balance) {
            balance -= amount;
            System.out.println("Withdraw:"+ amount);
        }
        else {
            System.out.println("Invalid input:");
        }
    }

    public double getBalance() {
        return balance;
    }
    public String getAccountHolderName() {
        return accountHolderName;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
} 

// Main Class
public class BankingApplication {
    private static Account account;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        createAccount(sc);

        int choice = 0;
        while(choice != 4) {
            System.out.println("\n---Welcome to J&M bank---");
            System.out.println("1. Deposit\n2. Withdrawl\n3. Check Balance\n4. Exit");
            System.out.println("Enter your choice:");
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                depositMoney(sc);
                break;
                case 2:
                withdrawMoney(sc);
                break;
                case 3:
                checkBalance();
                break;
                case 4:
                System.out.println("Exiting...");
                break;
                default:
                System.out.println("Please enter valid choice");
            }
        }
    sc.close();
    }

    private static void createAccount(Scanner sc) {
        System.out.println("Please create an account");
        System.out.println("Enter account Holder Name: ");
        String name = sc.next();
        System.out.println("Enter account number: ");
        String accountNumber = sc.next();
        account = new Account(name , accountNumber);
        System.out.println("Account created successfully");
    }

    private static void depositMoney(Scanner sc) {
        System.out.println("Enter amount: ");
        double amount = sc.nextDouble();
        account.deposit(amount);
    }

    private static void withdrawMoney(Scanner sc) {
        System.out.println("Enter amount: ");
        double amount = sc.nextDouble();
        account.withdraw(amount);
    }

    private static void checkBalance() {
        System.out.println("Current Balance" + " " +":" + account.getBalance());
    }
}