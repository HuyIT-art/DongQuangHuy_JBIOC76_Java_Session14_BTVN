package Session14;
import java.util.Scanner;

public class Gioi1 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int balance = 1000000;     // số dư ban đầu
            final int MIN_BALANCE = 50000;

            while (true) {
                try {
                    System.out.print("Nhập số tiền muốn rút: ");
                    int withdraw = Integer.parseInt(sc.nextLine());

                    // kiểm tra hợp lệ
                    if (withdraw <= 0) {
                        System.out.println("Lỗi: Số tiền rút phải lớn hơn 0!");
                        continue;
                    }

                    if (withdraw > balance) {
                        System.out.println("Lỗi: Số tiền rút vượt quá số dư!");
                        continue;
                    }

                    if (balance - withdraw < MIN_BALANCE) {
                        System.out.println("Lỗi: Tài khoản phải duy trì số dư tối thiểu 50.000 đồng!");
                        continue;
                    }

                    balance -= withdraw;
                    System.out.println("Rút tiền thành công.");
                    System.out.println("Số tiền đã rút: " + withdraw);
                    System.out.println("Số dư còn lại: " + balance);
                    break;

                } catch (NumberFormatException e) {
                    System.out.println("Lỗi: Vui lòng nhập một số hợp lệ!");
                }
            }
        }
    }
