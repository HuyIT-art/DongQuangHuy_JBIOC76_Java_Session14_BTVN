package Session14;
import java.util.ArrayList;
import java.util.Scanner;
public class Kha2 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            ArrayList<String> inputList = new ArrayList<>();
            ArrayList<Integer> validNumbers = new ArrayList<>();

            int invalidCount = 0;

            // Nhập dữ liệu
            System.out.println("Nhập các chuỗi (gõ 'exit' để kết thúc):");
            while (true) {
                String input = sc.nextLine();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                inputList.add(input);
            }

            // Xử lý chuyển đổi
            for (String s : inputList) {
                try {
                    int number = Integer.parseInt(s);
                    validNumbers.add(number);
                } catch (NumberFormatException e) {
                    invalidCount++;
                }
            }

            // Kết quả
            System.out.println("Số chuỗi hợp lệ: " + validNumbers.size());
            System.out.println("Số chuỗi không hợp lệ: " + invalidCount);

            System.out.println("Danh sách số nguyên hợp lệ:");
            for (int num : validNumbers) {
                System.out.print(num + " ");
            }
        }
    }
