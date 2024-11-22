// Base Class
class Account {
    String name;
    int accNo;
    String accType;
    double balance;

    Account(String name, int accNo, String accType) {
        this.name = name;
        this.accNo = accNo;
        this.accType = accType;
        this.balance = 0.0;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    void displayBalance() {
        System.out.println("Account Balance: " + balance);
    }
}

// Savings Account Class
class SavAcct extends Account {
    double interestRate;

    SavAcct(String name, int accNo) {
        super(name, accNo, "Savings");
        this.interestRate = 0.04; // 4% annual interest
    }

    void computeInterest(int years) {
        double interest = balance * Math.pow(1 + interestRate, years) - balance;
        balance += interest;
        System.out.println("Interest Added: " + interest + ", New Balance: " + balance);
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        }
    }
}

// Current Account Class
class CurrAcct extends Account {
    double minBalance;
    double serviceCharge;

    CurrAcct(String name, int accNo) {
        super(name, accNo, "Current");
        this.minBalance = 500.0;
        this.serviceCharge = 50.0;
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
            if (balance < minBalance) {
                balance -= serviceCharge;
                System.out.println("Service charge imposed: " + serviceCharge);
            }
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        }
    }
}

// Main Class
public class BankAccount {
    public static void main(String[] args) {
        // Savings Account Example
        SavAcct savings = new SavAcct("Alice", 101);
        savings.deposit(1000);
        savings.computeInterest(1); // 1 year
        savings.withdraw(500);
        savings.displayBalance();

        // Current Account Example
        CurrAcct current = new CurrAcct("Bob", 102);
        current.deposit(1000);
        current.withdraw(600);
        current.withdraw(200);
        current.displayBalance();
    }
}
