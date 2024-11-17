import java.util.*;

public class Bank {
    private Map<String, User> users = new HashMap<>();
    private Map<String, List<Transaction>> transactionHistory = new HashMap<>();
    private Random random = new Random();

    private String generateAccountNumber() {
        return "ACCT" + (10000 + random.nextInt(90000));
    }

    private String generatePassword() {
        return "pass" + (1000 + random.nextInt(9000));
    }

    public void registerUser(String name, String address, String contact, double initialDeposit) {
        String accountNumber = generateAccountNumber();
        String password = generatePassword();
        User newUser = new User(name, address, contact, accountNumber, initialDeposit, password);
        users.put(accountNumber, newUser);
        transactionHistory.put(accountNumber, new ArrayList<>());
        recordTransaction(accountNumber, initialDeposit, "Initial Deposit");
        System.out.println("Registration successful! Account Number: " + accountNumber + ", Password: " + password);
    }

    public void deposit(String accountNumber, double amount) {
        User user = users.get(accountNumber);
        if (user != null && amount > 0) {
            user.setBalance(user.getBalance() + amount);
            recordTransaction(accountNumber, amount, "Deposit");
            System.out.println("Deposit successful. New balance: " + user.getBalance());
        } else {
            System.out.println("Invalid account or amount.");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        User user = users.get(accountNumber);
        if (user != null && amount > 0 && user.getBalance() >= amount) {
            user.setBalance(user.getBalance() - amount);
            recordTransaction(accountNumber, amount, "Withdrawal");
            System.out.println("Withdrawal successful. New balance: " + user.getBalance());
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    public void transferFunds(String senderAccount, String receiverAccount, double amount) {
        User sender = users.get(senderAccount);
        User receiver = users.get(receiverAccount);
        if (sender != null && receiver != null && sender.getBalance() >= amount) {
            sender.setBalance(sender.getBalance() - amount);
            receiver.setBalance(receiver.getBalance() + amount);
            recordTransaction(senderAccount, amount, "Transfer to " + receiverAccount);
            recordTransaction(receiverAccount, amount, "Transfer from " + senderAccount);
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Transfer failed. Check accounts or balance.");
        }
    }

    public void printStatement(String accountNumber) {
        List<Transaction> transactions = transactionHistory.get(accountNumber);
        if (transactions != null) {
            System.out.println("Account Statement:");
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    private void recordTransaction(String accountNumber, double amount, String type) {
        Transaction transaction = new Transaction(new Date(), amount, type);
        transactionHistory.get(accountNumber).add(transaction);
    }

    public boolean login(String accountNumber, String password) {
        User user = users.get(accountNumber);
        return user != null && user.getPassword().equals(password);
    }
}