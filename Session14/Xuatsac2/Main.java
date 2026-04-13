package Session14.Xuatsac2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        ArrayList<Product> list = new ArrayList<>();
        ShoppingCart sp = new ShoppingCart();
        int n;
        Product p1 = new Product("001", "Giày", 1000000);
        Product p2 = new Product("002", "Áo", 100000);
        Product p3 = new Product("003", "Quần", 2000000);
        Product p4 = new Product("004", "Đồng hồ", 2000000);
        Product p5 = new Product("005", "Máy tính", 15000000);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        while (true) {
            System.out.println("========== MENU ========== ");
            System.out.println("1. Xem danh sách sản phẩm");
            System.out.println("2. Thêm  sản phẩm vào giỏ hàng");
            System.out.println("3. Xóa sản phẩm khỏi giỏ hàng");
            System.out.println("4. Xem giỏ hàng");
            System.out.println("5. Thanh toán");
            System.out.println("0. Thoát");
            System.out.println("Lựa chọn của bạn: ");
            n = sn.nextInt();
            sn.nextLine();
            switch (n) {
                case 1:
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(list.get(i));
                    }
                    break;
                case 2:
                    boolean found = true;
                    String id;
                    String soluong;
                    int sl;
                    System.out.println("Bạn muốn thêm mã sản phẩm nào: ");
                    id = sn.nextLine();
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).id.equalsIgnoreCase(id)) {
                            CartItem cart = new CartItem();
                            cart.product = list.get(i);
                            System.out.println("Nhập số lượng: ");
                            while (true) {
                                try {
                                    soluong = sn.nextLine();
                                    sl = Integer.parseInt(soluong);
                                    sp.addToCart(cart.product, sl);
                                    found = false;
                                    break;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("Nhập lại số lượng");
                                }
                            }
                            break;
                        }
                    }
                    if(found){
                        System.out.println("Mã sản phẩm không tồn tại!");
                    }
                    break;
                case 3:
                    String productId;
                    System.out.println("Nhập mã sản phẩm muốn xóa: ");
                    productId = sn.nextLine();
                    try{
                        sp.removeFromCart(productId);
                    }catch(MyException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Danh sách sản phẩm trong giỏ hàng");
                    sp.displayCart();
                    break;
                case 5:
                    System.out.println("Số tiền phải thanh toán: ");
                    sp.checkout();
                    break;
                case 0:
                    System.out.println("Thoát chương trình...");
                    System.exit(0);
                default:
                    System.out.println("Nhập lại lựa chọn: ");

            }
        }
    }
}
