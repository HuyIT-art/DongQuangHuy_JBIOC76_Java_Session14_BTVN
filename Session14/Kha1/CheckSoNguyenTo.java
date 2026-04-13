package Session14.Kha1;
import java.util.Scanner;
import java.util.*;
class MyException extends RuntimeException{
    public MyException(){

    }
    public MyException(String message){
        super(message);
    }

}

public class CheckSoNguyenTo {
    public static void check(int songuyen) {
        if (songuyen == 1) {
            System.out.println(songuyen + " không phải là số nguyên tố !");
            return;
        }
        for (int i = 2; i <= Math.sqrt(songuyen); i++) {
                if (songuyen % i == 0) {
                    System.out.println(songuyen + " không phải là số nguyên tố !");
                    return;
                }
            }
                System.out.println(songuyen + " là số nguyên tố !");
        }
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        String n;
        int songuyen;
        System.out.println("Nhập số nguyên: ");
        while (true) {
            try {
                n = sn.nextLine();
                songuyen = Integer.parseInt(n);
                if (songuyen <= 0) {
                    throw new MyException("Không hợp lệ, số nguyên phải > 0 !");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Không phải số!");
                System.out.println("Nhập lại: ");

            } catch (MyException e) {
                System.out.println(e.getMessage());
                System.out.println("Nhập lại: ");
            }
        }
        System.out.println("Kiểm tra....");
        check(songuyen);
    }
}
