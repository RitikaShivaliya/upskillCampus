import java.util.Date;

public class Transaction {
    private Date date;
    private double amount;
    private String type;

    public Transaction(Date date, double amount, String type) {
        this.date = date;
        this.amount = amount;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Date: " + date + ", Amount: " + amount + ", Type: " + type;
    }
}