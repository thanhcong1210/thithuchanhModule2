package thi_thuc_hanh_modul_2.service;

import thi_thuc_hanh_modul_2.model.BankAccount;
import thi_thuc_hanh_modul_2.model.CheckingAccount;
import thi_thuc_hanh_modul_2.model.SavingsAccount;
import thi_thuc_hanh_modul_2.repository.BankAccountRepository;

import java.time.LocalDate;
import java.util.List;

public class BankAccountService {
    private BankAccountRepository repository;

    public BankAccountService(BankAccountRepository repository) {
        this.repository = repository;
    }

    public void createCheckingAccount(String accountId, String accountCode, String accountHolderName, String cardNumber, double balance) {
        CheckingAccount account = new CheckingAccount(accountId, accountCode, accountHolderName, LocalDate.now(), cardNumber, balance);
        repository.addAccount(account);
    }

    public void createSavingsAccount(String accountId, String accountCode, String accountHolderName, double depositAmount, LocalDate depositDate, double interestRate, int term) {
        SavingsAccount account = new SavingsAccount(accountId, accountCode, accountHolderName, LocalDate.now(), depositAmount, depositDate, interestRate, term);
        repository.addAccount(account);
    }

    public void deleteAccount(String accountId) {
        repository.deleteAccount(accountId);
    }

    public List<BankAccount> viewAllAccounts() {
        return repository.getAllAccounts();
    }

    public BankAccount searchAccount(String accountId) {
        List<BankAccount> accounts = repository.getAllAccounts();
        for (BankAccount account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                return account;
            }
        }
        return null;
    }
}
