package Session14.Gioi1;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int n;
        TaiKhoan tk = new TaiKhoan();
        double soTienRut;
        Scanner sn = new Scanner(System.in);
        System.out.println("Nhập dữ liệu cho tài khoản: ");
        while (true) {
            try {
                System.out.println("Nhập loại tài khoản(MBBank, Vietcombank, Techombank, Agribank)");
                String t = sn.nextLine();
                tk.loai = TaiKhoan.the.valueOf(t);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Nhập lại: ");
            }
        }
        while (true) {
            try {
                System.out.println("Nhập số tài khoản(03373 + 12345): ");
                tk.setSoTaiKhoan(sn.nextLine());
                break;
            } catch (MyException e) {
                throw new MyException(e.getMessage());
            }
        }
        while (true) {
            System.out.println("Bạn muốn rút tiền không?");
            System.out.println("1. CÓ");
            System.out.println("2. Không");
            System.out.println("3. Xem số dư hiện tại: ");
            System.out.println("Lựa chọn của bạn là: ");
            n = sn.nextInt();
            sn.nextLine();
            switch (n) {
                case 1:
                    try {
                        System.out.println("Nhập số tiền muốn rút: ");
                        soTienRut = sn.nextDouble();
                        sn.nextLine();
                        tk.setSoDu(soTienRut);
                        System.out.println("Rút thành công!");
                    } catch (MyException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Thoát!");
                    System.exit(0);
                    break;
                case 3:
                    System.out.println("Số dư của bạn là: "+ tk.soDu);
                default:
                    System.out.println("Nhập lại lựa chọn: ");
            }
        }
    }
}
