package thi_thuc_hanh_modul_2;


import thi_thuc_hanh_modul_2.controller.BankAccountController;
import thi_thuc_hanh_modul_2.repository.BankAccountRepository;
import thi_thuc_hanh_modul_2.service.BankAccountService;
import thi_thuc_hanh_modul_2.view.BankAccountView;

public class main {
    public static void main(String[] args) {
        String filePath = "bank_accounts.csv";

        BankAccountRepository repository = new BankAccountRepository(filePath);
        BankAccountService service = new BankAccountService(repository);
        BankAccountView view = new BankAccountView();
        BankAccountController controller = new BankAccountController(service, view);

        controller.handleUserInput();
    }
}
