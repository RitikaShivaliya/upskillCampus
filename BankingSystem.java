import java.util.Scanner;

public class BankingSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Deposit\n4. Withdraw\n5. Transfer\n6. Statement\n7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name, Address, Contact, Initial Deposit: ");
                    String name = scanner.next();
                    String address = scanner.next();
                    String contact = scanner.next();
                    double initialDeposit = scanner.nextDouble();
                    bank.registerUser(name, address, contact, initialDeposit);
                    break;
                case 2:
                    System.out.print("Enter Account Number and Password: ");
                    String accountNumber = scanner.next();
                    String password = scanner.next();
                    if (bank.login(accountNumber, password)) {
                        System.out.println("Login Successful!");
                    } else {
                        System.out.println("Invalid Credentials.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account Number and Deposit Amount: ");
                    accountNumber = scanner.next();
                    double depositAmount = scanner.nextDouble();
                    bank.deposit(accountNumber, depositAmount);
                    break;
                case 4:
                    System.out.print("Enter Account Number and Withdrawal Amount: ");
                    accountNumber = scanner.next();
                    double withdrawalAmount = scanner.nextDouble();
                    bank.withdraw(accountNumber, withdrawalAmount);
                    break;
                case 5:
                    System.out.print("Enter Sender Account, Receiver Account, and Amount: ");
                    String senderAccount = scanner.next();
                    String receiverAccount = scanner.next();
                    double transferAmount = scanner.nextDouble();
                    bank.transferFunds(senderAccount, receiverAccount, transferAmount);
                    break;
                case 6:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.next();
                    bank.printStatement(accountNumber);
                    break;
                case 7:
                    System.out.println("Exiting the system. Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}