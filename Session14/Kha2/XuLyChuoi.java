package Session14.Kha2;
import java.util.Scanner;
import java.util.ArrayList;
public class XuLyChuoi {
    public static void main(String[] args) {

        ArrayList<String> listString = new ArrayList<>();
        ArrayList<Integer> listInt = new ArrayList<>();
        Scanner sn = new Scanner(System.in);
        int hople = 0, j = 1;
        int khonghople = 0;
        String chuoi;
        System.out.println("Nhâp danh sách chuỗi(Exit để dừng quá trình nhập !)");
        while(true){
            System.out.println("Nhập chuỗi thứ "+j);
            chuoi = sn.nextLine();
            if(chuoi.equalsIgnoreCase("Exit")){
                break;
            }
            listString.add(chuoi);
            j++;
        }
        System.out.println("Lọc chuỗi...");
        for (int i = 0; i < listString.size(); i++) {
            int a = 0;
            System.out.println("Chuỗi "+(i+1));
            try {
                int value = Integer.parseInt(listString.get(i));
                listInt.add(value);
                System.out.println("Hợp lệ!");
                hople++;
            } catch(NumberFormatException e){
                System.out.println("Không hợp lệ!");
                khonghople++;
            }
        }
        System.out.println(listString);
        System.out.println("Số chuỗi hợp lệ: "+hople);
        System.out.println("Số chuỗi không hợp lệ: "+khonghople);
        System.out.print("Danh sách số nguyên hợp lệ:"+listInt);

    }
}
