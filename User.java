public class User {
    private String name;
    private String address;
    private String contact;
    private String accountNumber;
    private double balance;
    private String password;

    public User(String name, String address, String contact, String accountNumber, double balance, String password) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.password = password;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
    public String getPassword() { return password; }
}