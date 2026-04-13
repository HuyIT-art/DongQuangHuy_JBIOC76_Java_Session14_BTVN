package Session14.Xuatsac1;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args){
        ArrayList<BankAccount> list = new ArrayList<>();
        Scanner sn = new Scanner(System.in);
        int n;
        int i = 0;
        while(true){
            System.out.println("========== MB Bank ==========");
            System.out.println("1. Nhập tài khoản");
            System.out.println("2. Xem danh sách tải khoản");
            System.out.println("3. Nhập tài khoản của bạn");
            System.out.println("4. Thoát");
            System.out.println("Lựa chọn của bạn là: ");
            n = sn.nextInt();
            sn.nextLine();
            switch(n){
                case 1:
                    System.out.println("Nhập số tài khoản là exit để dừng quá trình!");
                    String accounts;
                    do{
                        BankAccount account = new BankAccount();
                        System.out.println("Nhập tài khoản thứ "+(i+1));
                        System.out.println("Nhập số tài khoản: ");
                        while(true){
                            accounts = sn.nextLine();
                            try {
                                account.setAccountId(accounts);
                                if (accounts.equalsIgnoreCase("Exit")) {
                                    break;
                                }
                                break;
                            } catch (MyException e) {
                                System.out.println(e.getMessage());
                                System.out.println("Nhập lại số tài khoản: ");
                            }
                        }

                        if(!accounts.equalsIgnoreCase("Exit")){
                            System.out.println("Nhập số dư: ");
                            account.setBalance(sn.nextDouble());
                            sn.nextLine();
                            list.add(account);
                            i++;
                        }
                    }while(!accounts.equalsIgnoreCase("Exit"));
                    break;
                case 2:
                    System.out.println("Danh sách tài khoản");
                    for (int j = 0; j < list.size(); j++) {
                        System.out.println(list.get(j).toString());
                    }
                    break;
                case 3:
                    BankAccount myAccount = new BankAccount();
                    System.out.println("Nhập tài khoản của bạn: ");
                    while(true){
                        try{
                            myAccount.setAccountId(sn.nextLine());
                            break;
                        }catch(MyException e){
                            System.out.println(e.getMessage());
                            System.out.println("Nhập lại số tài khoản: ");
                        }
                    }
                    System.out.println("Nhập số dư: ");
                    while(true){
                        try{
                            myAccount.setBalance(sn.nextDouble());
                            sn.nextLine();
                            break;
                        }catch(MyException e){
                            System.out.println(e.getMessage());
                            System.out.println("Nhập lại số dư: ");
                        }
                    }
                    int m;
                    while(true){
                        System.out.println("1. Gửi tiền");
                        System.out.println("2. Rút tiền");
                        System.out.println("3. Chuyển tiền");
                        System.out.println("4. Xem tài khoản");
                        System.out.println("5. Thoát");
                        System.out.println("Lựa chọn của bạn: ");
                        m = sn.nextInt();
                        sn.nextLine();
                        int k = 0;
                        switch(m){
                            case 1:
                                try{
                                    myAccount.Deposit(sn);
                                }catch(MyException e){
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 2:
                                try{
                                    myAccount.Withdraw(sn);
                                }catch(MyException e){
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 3:
                                try{
                                    myAccount.Transfer(sn, list);
                                }catch(MyException e){
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 4:
                                System.out.println("Tài khoản của ban: ");
                                System.out.println(myAccount.toString());
                                break;
                            case 5:
                                k = 5;
                                break;
                            default:
                                System.out.println("Nhập lại lựa chọn: ");
                                break;
                        }
                        if(k == 5){
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Thoát chương trình...");
                    System.exit(0);
                default:
                    System.out.println("Nhập lại lựa chọn của bạn: ");
            }
        }
    }
}
