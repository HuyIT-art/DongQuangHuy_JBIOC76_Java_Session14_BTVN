package Session14;
import java.util.Scanner;

public class Kha1 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n;

            while (true) {
                try {
                    System.out.print("Nhập một số nguyên: ");
                    n = Integer.parseInt(sc.nextLine());

                    if (n <= 0) {
                        System.out.println("Số phải lớn hơn 0 để kiểm tra số nguyên tố.");
                        continue;
                    }

                    if (isPrime(n)) {
                        System.out.println(n + " là số nguyên tố.");
                    } else {
                        System.out.println(n + " không phải là số nguyên tố.");
                    }
                    break;

                } catch (NumberFormatException e) {
                    System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập số nguyên.");
                }
            }
        }

        public static boolean isPrime(int n) {
            if (n < 2) return false;

            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
