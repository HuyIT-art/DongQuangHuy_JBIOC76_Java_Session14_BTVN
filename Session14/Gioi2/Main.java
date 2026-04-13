package Session14.Gioi2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        ArrayList<String> listHopLe = new ArrayList<>();
        ArrayList<String> listKhongHopLe = new ArrayList<>();
        String chuoi;
        System.out.println("Nhập danh sách số điện thoại(Mỗi số điện thoại tách nhau bằng dấu phẩy)");
        chuoi = sn.nextLine();
        String[] arr = chuoi.split(",");
        for (int i = 0; i < arr.length; i++) {
            try{
                InvalidPhoneNumberLengthException.validatePhoneNumber(arr[i].trim());
                listHopLe.add(arr[i].trim());
            }catch(InvalidPhoneNumberLengthException e){
                listKhongHopLe.add("- "+arr[i].trim()+": "+e.getMessage());
            }
        }
        System.out.println("Số điện thoại hợp lệ: ");
        for (int i = 0; i < listHopLe.size(); i++) {
            System.out.println("- "+listHopLe.get(i));
        }
        System.out.println();
        System.out.println("Số điện thoại không hợp lệ: ");
        for (int i = 0; i < listKhongHopLe.size(); i++) {
            System.out.println(listKhongHopLe.get(i));
        }
    }
}
