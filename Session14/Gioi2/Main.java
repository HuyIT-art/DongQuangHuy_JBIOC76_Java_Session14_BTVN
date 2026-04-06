package Session14.Gioi2;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> validList = new ArrayList<>();
        ArrayList<String> invalidList = new ArrayList<>();

        System.out.println("Nhập danh sách số điện thoại (cách nhau bằng dấu phẩy):");
        String input = sc.nextLine();

        // tách chuỗi
        String[] phones = input.split(",");

        for (String p : phones) {
            String phone = p.trim(); // loại khoảng trắng

            try {
                InvalidPhoneNumberException.validate(phone);
                validList.add(phone);
            } catch (InvalidPhoneNumberException e) {
                invalidList.add(phone + " - " + e.getMessage());
            }
        }

        // hiển thị kết quả
        System.out.println("\nDanh sách hợp lệ:");
        for (String s : validList) {
            System.out.println(s);
        }

        System.out.println("\nDanh sách không hợp lệ:");
        for (String s : invalidList) {
            System.out.println(s);
        }
    }
}
