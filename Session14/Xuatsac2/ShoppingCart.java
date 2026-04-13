package Session14.Xuatsac2;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
public class ShoppingCart {
    protected  List<CartItem> list = new ArrayList<>();

    public void addToCart(Product product, int quantity){
        boolean found = true;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).product.id.equalsIgnoreCase(product.id)){
                System.out.println("Sản phẩm đã tồn tại!");
                list.get(i).quantity = list.get(i).quantity + quantity;
                System.out.println("Tăng số lượng thành công!  ");
                found = false;
                break;
            }
        }
        if(found) {
            CartItem cartItem = new CartItem();
            cartItem.product = product;
            cartItem.quantity = quantity;
            list.add(cartItem);
            System.out.println("Đã thêm sản phẩm "+product+" vào giỏ hàng");
        }
    }

    public void removeFromCart(String productId) throws MyException{
        Iterator<CartItem> it = list.iterator();
        boolean found = true;
        while(it.hasNext()){
            CartItem cartitem = it.next();
            if(cartitem.product.id.equalsIgnoreCase(productId)){
                it.remove();
                System.out.println("Sản phẩm đã được xóa!");
                found = false;
                break;
            }
        }
        if(found){
            throw new MyException("Lỗi: Không tìm thấy sản phẩm trong giỏ hàng!");
        }
    }

    public void displayCart(){
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Sản phẩm: "+list.get(i).product+
                    " | Số lương: "+list.get(i).quantity);
        }
    }

    public void checkout(){
        double tongtien = 0;
        for (int i = 0; i < list.size(); i++) {
            tongtien += list.get(i).product.price * list.get(i).quantity;
        }
        System.out.println(tongtien);
    }
}
