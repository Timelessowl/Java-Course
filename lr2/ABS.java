package lr2;

interface BankAccountOperations {
    void createAccount(String accountNumber, int initialBalance);

    void deposit(int amount);

    void withdraw(int amount);

    double getBalance();
}

class BankAccount implements BankAccountOperations {
    private String accountNumber;
    private int balance;

    public BankAccount(String accountNumber, int initialBalance) {
        createAccount(accountNumber, initialBalance);
    }

    @Override
    public void createAccount(String accountNumber, int initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    @Override
    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Deposit must be positive");
        }
    }

    @Override
    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

public class ABS {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456", 100);
        account.deposit(500);
        account.withdraw(200);
        System.out.println("Current balance for account " + account.getAccountNumber() + ": " + account.getBalance());
    }
}
