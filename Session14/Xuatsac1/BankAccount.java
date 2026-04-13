package Session14.Xuatsac1;

import java.util.Scanner;
import java.util.ArrayList;

public class BankAccount {
    protected String accountId; //số tài khoản
    protected double balance; //số dư tài khoản

    public BankAccount(double balance, String accountId) {
        this.balance = balance;
        this.accountId = accountId;
    }

    public BankAccount() {
    }

    ;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance > 0) {
            this.balance = balance;
        } else {
            throw new MyException("Số dư phải lớn hơn 0!");
        }

    }


    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        if (accountId.equalsIgnoreCase("Exit")) {
            return;
        } else if (!accountId.trim().isEmpty() && accountId.matches("\\d{10}")) {
            this.accountId = accountId;
        } else {
            throw new MyException("Số tài khoản không hợp lệ!");
        }
    }

    public void Deposit(Scanner sn) throws MyException {
        double money;
        System.out.println("Nhập số tiền cần gửi: ");
        money = sn.nextDouble();
        if (money > 0) {
            this.balance = balance + money;
            System.out.println("Gửi thành công!");
        } else {
            throw new MyException("Số tiền gửi không hơp lệ(Phải là số và lớn hơn 0)!");
        }
    }

    public void Withdraw(Scanner sn) throws MyException {
        double money;
        System.out.println("Nhập số tiền cần rút: ");
        money = sn.nextDouble();
        if (money < 0) {
            throw new MyException("Số tiền rút không hơp lệ(Phải là số và lớn hơn 0)!");
        } else if (this.balance < money) {
            System.out.println("Số dư: " + this.balance);
            throw new MyException("Số dư tài khoản không đủ!");
        } else {
            this.balance = balance - money;
            System.out.println("Rút tiền thành công!");
        }
    }

    public void Transfer(Scanner sn, ArrayList<BankAccount> list) throws MyException {
        double money;
        String account;
        boolean found = true;
        System.out.println("Nhập số tài khoản cần chuyển: ");
        account = sn.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).accountId.equalsIgnoreCase(account)) {
                System.out.println("Nhập số tiền cần chuyển: ");
                money = sn.nextDouble();
                sn.nextLine();
                if (money < 0) {
                    throw new MyException("Số tiền chuyển không hơp lệ(Phải là số và lớn hơn 0)!");
                } else if (this.balance < money) {
                    System.out.println("Số dư: " + this.balance);
                    throw new MyException("Số dư tài khoản không đủ!");
                } else {
                    this.balance = balance - money;
                    list.get(i).balance = list.get(i).balance + money;
                    System.out.println("Chuyển tiền thành công!");
                    found = false;
                    return;
                }
            }
        }
        if (found) {
            throw new MyException("Tài khoản không tồn tại!");
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountId='" + accountId + '\'' +
                ", balance=" + balance +
                '}';
    }
}
