package thi_thuc_hanh_modul_2.model;

import java.time.LocalDate;

public class BankAccount {
    private String accountId;
    private String accountCode;
    private String accountHolderName;
    private LocalDate creationDate;

    public BankAccount(String accountId, String accountCode, String accountHolderName, LocalDate creationDate) {
        this.accountId = accountId;
        this.accountCode = accountCode;
        this.accountHolderName = accountHolderName;
        this.creationDate = creationDate;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return accountId + "," + accountCode + "," + accountHolderName + "," + creationDate;
    }

    public static BankAccount fromCSV(String csvLine) {
        String[] parts = csvLine.split(",");
        return new BankAccount(
                parts[0],
                parts[1],
                parts[2],
                LocalDate.parse(parts[3])
        );
    }
}

