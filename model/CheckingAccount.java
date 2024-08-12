package thi_thuc_hanh_modul_2.model;

import java.time.LocalDate;

public class CheckingAccount extends BankAccount {
    private String cardNumber;
    private double balance;

    public CheckingAccount(String accountId, String accountCode, String accountHolderName, LocalDate creationDate, String cardNumber, double balance) {
        super(accountId, accountCode, accountHolderName, creationDate);
        this.cardNumber = cardNumber;
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return super.toString() + "," + cardNumber + "," + balance;
    }

    public static CheckingAccount fromCSV(String csvLine) {
        String[] parts = csvLine.split(",");
        return new CheckingAccount(
                parts[0],
                parts[1],
                parts[2],
                LocalDate.parse(parts[3]),
                parts[4],
                Double.parseDouble(parts[5])
        );
    }
}
