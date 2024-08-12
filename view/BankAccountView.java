package thi_thuc_hanh_modul_2.view;

import thi_thuc_hanh_modul_2.model.BankAccount;

import java.util.List;
import java.util.Scanner;

public class BankAccountView {
    private Scanner scanner;

    public BankAccountView() {
        this.scanner = new Scanner(System.in);
    }

    public int displayMenu() {
        System.out.println("CHƯƠNG TRÌNH QUẢN LÝ TÀI KHOẢN NGÂN HÀNG");
        System.out.println("1. Thêm tài khoản thanh toán");
        System.out.println("2. Thêm tài khoản tiết kiệm");
        System.out.println("3. Xóa tài khoản");
        System.out.println("4. Xem danh sách tài khoản");
        System.out.println("5. Tìm kiếm tài khoản");
        System.out.println("0. Thoát");
        System.out.print("Chọn chức năng: ");
        return scanner.nextInt();
    }

    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }

    public double getDoubleInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextDouble();
    }

    public int getIntInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public void showAccounts(List<BankAccount> accounts) {
        for (BankAccount account : accounts) {
            System.out.println(account);
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showAccount(BankAccount account) {
        System.out.println("Thông tin tài khoản : " + account);
    }
}