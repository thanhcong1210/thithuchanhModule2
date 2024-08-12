package thi_thuc_hanh_modul_2.model;

import java.time.LocalDate;

public class SavingsAccount extends BankAccount {
    private double depositAmount;
    private LocalDate depositDate;
    private double interestRate;
    private int term;

    public SavingsAccount(String accountId, String accountCode, String accountHolderName, LocalDate creationDate, double depositAmount, LocalDate depositDate, double interestRate, int term) {
        super(accountId, accountCode, accountHolderName, creationDate);
        this.depositAmount = depositAmount;
        this.depositDate = depositDate;
        this.interestRate = interestRate;
        this.term = term;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public LocalDate getDepositDate() {
        return depositDate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getTerm() {
        return term;
    }

    @Override
    public String toString() {
        return super.toString() + "," + depositAmount + "," + depositDate + "," + interestRate + "," + term;
    }

    public static SavingsAccount fromCSV(String csvLine) {
        String[] parts = csvLine.split(",");
        return new SavingsAccount(
                parts[0],
                parts[1],
                parts[2],
                LocalDate.parse(parts[3]),
                Double.parseDouble(parts[4]),
                LocalDate.parse(parts[5]),
                Double.parseDouble(parts[6]),
                Integer.parseInt(parts[7])
        );
    }
}
