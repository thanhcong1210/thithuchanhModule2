package thi_thuc_hanh_modul_2.repository;

import thi_thuc_hanh_modul_2.model.BankAccount;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BankAccountRepository {
    private String filePath;

    public BankAccountRepository(String filePath) {
        this.filePath = filePath;
    }

    public List<BankAccount> getAllAccounts() {
        List<BankAccount> accounts = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                BankAccount account = BankAccount.fromCSV(line);
                accounts.add(account);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public void saveAllAccounts(List<BankAccount> accounts) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (BankAccount account : accounts) {
                bw.write(account.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addAccount(BankAccount account) {
        List<BankAccount> accounts = getAllAccounts();
        accounts.add(account);
        saveAllAccounts(accounts);
    }

    public void deleteAccount(String accountId) {
        List<BankAccount> accounts = getAllAccounts();
        BankAccount accountToDelete = null;

        for (BankAccount account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                accountToDelete = account;
                break;
            }
        }

        if (accountToDelete != null) {
            accounts.remove(accountToDelete);
            saveAllAccounts(accounts);
        } else {
            System.out.println("Không tìm thấy tài khoản để xóa.");
        }
    }
}
