package thi_thuc_hanh_modul_2.controller;

import thi_thuc_hanh_modul_2.model.BankAccount;
import thi_thuc_hanh_modul_2.service.BankAccountService;
import thi_thuc_hanh_modul_2.view.BankAccountView;

import java.time.LocalDate;

public class BankAccountController {
    private BankAccountService service;
    private BankAccountView view;

    public BankAccountController(BankAccountService service, BankAccountView view) {
        this.service = service;
        this.view = view;
    }

    public void handleUserInput() {
        int choice;
        do {
            choice = view.displayMenu();
            switch (choice) {
                case 1:
                    createCheckingAccount();
                    break;
                case 2:
                    createSavingsAccount();
                    break;
                case 3:
                    deleteAccount();
                    break;
                case 4:
                    view.showAccounts(service.viewAllAccounts());
                    break;
                case 5:
                    searchAccount();
                    break;
                case 0:
                    view.showMessage("Thoát chương trình!!!");
                    break;
                default:
                    view.showMessage("Lựa chọn không hợp lệ!!! Vui lòng chọn lại!!!");
                    break;
            }
        } while (choice != 0);
    }

    private void createCheckingAccount() {
        String accountId = view.getInput("Nhập mã tài khoản : ");
        String accountCode = view.getInput("Nhập mã số tài khoản : ");
        String accountHolderName = view.getInput("Nhập tên chủ tài khoản : ");
        String cardNumber = view.getInput("Nhập số thẻ : ");
        double balance = view.getDoubleInput("Nhập số dư : ");
        service.createCheckingAccount(accountId, accountCode, accountHolderName, cardNumber, balance);
        view.showMessage("Tài khoản ã được thêm thành công!!!");
    }

    private void createSavingsAccount() {
        String accountId = view.getInput("Nhập mã tài khoản : ");
        String accountCode = view.getInput("Nhập mã số tài khoản : ");
        String accountHolderName = view.getInput("Nhập tên chủ tài khoản : ");
        double depositAmount = view.getDoubleInput("Nhập số tiền gửi : ");
        LocalDate depositDate = LocalDate.parse(view.getInput("Nhập ngày gửi (yyyy-MM-dd) : "));
        double interestRate = view.getDoubleInput("Nhập lãi suất : ");
        int term = view.getIntInput("Nhập kỳ hạn (tháng) : ");
        service.createSavingsAccount(accountId, accountCode, accountHolderName, depositAmount, depositDate, interestRate, term);
        view.showMessage("Tài khoản tiết kiệm được thêm thành công!!!");
    }

    private void deleteAccount() {
        String accountId = view.getInput("Nhập mã tài khoản cần xóa : ");
        service.deleteAccount(accountId);
        view.showMessage("Tài khoản đã được xóa!!!");
    }

    private void searchAccount() {
        String accountId = view.getInput("Nhập mã tài khoản cần tìm : ");
        BankAccount account = service.searchAccount(accountId);
        if (account != null) {
            view.showAccount(account);
        } else {
            view.showMessage("Không tìm thấy tài khoản!!!");
        }
    }
}